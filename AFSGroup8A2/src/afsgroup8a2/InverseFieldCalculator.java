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
public class InverseFieldCalculator extends Calculator {

    public InverseFieldCalculator(Operation o) {
        super(o);
    }

    //finds the inverse of a + (d) in field Fp[x]/(d) (Algorithm 2.3.3) or returns null if it does not exist
    int[] findInverse(int[] a, int[] d, int p)	{
    	int[] one = {1};
    	if (Arrays.equals(euclid(a, d, p, "d"), one))	{
    		return euclid(a, d, p, "a");
    	} else	{
    		return null;
    	}
    }
    
    @Override
    void calculate() {
    	o.answer = findInverse(o.a, o.modPoly, o.p);
    }
}
