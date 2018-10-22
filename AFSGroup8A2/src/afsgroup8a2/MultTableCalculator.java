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
public class MultTableCalculator extends Calculator {

    public MultTableCalculator(Operation o) {
        super(o);
    }

    int[][][] doMultTable(int p, int[] modPoly)	{
    	//create array with all elements of a field
    	int n = (int) (Math.pow(p, degree(modPoly)));
    	int[][] elements = new int[n][];
    	
    	//fill int[] elements with all elements in the field
    	for (int i = 0; i < n; i++)	{
    		int number = i;		//denotes the i'th element, which we will "transform into base p" to get the i'th polynomial
    		
    		//fill the element of maximum degree one lower than modPoly with 0's (so we can remove leading zeros later)
    		int[] element = new int[degree(modPoly)];
    		for (int k = 0; k < degree(modPoly); k++)	{
    			element[k] = 0;
    		}
    		
    		//fill the element from lowest to highest power by taking r and q from number/p (conversion to base p)
    		int j = element.length - 1;
    		while (number > 0)	{
    			element[j] = (number % p);
    			number = (int) (Math.floor(number/p));
    			j--;
    		}
    		elements[i] = removeLeadingZeros(element);
    	}
    	
    	int[][][] result = new int[n][n][];
    	for (int i = 0; i < n; i++)	{
    		for (int j = 0; j < n; j++)	{
    			result[i][j] = fieldMul(elements[i], elements[j], p, modPoly);
    		}
    	}
    	return result;
    }
    
    @Override
    void calculate() {
        o.answertable = doMultTable(o.p, o.modPoly);
    }
}