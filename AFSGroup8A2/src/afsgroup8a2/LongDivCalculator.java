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
    
    int[] longDivision(int[] r, int[] b, int p) {
        int[] q = new int[r.length]; // quotient
        //int[] r = new int[r.length]; // remainder

        // fill q with 0's initially
        for (int i = 0; i < q.length; i++) {
            q[i] = 0;
        }
        // copy a in r
        //for (int i = 0; i<= a.length; i++) {
        //    int temp = a[i];
        //    r[i] = temp;
        //}
        
        int coeff; // interim value for the coefficient
        int deg; // interim value for the degree
        int leadCoeff;
        Boolean flag = true;
        //@Pre b!=0
        //System.out.println(deg(r));
        //System.out.println(deg(b));
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
            //System.out.println(q[0]);
            // multiply xMult with b using mul of polynomials
            System.out.println(xMult[0]);
            System.out.println(xMult[1]);
            int[] newxMult;
            System.out.println(b[0]);
            System.out.println(b[1]);
            newxMult = mul(xMult, b, p);
            xMult = newxMult;
            //System.out.println(xMult[0]);
            // calculate the new r using the updated interim and subtraction
            int newRem[];
            System.out.println(r[0]);
            System.out.println(r[1]);
            System.out.println(r[2]);
            System.out.println(xMult[0]);
            System.out.println(xMult[1]);
            newRem = sub(r, xMult, p);
            r = newRem;
            System.out.println(r[3]);
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
        //if (x.length == 1) {
        //    return x[0];
        //}
        //int i = 0;
        //while (x[i] == 0) {
        //    i++;
        //}
        //return x[i];
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
        o.answer = longDivision(o.f, o.g, o.p);
    }
    
}
