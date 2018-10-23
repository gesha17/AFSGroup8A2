/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsgroup8a2;

import java.util.Arrays;

import afsgroup8a2.Operation.OperationType;
import java.util.ArrayList;

/**
 *
 * @author s165700
 */
public class AFSGroup8A2 {

    void init(){
        InputReader reader = new InputReader();
    	ArrayList<Operation> operations = reader.getInput();
        for(Operation o : operations){
            if(o.type == OperationType.LongDiv){
                printArray(o.f);
            }
            Calculator.doCalculation(o);
                        if(o.type == OperationType.LongDiv){
                printArray(o.f);
            }

        }
        OutputWriter writer = new OutputWriter();
        writer.writeOutput(operations);
    }
    
    
    public static void main(String[] args) {
        AFSGroup8A2 program = new AFSGroup8A2();
        program.init();
        //program.test();
    }
    
    void test(){
        int[] f = {1,1,1};
    	int[] g = {2,-2};
    	int p = 2;
    	int d = 3;
    	
    	Operation o = new Operation();
    	o.f = f;
    	o.g = g;
    	o.p = p;
    	o.d = d;
    	o.type = OperationType.FindIrred;
    	Calculator.doCalculation(o);
    	System.out.println(Arrays.toString(o.answer));
    }
    
    void printArray(int[] arr){
        if(arr != null){
            System.out.print("[");
            for(int i=0; i< arr.length;i++){
                System.out.print(arr[i]);
                if(i != arr.length-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
    
}
