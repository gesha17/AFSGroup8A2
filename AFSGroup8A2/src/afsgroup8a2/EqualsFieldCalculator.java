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
public class EqualsFieldCalculator extends Calculator{

    public EqualsFieldCalculator(Operation o) {
        super(o);
    }

    //finds out if polynomials a and b are equal in the field Fp[x]/modPoly by subtracting
    boolean doIsEqual(int[] a, int[] b, int p, int[] modPoly)	{
    	int[] zero = {0};
    	
    	//subtract b from a and see if the result is 0 (or a multiple of modPoly since we're using field subtraction)
    	int[] result = fieldSub(a, b, p, modPoly);
    	if (Arrays.equals(result, zero))	{
    		return true;
    	} else {
    		return false;
    	}	
    }
    
    @Override
    void calculate() {
        o.answerboolean = doIsEqual(o.a, o.b, o.p, o.modPoly);
    }
}