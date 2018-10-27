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
                    tableToStr(answer.answertable, answer.p);
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
                if(answer.a != null){
                    writer.println();
                    writer.print("[a]		" + intToStr(answer.a));
                }
                if(answer.b != null){
                    writer.println();
                    writer.print("[b]		" + intToStr(answer.b));
                }
                if(answer.type == OperationType.DivisionField && answer.b == null){
                    writer.println();
                    writer.print("[b]		{}");
                }
                if(answer.type == OperationType.EqualsPolyMod && answer.h == null){
                    writer.println();
                    writer.print("[h]		{}");
                }
                
                if(answer.answer != null && answer.type != OperationType.LongDiv){
                    if(isFieldOperation(answer.type)){
                        if(isIrreducible(answer)){
                            writer.println();
                            writer.print("[answer]		");
                            Operation o = new Operation();
                            o.type = OperationType.Display;
                            o.f = answer.answer;
                            o.p = answer.p;
                            Calculator.doCalculation(o);
                            writer.print(o.answerstring);
                        } else {
                            writer.println();
                            writer.print("[answer] ERROR");
                        }
                    } else {
                        writer.println();
                        writer.print("[answer]		");
                        Operation o = new Operation();
                        o.type = OperationType.Display;
                        o.f = answer.answer;
                        o.p = answer.p;
                        Calculator.doCalculation(o);
                        writer.print(o.answerstring);
                    }
                }
                if(answer.answera != null){
                    writer.println();
                    writer.print("[answ-a]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answera;
                    o.p = answer.p;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerb != null){
                    writer.println();
                    writer.print("[answ-b]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerb;
                    o.p = answer.p;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerd != null){
                    writer.println();
                    writer.print("[answ-d]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerd;
                    o.p = answer.p;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerq != null){
                    writer.println();
                    writer.print("[answ-q]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerq;
                    o.p = answer.p;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerr != null){
                    writer.println();
                    writer.print("[answ-r]		");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerr;
                    o.p = answer.p;
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
                    writer.print("[answer]	" + answer.answerstring);
                }
                if(answer.answertable != null){
                    writer.println();
                    writer.print("[answer]	" + tableToStr(answer.answertable, answer.p));
                }
                if(answer.type == OperationType.InverseField && answer.answer == null){
                    writer.println();
                    writer.print("[answer] ERROR");
                }
                if(answer.type == OperationType.EqualsField || answer.type == OperationType.Primitive){
                    writer.println();
                    if(answer.answerboolean){
                        writer.print("[answer] TRUE");
                    } else writer.print("[answer] FALSE");
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
                writer.print("[add-field]");
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
                writer.print("[multiply-field]");
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
    
    private String tableToStr(int[][][] arr, int p){
        String str = "{";
        for(int[][] elements: arr){
            for(int i=0; i< elements.length; i++){
                str = str + Calculator._display(elements[i], p);
                if(i != elements.length-1){
                    str = str + ", ";
                }
            }
            str = str + "; ";
        }
        str = str.substring(0, str.length()-2);
        str = str + "}";
        return str;
    }
    
    boolean isFieldOperation(OperationType type){
        if(type == OperationType.AddField ||
                type == OperationType.MultField ||
                type == OperationType.InverseField ||
                type == OperationType.SubtractField ||
                type == OperationType.FindPrim ||
                type == OperationType.Primitive ||
                type == OperationType.EqualsField ||
                type == OperationType.DivisionField){
                return true;
        } else return false;
    }
    
    boolean isIrreducible(Operation answer){
        Operation newAns = new Operation();
        newAns.type = OperationType.Irreducible;
        newAns.f = answer.modPoly;
        newAns.p = answer.p;
        Calculator.doCalculation(newAns);
        return newAns.answerboolean;
    }
    
}
