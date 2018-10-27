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
public class DisplayFieldCalculator extends Calculator{

    public DisplayFieldCalculator(Operation o) {
        super(o);
    }

    //returns a (string) representative of a in field Fp[x]/modPoly
    String doDisplayField(int[] a, int p, int[] modPoly)	{
    	int[] reduction = div(a, modPoly, p, "r");
    	return display(reduction, p);
    }
    
    @Override
    void calculate() {
       o.answerstring = doDisplayField(o.a, o.p, o.modPoly);
    }
}
