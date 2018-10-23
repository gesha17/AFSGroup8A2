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
public class LongDivCalculator extends Calculator {
    
    public LongDivCalculator(Operation o) {
        super(o);
    }
    
    int quot [];
    int rem [];
    
    int[] longDivision(int[] _r, int[] b, int p) {
        int[] r = new int[_r.length];
        for(int i =0; i< _r.length; i++){
            r[i] = _r[i];
        }
        int[] q = new int[r.length]; // quotient
        // fill q with 0's initially
        for (int i = 0; i < q.length; i++) {
            q[i] = 0;
        }
        int coeff; // interim value for the coefficient
        int deg; // interim value for the degree
        int leadCoeff;
        Boolean flag = true;
        //@Pre b!=0
        while (deg (r) >= deg (b) && flag) {
            if (deg (r) == 0) {
                flag = false;
            }
            // leading coefficient with div
            leadCoeff = setMultiple(lc(r), lc(b), p);
            // set r the leading coeff;
            r[0] = leadCoeff;
            coeff = leadCoeff / lc(b);
            // degree with normal subtraction
            deg = deg(r) - deg (b);
            // create polynomical of the form coeff*X^deg
            int[] xMult = new int[deg+1];
            xMult[0] = coeff;
            // initialize rest to 0;
            for (int i = 1 ; i < xMult.length; i++) {
                xMult[i] = 0;
            }
            // calculate the new q using addition for polynomials
            q = add(q, xMult, p);
            // multiply xMult with b using mul of polynomials
            int[] newxMult;
            newxMult = mul(xMult, b, p);
            xMult = newxMult;
            // calculate the new r using the updated interim and subtraction
            int newRem[];
            newRem = sub(r, xMult, p);
            r = newRem;
        }
        quot = q;
        rem = r;
        return q;
    }
    
    int deg(int [] x) {
        int i = 0;
        int deg = x.length - 1;
        
        while (x[i] == 0 && i != x.length-1) {
            deg --;
            i++;
        }
        return deg;
    }
    
    int lc(int [] x) {
        x = removeLeadingZeros(x);
        return x[0];
    }
    
    int setMultiple(int coefficient, int div, int p) {
        while (coefficient%div != 0) {
            coefficient = coefficient + p;
        }
        return coefficient;
    }

    @Override
    void calculate() {
        if(o.g.length == 1 && o.g[0] == 0){
            //Impossible division by zero
        } else {
            o.answer = longDivision(o.f, o.g, o.p);
            o.answerq = removeLeadingZeros(quot);
            o.answerr = removeLeadingZeros(rem);
        }
    }
    
}
