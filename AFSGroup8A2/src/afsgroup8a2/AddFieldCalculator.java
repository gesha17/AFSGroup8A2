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
public class AddFieldCalculator extends Calculator {

    public AddFieldCalculator(Operation o) {
        super(o);
    }

    //Does addition and then reduces by modPoly
    int[] doAddField(int[] a, int[] b, int p, int[] modPoly) {
    	int[] result = add(a, b, p);
    	result = div(result, modPoly, p, "r");
    	return removeLeadingZeros(result);
    }
    
    @Override
    void calculate() {
    	o.answer = doAddField(o.a, o.b, o.p, o.modPoly);
    }    
}
