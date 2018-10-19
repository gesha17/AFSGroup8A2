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
public class IrreducibleCalculator extends Calculator {

    public IrreducibleCalculator(Operation o) {
        super(o);
    }

    //Finds out if polynomial f is irreducible modulo p using Algorithm 4.1.4
    void doIsIrreducible(int[] f, int p)	{
    	int t = 1;
    	int[] one = {1};
    	int[] f2;
    	
    	//initialize f2 = x^p^t - x
    	f2 = createF2(t, p);
    	
    	while (Arrays.equals(euclid(f, f2, p, "d"), one)) {
    		t = t + 1;
    		
    		//update f2
    		f2 = createF2(t, p);	
    	}
    	
    	//return true or false
    	if (t == degree(f))	{
    		o.answerboolean = true;
    	} else {
    		o.answerboolean = false;
    	}
    }
    
    //create x^q^t - x polynomial
    int[] createF2(int t, int p)	{
    	int[] r = new int[(int) (Math.pow(p, t)+1)];	//Create array of degree q^t
    	r[0] = 1;										//x^q^t has coefficient 1
    	r[r.length-2] = -1;								//x has coefficient -1
    	return r;
    }
    
    @Override
    void calculate() {
    	doIsIrreducible(o.f, o.p);
    }    
}
