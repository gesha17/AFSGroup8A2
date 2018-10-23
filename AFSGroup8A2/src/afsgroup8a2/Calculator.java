/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsgroup8a2;

import java.util.Arrays;

import afsgroup8a2.Operation.OperationType;

/**
 *
 * @author s165700
 */
public abstract class Calculator {
    Operation o;
    
    Calculator(Operation o){
    	this.o = o;
    }
    
    int[] add(int[] f, int[] g, int p)	{
	    Operation o = new Operation();
		o.f = f;
		o.g = g;
		o.p = p;
		o.type = OperationType.Add;
		Calculator.doCalculation(o);
		return o.answer;
    }
    
    int[] sub(int[] f, int[] g, int p)	{
	    Operation o = new Operation();
		o.f = f;
		o.g = g;
		o.p = p;
		o.type = OperationType.Subtract;
		Calculator.doCalculation(o);
		return o.answer;
    }
    
    int[] mul(int[] f, int[] g, int p)	{
	    Operation o = new Operation();
		o.f = f;
		o.g = g;
		o.p = p;
		o.type = OperationType.Multiply;
		Calculator.doCalculation(o);
		return o.answer;
    }
    
    int[] div(int[] f, int[] g, int p, String a)	{
    	Operation o = new Operation();
    	o.f = f;
    	o.g = g;
    	o.p = p;
    	o.type = OperationType.LongDiv;
    	Calculator.doCalculation(o);
    	if (a.equals("r"))	{
    		return o.answerr;
    	} else {
    		return o.answerq;
    	}
    }
    
    int[] euclid(int[] f, int[] g, int p, String a)	{
    	Operation o = new Operation();
    	o.f = f;
    	o.g = g;
    	o.p = p;
    	o.type = OperationType.Euclid;
    	Calculator.doCalculation(o);
    	if (a.equals("a"))	{
    		return o.answera;
    	} else if (a.equals("b"))	{
    		return o.answerb;
    	} else	{
    		return o.answerd;
    	}
    }
    
    boolean isIrreducible(int[] f, int p)	{
    	Operation o = new Operation();
    	o.f = f;
    	o.p = p;
    	o.type = OperationType.Irreducible;
    	Calculator.doCalculation(o);
    	return o.answerboolean;
    }
    
    boolean isPrimitive(int[] a, int p, int[] modPoly)	{
    	Operation o = new Operation();
    	o.a = a;
    	o.p = p;
    	o.modPoly = modPoly;
    	o.type = OperationType.Primitive;
    	Calculator.doCalculation(o);
    	return o.answerboolean;
    }
    
    int[] inverse(int[] a, int p, int[] modPoly)	{
    	Operation o = new Operation();
    	o.a = a;
    	o.p = p;
    	o.modPoly = modPoly;
    	o.type = OperationType.InverseField;
    	Calculator.doCalculation(o);
    	return o.answer;
    }
    
    int[] fieldAdd(int[] a, int[] b, int p, int[] modPoly)	{
    	Operation o = new Operation();
    	o.a = a;
    	o.b = b;
    	o.p = p;
    	o.modPoly = modPoly;
    	o.type = OperationType.AddField;
    	Calculator.doCalculation(o);
    	return o.answer;
    }
    
    int[] fieldSub(int[] a, int[] b, int p, int[] modPoly)	{
    	Operation o = new Operation();
    	o.a = a;
    	o.b = b;
    	o.p = p;
    	o.modPoly = modPoly;
    	o.type = OperationType.SubtractField;
    	Calculator.doCalculation(o);
    	return o.answer;
    }
    
    int[] fieldMul(int[] a, int[] b, int p, int[] modPoly)	{
    	Operation o = new Operation();
    	o.a = a;
    	o.b = b;
    	o.p = p;
    	o.modPoly = modPoly;
    	o.type = OperationType.MultField;
    	Calculator.doCalculation(o);
    	return o.answer;
    }
    
    String display(int[] f)	{
    	Operation o = new Operation();
    	o.f = f;
    	o.type = OperationType.Display;
    	Calculator.doCalculation(o);
    	return o.answerstring;
    }
    
    int degree(int[] a)	{
    	a = removeLeadingZeros(a);
    	return (a.length - 1);
    }
    
    //flips the sign of each coefficient in an int[]
    int[] flipSigns(int[] a)	{
    	for (int i = 0; i < a.length; i++) {
    		a[i] = 0 - a[i];
    	}
    	return a;
    }
    
    //adds leading zeros to the polynomial (so x^l exists with coefficent 0 while calculating)
    int[] paddAtoL(int[] a, int l)	{
    	
    	//To avoid crashes on wrong input
    	if (l <= a.length)	{
    		return a;
    	}
    	
    	//Initialize resulting array with only zeros
    	int[] r = new int[l];
        for (int i = 0; i < l; i++) {
            r[i] = 0;
        }
        
        //fill applicable values of a into r
        for (int i = 1; i <= a.length; i++)	{
        	r[r.length-i] = a[a.length-i];    	
        }
        return r;
    }
    
    //removes any leading zero coefficents from a polynomial
    int[] removeLeadingZeros(int[] a)	{
    	if (a.length == 1) {
            return a;
        }
    	//find out how many leading zeros there are
    	int i = 0;
    	while (a[i] == 0)	{
    		i++;
    		if (i == a.length-1)	{
    			break;
    		}
    	}
    	
    	//create new array with i less elements
    	int[] b = new int[a.length-i];
    	
    	//fill new array with old values
    	for (int j = 0; j < b.length; j++)	{
    		b[b.length-1-j] = a[a.length-1-j];
    	}
    	return b;
    }
    
    abstract void calculate();
    
    static void doCalculation(Operation o){
        if(o.type == null) throw new IllegalStateException("Type of operation cannot be null");
        switch(o.type){
            case Display:
                if(o.f == null){
                    o.answerstring = "{}";
                }else new DisplayPoly(o).calculate();
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
            case EqualsPolyMod:
                new EqualsPolyModCalculator(o).calculate();
                break;
            case AddTable:
                new AddTableCalculator(o).calculate();
                break;
            case MultTable:
                new MultTableCalculator(o).calculate();
                break;
            case DisplayField:
                new DisplayFieldCalculator(o).calculate();
                break;
            case AddField:
                new AddFieldCalculator(o).calculate();
                break;
            case SubtractField:
                new SubtractFieldCalculator(o).calculate();
                break;
            case MultField:
                new MultFieldCalculator(o).calculate();
                break;
            case InverseField:
                new InverseFieldCalculator(o).calculate();
                break;
            case DivisionField:
                new DivisionFieldCalculator(o).calculate();
                break;
            case EqualsField:
                new EqualsFieldCalculator(o).calculate();
                break;
            case Primitive:
                new PrimitiveCalculator(o).calculate();
                break;
            case FindPrim:
                new FindPrimCalculator(o).calculate();
                break;
        }
    }
}
