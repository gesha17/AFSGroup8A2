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
public class MultiplicationCalculator extends Calculator {

    public MultiplicationCalculator(Operation o) {
        super(o);
    }
	
	//multiplies polynomials x and y mod integer p
    int[] mulPolynomials(int[] x, int[] y, int p)	{
    	int c; //coefficient
    	int pow; //power of x
    	
    	//padd x and y to the same length (so coefficients can be added)
    	int maxLength = Math.max(x.length, y.length);
    	x = paddAtoL(x, maxLength);
    	y = paddAtoL(y, maxLength);
    	
    	//create resulting array by multiplying the polynomials using the high school multiplication method
    	int[] result = new int[maxLength];
    	
    	//iterate over all coefficients in x starting at the end
    	for (int i = x.length - 1; i >= 0; i--)	{
    		
    		//iterate over all coefficients in y starting at the end
    		for (int j = y.length - 1; j >= 0; j--)	{
				c = (x[i] * y[j]) % p; //modular multiplication of integers
    			pow = i + j;		//add the powers when multiplying
    			result = paddAtoL(result, pow + 1);	//padd the resulting array to pow + 1 to fit the newly created power of x
    			result[result.length - 1 - pow] = result[result.length - 1 - pow] + c;	//stores the coefficient at the correct position in the resulting array
    		}
    	}
    	return result;
    }

    int[] paddAtoL(int[] a, int l)	{
    	
    	//To avoid crashes on wrong input
    	if (l <= a.length)	{
    		return a;
    	}
    	
    	//Initialize resulting array with only zeros
    	int[] r = new int[l];
        for (int i = 0; i < l; i++) {
            r[i] = 0;
        }
        
        //fill applicable values of a into r
        for (int i = 1; i <= a.length; i++)	{
        	r[r.length-i] = a[a.length-i];    	
        }
        return r;
    }
    
    //flips the sign of each coefficient in an int[]
    int[] flipSigns(int[] a)	{
    	for (int i = 0; i < a.length; i++) {
    		a[i] = 0 - a[i];
    	}
    	return a;
    }    
    
    @Override
    void calculate() {
    	o.answer = mulPolynomials(o.f, o.g, o.p);
    }
    
}
