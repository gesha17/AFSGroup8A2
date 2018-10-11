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
public class AFSGroup8A2 {

    void init(){
    	int[] f = {1, 0, 1};
    	int[] g = {1, 0, 1};
    	int p = 100;
    	
    	
    	Operation o = new Operation();
    	o.f = f;
    	o.g = g;
    	o.p = p;
    	o.type = OperationType.Subtract;
    	Calculator.doCalculation(o);
    	System.out.println(Arrays.toString(o.answer));	
    }
    
    
    public static void main(String[] args) {
        AFSGroup8A2 program = new AFSGroup8A2();
        program.init();
    }
    
}
