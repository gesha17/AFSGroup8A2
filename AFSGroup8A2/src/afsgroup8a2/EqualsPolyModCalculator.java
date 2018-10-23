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
public class EqualsPolyModCalculator extends Calculator {

    public EqualsPolyModCalculator(Operation o) {
        super(o);
    }

    //finds out if polynomials f and g are equal modulo polynomial h by subtracting
    boolean doIsEqual(int[] f, int[] g, int p, int[] h)	{
        int[] zero = {0};

        //subtract f from g and see if the result is 0 (or a multiple of h since we're reducing by h)
        int[] result = sub(f, g, p); 
        if (h != null)	{
        result = div(result, h, p, "r");
        }
        if (Arrays.equals(result, zero))	{
                return true;
        } else {
                return false;
        }	
    }

    @Override
    void calculate() {
       o.answerboolean = doIsEqual(o.f, o.g, o.p, o.h);
    }
}
