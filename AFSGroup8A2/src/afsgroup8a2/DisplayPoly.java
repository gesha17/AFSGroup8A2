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
public class DisplayPoly extends Calculator {
    
    public DisplayPoly(Operation o){
        super(o);
    }

    String doDisplayPoly(int[] f, int p)	{
    	int[] zero = {0};
    	f = add(f, zero, p);
    	String result = "";
    	
    	//deals with the exception of not having an input
    	if (f.length < 1) {
    		return "0";
    	}
    	f = removeLeadingZeros(f);
    	
    	//iterate from back to front and write part of the polynomial to the string
    	for (int i = f.length-1; i >= 0; i--)	{
    		
	    		//deal with coefficients and power of x
	    		if (f[i] != 0)	{
	    			
	    			//power
	    	 		if (i != f.length-1)	{
    	    			if (i == f.length-2) {
    	    				result = "X" + result;
    	    			} else {
    	    				result = "X^" + ((f.length-1)-i) + result;
    	    			}
    	    		}
	    	 		
	    	 		//coefficient
	    			if (Math.abs(f[i]) != 1 || i == f.length-1)	{
	    				result = (Math.abs(f[i])) + result;
	    			}
	    		
	    		//deal with the + and - signs
	    		if (f[i] < 0)	{
	    			result = "-" + result;
	    		} else if (i != 0)	{
	    			result = "+" + result;
	    		}
	    		
	    	}
    	}
    	
    	//deals with the exception of having only 0 coefficients
    	if (result.equals(""))	{
    		result = "0";
    	}
    	return result;
    }
    
    @Override
    void calculate() {
        o.answerstring = doDisplayPoly(o.f, o.p);
    }    
}
