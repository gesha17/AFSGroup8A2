/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsgroup8a2;

import javax.jws.Oneway;

import afsgroup8a2.Operation.OperationType;

/**
 *
 * @author s165700
 */
public class SubtractionCalculator extends Calculator {
    
    public SubtractionCalculator(Operation o) {
        super(o);
    }

    //subtracts y from x modulo integer p
    int[] subPolynomials(int[] x, int[] y, int p) {
    	y = flipSigns(y);
    	Operation oNew = o;
    	oNew.g = y;
    	oNew.type = OperationType.Add;
    	Calculator.doCalculation(oNew);
    	return oNew.answer;
    }
    
    @Override
    void calculate() {
        o.answer = subPolynomials(o.f, o.g, o.p);
    }
    
}
