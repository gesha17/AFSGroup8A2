/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsgroup8a2;

import afsgroup8a2.Operation.OperationType;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author s165700
 */
public class OutputWriter {
    
    void writeOutput(ArrayList<Operation> operations){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt", true));
            boolean first=false;
            for (Operation answer : operations) {
                if(first ==true){
                    writer.println();
                    writer.println();
                }
                if(answer.type == OperationType.AddTable){
                    tableToStr(answer.answertable);
                }
                first = true;
                writer.print("[mod]		");
                writer.print(answer.p);
                writer.println();
                printType(answer, writer);
                if(answer.type == OperationType.FindIrred){
                    writer.print("[deg]		" + answer.d);
                }
                if(answer.f == null && answer.type == OperationType.Display){
                    writer.print("[f]		");
                    writer.print("{}");
                    writer.println();
                    writer.print("[answer] 0");
                }
                if(answer.f != null){
                    writer.print("[f]		");
                    writer.print(intToStr(answer.f));
                }
                if(answer.g != null){
                    writer.println();
                    writer.print("[g]		");
                    writer.print(intToStr(answer.g));                            
                }
                if(answer.h !=null ) {
                    writer.println();
                    writer.print("[h]		");
                    writer.print(intToStr(answer.h));
                }
                if(answer.type == OperationType.EqualsPolyMod && answer.h == null){
                    writer.println();
                    writer.print("[h]		{}");
                }
                if(answer.answer != null && answer.type != OperationType.LongDiv){
                    writer.println();
                    writer.print("[answer]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answer;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answera != null){
                    writer.println();
                    writer.print("[answ-a]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answera;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerb != null){
                    writer.println();
                    writer.print("[answ-b]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerb;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerd != null){
                    writer.println();
                    writer.print("[answ-d]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerd;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerq != null){
                    writer.println();
                    writer.print("[answ-q]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerq;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerr != null){
                    writer.println();
                    writer.print("[answ-r]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerr;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.type == OperationType.EqualsPolyMod || answer.type == OperationType.Irreducible){
                    writer.println();
                    writer.print("[answer]		");
                    if(answer.answerboolean){
                        writer.print("TRUE");
                    } else writer.print("FALSE");
                }
                
                if(answer.type == OperationType.LongDiv && answer.g.length == 1 && answer.g[0] == 0){
                    writer.println();
                    writer.print("[answ-q] " + "ERROR");
                    writer.println();
                    writer.print("[answ-r] " + "ERROR");
                }
                if(answer.type == OperationType.DivisionField && answer.b == null){
                    writer.println();
                    writer.print("[answer] " + "ERROR");
                }
                if(answer.answerstring != null && !answer.answerstring.equals("{}")){
                    writer.println();
                    writer.print("[answer]		" + answer.answerstring);
                }
                if(answer.answertable != null){
                    writer.println();
                    writer.print("[answer]		" + tableToStr(answer.answertable));
                }
                
                if(answer.a != null){
                    writer.println();
                    writer.print("[a]		" + intToStr(answer.a));
                }
                
                
            }
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    void printType(Operation answer, PrintWriter writer){
        switch(answer.type){
            case Display:
                writer.println("[display-poly]");
                break;
            case Add:
                writer.println("[add-poly]");
                break;
            case Subtract:
                writer.println("[subtract-poly]");
                break;
            case Multiply:
                writer.println("[multiply-poly]");
                break;
            case LongDiv:
                writer.println("[long-div-poly]");
                break;
            case Euclid:
                writer.println("[euclid-poly]");
                break;
            case Irreducible:
                writer.println("[irreducible]");
                break;
            case FindIrred:
                writer.println("[find-irred]");
                break;
            case EqualsPolyMod:
                writer.println("[equals-poly-mod]");
                break;
            case AddTable:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[add-table]");
                break;
            case MultTable:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[mult-table]");
                break;
            case DisplayField:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[display-field]");
                break;
            case AddField:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.println("[add-field]");
                break;
            case SubtractField:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[subtract-field]");
                break;
            case MultField:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[mult-field]");
                break;
            case InverseField:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[inverse-field]");
                break;
            case DivisionField:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[division-field]");
                break;
            case EqualsField:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[equals-field]");
                break;
            case Primitive:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[primitive]");
                break;
            case FindPrim:
                writer.print("[mod-poly]	");
                writer.print(intToStr(answer.modPoly));
                writer.println();
                writer.print("[find-prim]");
                break;
        }
    }
    
    private String intToStr(int[] arr){
        String str = "{";
        for(int i=0; i<arr.length;i++){
            str = str + String.valueOf(arr[i]);
            if(i != arr.length-1){
                str = str + ",";
            }
        }
        str = str + "}";
        return str;
    }
    
    private String tableToStr(int[][][] arr){
        System.out.println("Printing");
        String str = "{";
        for(int i=0; i< arr.length; i++){
            for(int j=0; j< arr[i].length; j++){
                for(int k =0; k< arr[i][j].length; k++){
                    System.out.print(arr[i][j][k]);
                    str = str + String.valueOf(arr[i][j][k]) + ", " ;
                }
            }
        }
        str = str + "}";
        System.out.println();
        for(int j=0; j< arr[0].length; j++){
            for(int k =0; k< arr[0][j].length; k++){
                System.out.print(arr[0][j][k]);
            }
        }
        System.out.println(arr.length + " " + arr[0].length + " " + arr[0][0].length);
        return str;
    }
    
}
