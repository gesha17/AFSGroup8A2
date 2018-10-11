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
    	result = removeLeadingZeros(result);
    	return result;
    }
    
    @Override
    void calculate() {
    	o.answer = addPolynomials(o.f, o.g, o.p);
    }
    
}
