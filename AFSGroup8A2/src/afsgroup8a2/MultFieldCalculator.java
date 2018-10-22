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
public class MultFieldCalculator extends Calculator {

    public MultFieldCalculator(Operation o) {
        super(o);
    }

    int[] doMultField(int[] a, int[] b, int p, int[] modPoly)	{
    	int[] result = mul(a, b, p);
    	result = div(result, modPoly, p, "r");
    	return removeLeadingZeros(result);
    }
    
    @Override
    void calculate() {
        o.answer = doMultField(o.a, o.b, o.p, o.modPoly);
    }    
}
