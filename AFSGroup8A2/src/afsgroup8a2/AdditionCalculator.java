/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsgroup8a2;

/**
 *
 * @author s165700
 */
public class AdditionCalculator extends Calculator {

    public AdditionCalculator(Operation o) {
        super(o);
    }

  //adds polynomials x and y to each other mod integer p
    int[] addPolynomials(int[] x, int[] y, int p)	{
  	
    	//padd x and y to the same length (so coefficents can be added)
    	int maxLength = Math.max(x.length, y.length);
    	x = paddAtoL(x, maxLength);
    	y = paddAtoL(y, maxLength);
    	
    	//create resulting arary by adding coefficents of y to x
    	int[] result = new int[maxLength];
    	for (int i = 0; i < result.length; i++)	{
    		result[i] = (x[i] + y[i]) % p;
    		if (result[i] < 0) {
    			result[i] = result[i] + p;
    		}
    	}

    	return result;
    }

    //subtracts y from x modulo integer p
    void subPolynomials(int[] x, int[] y, int p) {
    	y = flipSigns(y);
    	addPolynomials(x, y, p);
    }
    
    //adds leading zeros to the polynomial (so x^l exists with coefficent 0 while calculating)
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
    	o.answer = addPolynomials(o.f, o.g, o.p);
    }
    
}
