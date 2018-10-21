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
public class DivisionFieldCalculator extends Calculator {

    public DivisionFieldCalculator(Operation o) {
        super(o);
    }

    //Find inverse of b and multiply by a to get a/b (read: 1/b * a = inverse of b * a)
    int[] doDivisionField(int[] a, int[] b, int p, int[] modPoly)	{
    	a = div(a, modPoly, p, "r");
    	b = div(b, modPoly, p, "r");
    	int[] inverse = inverse(b, p, modPoly);
    	int[] result = fieldMul(a, inverse, p, modPoly);
    	return result;
    }
    
    @Override
    void calculate() {
        o.answer = doDivisionField(o.a, o.b, o.p, o.modPoly);
    }
}
