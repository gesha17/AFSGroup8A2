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
public class SubtractFieldCalculator extends Calculator {

    public SubtractFieldCalculator(Operation o) {
        super(o);
    }

    int[] doSubtractField(int[] a, int[] b, int p, int[] modPoly)	{
    	int[] result = sub(a, b, p);
    	result = div(result, modPoly, p, "r");
    	return result;
    }
    
    @Override
    void calculate() {
       o.answer = doSubtractField(o.a, o.b, o.p, o.modPoly);
    }
}
