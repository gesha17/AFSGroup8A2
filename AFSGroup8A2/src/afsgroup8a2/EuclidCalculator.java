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
public class EuclidCalculator extends Calculator {

    public EuclidCalculator(Operation o) {
        super(o);
    }

    //finds x, y and for which gcd(a, b) = d = xa + yb following Algorithm 1.2.11
    void doEuclid(int[] a, int[] b, int p)	{
    	int[] q, r, x, x2, v, y, y2, u;
    	
    	//initialize x1, x2, y1, y2
    	x = new int[] {1};
    	v = new int[] {1};
    	y = new int[] {0};
    	u = new int[] {0};
    	
    	while (b.length-1 != 0 || b[0] != 0)	{
    		
    		//get q and r from division of a over b
    		q = div(a, b, p, "q");
    		r = div(a, b, p, "r");
    		a = b;
    		b = r;
    		x2 = x;
    		y2 = y;
    		x = u;
    		y = v;
    		u = sub(x2, mul(q, u, p), p);
    		v = sub(y2, mul(q, v, p), p);
    	}
    
    	//deal with negative numbers or non-monic polynomials
    	a = removeLeadingZeros(a);
    	if (a[0] != 1)	{
    		int[] firstCoefficient = {a[0]};
    		x = div(x, firstCoefficient, p, "q");
    		y = div(y, firstCoefficient, p, "q");
    		a = div(a, firstCoefficient, p, "q");
    	}
    	
    	//pass answers to operator object
    	o.answera = removeLeadingZeros(x);
    	o.answerb = removeLeadingZeros(y);
    	o.answerd = removeLeadingZeros(a);
    }
    
    @Override
    void calculate() {
        doEuclid(o.f, o.g, o.p);
    }    
}
