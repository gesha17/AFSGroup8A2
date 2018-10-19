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
            while(sc.hasNext()){
                String input = sc.next();
                switch(input){
                    case "[mod]":
                        o = new Operation();
                        o.mod = Integer.valueOf(sc.next());
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
                        o.f = strToInt(sc.next());
                        break;
                    case "[g]":
                        o.g = strToInt(sc.next());
                        break;
                    case "[h]":
                        o.h = strToInt(sc.next());
                        break;
                    case "[deg]":
                        o.degree = Integer.valueOf(sc.next());
                        break;
                    case "[a]":
                        o.a = strToInt(sc.next());
                        break;
                    case "[b]":
                        o.b = strToInt(sc.next());
                
                }
            }
        }
        
        return operations;
    }
    
    
    
    private int[] strToInt(String str){
        int[] array = new int[(int) str.length()/2];
        for(int i=0; i< str.length();i++){
            if(!String.valueOf(str.charAt(i)).equals("{") && !String.valueOf(str.charAt(i)).equals("}") && !String.valueOf(str.charAt(i)).equals(",")){
                array[i] = Integer.valueOf(str.charAt(i));
            }
        }
        return array;
    }
}
