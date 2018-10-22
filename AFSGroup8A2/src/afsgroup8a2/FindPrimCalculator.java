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
public class FindPrimCalculator extends Calculator {

    public FindPrimCalculator(Operation o) {
        super(o);
    }

    //finds a primitive polynomial in field Fp[x]/modPoly
    int[] doFindPrimitive(int p, int[] modPoly)	{
    	
    	//create polynomial of degree one lower than modPoly
    	int d = degree(modPoly) - 1;
    	int[] result = new int[d+1];
    	int[] zero = {0};
    	
    	do	{
    		
    		//fill result with random coefficients between 0 and p
    		for (int i = 0; i < result.length; i++)	{
    			result[i] = (int) (Math.floor(Math.random() * p));
    		}
    		
    		//make sure the empty polynomial was not accidentally picked
    		if (Arrays.equals(result, zero))	{
    			result[0] = 1;
    		}
    		
    	//test for primitivity
    	} while (!isPrimitive(result, p, modPoly));
    	
    	//return polynomial if it is a primitive element;
    	return removeLeadingZeros(result);
    }
    
    @Override
    void calculate() {
        o.answer = doFindPrimitive(o.p, o.modPoly);
    }
}
