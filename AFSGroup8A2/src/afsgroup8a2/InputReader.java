/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsgroup8a2;

import afsgroup8a2.Operation.OperationType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author s165700
 */
public class InputReader {
    
    public ArrayList<Operation> getInput(){
        ArrayList<Operation> operations = new ArrayList<>();
        Scanner sc = null;
        try{
            sc = new Scanner(new File("input.txt"));
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        if(sc != null){
            Operation o = new Operation();
            o.type = null;
            while(sc.hasNext()){
                String input = sc.next();
                switch(input){
                    case "[mod]":
                        if(o.type != null){
                            operations.add(o);
                        }
                        o = new Operation();
                        o.p = Integer.valueOf(sc.next());
                        break;
                    case "[display-poly]":
                        o.type = OperationType.Display;
                        break;
                    case "[add-poly]":
                        o.type = OperationType.Add;
                        break;
                    case "[subtract-poly]":
                        o.type = OperationType.Subtract;
                        break;
                    case "[multiply-poly]":
                        o.type = OperationType.Multiply;
                        break;
                    case "[long-div-poly]":
                        o.type = OperationType.LongDiv;
                        break;
                    case "[euclid-poly]":
                        o.type = OperationType.Euclid;
                        break;
                    case "[equals-poly-mod]":
                        o.type = OperationType.EqualsPolyMod;
                        break;
                    case "[irreducible]":
                        o.type = OperationType.Irreducible;
                        break;
                    case "[find-irred]":
                        o.type = OperationType.FindIrred;
                        break;
                    case "[mod-poly]":
                        o.modPoly = strToInt(sc.next());
                        break;
                    case "[add-table]":
                        o.type = OperationType.AddTable;
                        break;
                    case "[mult-table]":
                        o.type = OperationType.MultTable;
                        break;
                    case "[display-field]":
                        o.type = OperationType.DisplayField;
                        break;
                    case "[add-field]":
                        o.type = OperationType.AddField;
                        break;
                    case "[subtract-field]":
                        o.type = OperationType.SubtractField;
                        break;
                    case "[multiply-field]":
                        o.type = OperationType.MultField;
                        break;
                    case "[inverse-field]":
                        o.type = OperationType.InverseField;
                        break;
                    case "[division-field]":
                        o.type = OperationType.DivisionField;
                        break;
                    case "[equals-field]":
                        o.type = OperationType.EqualsField;
                        break;
                    case "[primitive]":
                        o.type = OperationType.Primitive;
                        break;
                    case "[find-prim]":
                        o.type = OperationType.FindPrim;
                        break;
                    case "[f]":
                        //System.out.println(o.type);
                        //String test = sc.next();
                        //System.out.println(test);
                        o.f = strToInt(sc.next());
                        break;
                    case "[g]":
                        o.g = strToInt(sc.next());
                        break;
                    case "[h]":
                        o.h = strToInt(sc.next());
                        break;
                    case "[deg]":
                        o.d = Integer.valueOf(sc.next());
                        break;
                    case "[a]":
                        o.a = strToInt(sc.next());
                        break;
                    case "[b]":
                        o.b = strToInt(sc.next());
                }
            }
        operations.add(o);
        }
        return operations;
    }
    
    
    
    private int[] strToInt(String str){
        if(str.length() == 2){
            return null;
        }
        //find array length
        int arrLen=1;
        for(int i=0; i< str.length();i++){
            if(String.valueOf(str.charAt(i)).equals(",")){
                arrLen++;
            }
        }
        int[] array = new int[arrLen];
        
        int posInArray=0;
        for(int i=0; i< str.length();i++){
            if(!String.valueOf(str.charAt(i)).equals("{") && !String.valueOf(str.charAt(i)).equals("}") && !String.valueOf(str.charAt(i)).equals(",")){
                boolean negative = false;
                if(String.valueOf(str.charAt(i)).equals("-")){
                    i++;
                    negative = true;
                }
                String str1 = String.valueOf(str.charAt(i));
                while(!String.valueOf(str.charAt(i+1)).equals(",") && !String.valueOf(str.charAt(i+1)).equals("}")){
                    str1 = str1+str.charAt(i+1);
                    i++;
                }
                if(negative){
                    str1 = "-" + str1;
                }
                //System.out.println("Viewed as " + str1);
                array[posInArray] = Integer.parseInt(str1);
                //System.out.println("Converted to "+ array[posInArray]);
                posInArray++;
                
            }
        }
        return array;
    }
}
