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
            for (Operation answer : operations) {
                writer.print("[mod] ");
                writer.print(answer.mod);
                printType(answer, writer);
                if(answer.f != null){
                    writer.println("[f] ");
                    writer.print(intToStr(answer.f));
                }
                if(answer.g != null){
                    writer.println("[g] ");
                    writer.print(intToStr(answer.g));                            
                }
                if(answer.h !=null ) {
                    writer.println("[h] ");
                    writer.print(intToStr(answer.h));
                }
                if(answer.answer != null){
                    writer.println("[answer] ");
                    writer.print(answer.answerstring);
                }
                if(answer.answera != null){
                    writer.println("[answr-a] ");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answera;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerb != null){
                    writer.println("[answr-b] ");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerb;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerd != null){
                    writer.println("[answr-d] ");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerd;
                    Calculator.doCalculation(o);
                    writer.print(o.answerstring);
                }
                if(answer.answerq != null){
                    writer.println("[answr-q] ");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerq;
                    Calculator.doCalculation(o);
                    writer.print(o.answer);
                }
                if(answer.answerr != null){
                    writer.println("[answr-r] ");
                    Operation o = new Operation();
                    o.type = OperationType.Display;
                    o.f = answer.answerr;
                    Calculator.doCalculation(o);
                    writer.print(o.answer);
                }
                if(answer.type == OperationType.EqualsPolyMod || answer.type == OperationType.Irreducible){
                    writer.println("[answer] ");
                    if(answer.answerboolean){
                        writer.print("TRUE");
                    } else writer.print("FALSE");
                }
                
                if(answer.type == OperationType.LongDiv && answer.g.length == 0 && answer.g[0] == 0){
                    writer.println("[answer-q] " + "ERROR");
                    writer.println("[answer-r] " + "ERROR");
                }
                
                
                
            }

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
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[add-table]");
                break;
            case MultTable:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[mult-table]");
                break;
            case DisplayField:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[display-field]");
                break;
            case AddField:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[add-field]");
                break;
            case SubtractField:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[subtract-field]");
                break;
            case MultField:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[mult-field]");
                break;
            case InverseField:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[inverse-field]");
                break;
            case DivisionField:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[division-field]");
                break;
            case EqualsField:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[equals-field]");
                break;
            case Primitive:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[primitive]");
                break;
            case FindPrim:
                writer.println("[mod-poly] ");
                writer.print(intToStr(answer.modPoly));
                writer.println("[find-prim]");
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
    
}
