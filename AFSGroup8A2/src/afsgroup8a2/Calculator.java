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
public abstract class Calculator {
    Operation o;
    
    Calculator(Operation o){
        
    }
    
    abstract void calculate();
    
    static void doCalculation(Operation o){
        if(o.type == null) throw new IllegalStateException("Type of operation cannot be null");
        switch(o.type){
            case Display:
                new DisplayPoly(o).calculate();
                break;
            case Add:
                new AdditionCalculator(o).calculate();
                break;
            case Subtract:
                new SubtractionCalculator(o).calculate();
                break;
            case Multiply:
                new MultiplicationCalculator(o).calculate();
                break;
            case LongDiv:
                new LongDivCalculator(o).calculate();
                break;
            case Euclid:
                new EuclidCalculator(o).calculate();
                break;
            case Irreducible:
                new IrreducibleCalculator(o).calculate();
                break;
            case FindIrred:
                new FindIrredCalculator(o).calculate();
                break;
        }
    }
}
