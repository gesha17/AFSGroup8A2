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
public class FindIrredCalculator extends Calculator {

    public FindIrredCalculator(Operation o) {
        super(o);
    }

    //finds an irreducible polynomial of degree d modulo p
    void doFindIrreducible(int d, int p)	{
    	int[] result = new int[d+1];
    	
    	do	{
    		
    		//fill result with random coefficients between 0 and p
    		for (int i = 0; i < result.length; i++)	{
    			result[i] = (int) (Math.floor(Math.random() * p));
    		}
    		
    	//test for irreducibility
    	} while (!isIrreducible(result, p));
    	
    	//return polynomial if it is irreducible;
    	o.answer = result;
    }
    
    @Override
    void calculate() {
    	//doFindIrreducible(o.d, o.p);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
