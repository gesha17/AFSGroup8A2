/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsgroup8a2;

import java.util.Arrays;

/**
 *
 * @author s165700
 */
public class PrimitiveCalculator extends Calculator {

    public PrimitiveCalculator(Operation o) {
        super(o);
    }

    //Checks for primitivity of polynomial a in field Fp[x]/modPoly using a simpler version of Algorithm 3.4.3
    boolean doIsPrimitive(int[] a, int p, int[] modPoly)	{
    	
    	//n = q - 1
    	int n = (int) (Math.pow(p, degree(modPoly)) - 1);
    	int[] originalA = a;
    	int[] one = {1};
    	for (int i = 1; i < n; i++)	{
    		System.out.println(i);
    		//if a^i equals 1 in the field return false (as long as i <= q - 1
    		a = div(a, modPoly, p, "r");
    		System.out.println(Arrays.toString(a));
    		if (Arrays.equals(a, one))	{
    			return false;
    		} else {
    			
    			//increase i by one and therefore multiply a^i by a
    			a = fieldMul(a, originalA, p, modPoly);
    		}
    	}
    	
    	//return true if no i < q - 1 causes a^i to equal 1
    	return true;
    }
    
    @Override
    void calculate() {
        o.answerboolean = doIsPrimitive(o.a, o.p, o.modPoly);
    }    
}
