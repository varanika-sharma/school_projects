package p5_cubicpoly;

import p5_utility.DoubleWithAppx;

/**
 * A general representation of a Cubic polynomial of the form:
 *     (a*x^3 + b*x^2 + c*x + d)
 * 
 * @author YOUR NAME SHOULD GO HERE
 * @date October-November 2018
 */

public class CubicPoly {
	private final DoubleWithAppx a;
	private final DoubleWithAppx b;
	private final DoubleWithAppx c;
	private final DoubleWithAppx d;
	
	public CubicPoly() {
		 a = new DoubleWithAppx(0); 
		 b = new DoubleWithAppx(0); 
		c = new DoubleWithAppx(0);  
		d = new DoubleWithAppx(0);
	}

	public CubicPoly(DoubleWithAppx dIn) {
		a = new DoubleWithAppx(0);
		b = new DoubleWithAppx(0);
		c = new DoubleWithAppx(0); 
		d = new DoubleWithAppx(dIn);
	}

	public CubicPoly(DoubleWithAppx cIn, DoubleWithAppx dIn) {
		a = new DoubleWithAppx(0);
		b = new DoubleWithAppx(0);
		c = new DoubleWithAppx(cIn); 
		d = new DoubleWithAppx(dIn);	
	}

	public CubicPoly(DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		a = new DoubleWithAppx(0);
		b = new DoubleWithAppx(bIn);
		c = new DoubleWithAppx(cIn); 
		d = new DoubleWithAppx(dIn);		
	}
	
	public CubicPoly(DoubleWithAppx aIn, DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		a = new DoubleWithAppx(aIn);
		b = new DoubleWithAppx(bIn);
		c = new DoubleWithAppx(cIn); 
		d = new DoubleWithAppx(dIn);
	
	}
	
	public CubicPoly(CubicPoly other) {
		this(
			    other.getA(),
			    other.getB(),
			    other.getC(),
			    other.getD() 
			    );
	}
	
	public DoubleWithAppx getA() {
		return a;	
	}
	
	public DoubleWithAppx getB() {
		return b;
	}
	
	public DoubleWithAppx getC() {
		return c;
	}
	
	public DoubleWithAppx getD() {
		return d;
	}
	
	
	
	
	
	public DoubleWithAppx eval(DoubleWithAppx x) {
		DoubleWithAppx value = a.multiply(x.power(3)).add(b.multiply(x.power(2))).add(c.multiply(x).add(d));
		return value;
		//HINT: Think about how to chain method calls to make this compact. 
	}
	
	
	public CubicPoly add(CubicPoly cubicPolyIn) {
		 CubicPoly poly = new CubicPoly((a.add(cubicPolyIn.a)),(b.add(cubicPolyIn.b)),(c.add(cubicPolyIn.c)),(d.add(cubicPolyIn.d)));
	     return poly;
	}

	public CubicPoly subtract(CubicPoly cubicPolyIn) {
		 CubicPoly poly = new CubicPoly((a.subtract(cubicPolyIn.a)),(b.subtract(cubicPolyIn.b)),(c.subtract(cubicPolyIn.c)),(d.subtract(cubicPolyIn.d)));
	     return poly;
	}



	public CubicPoly mult(CubicPoly cubicPolyIn) {
		CubicPoly poly = new CubicPoly((a.multiply(cubicPolyIn.a)),(b.multiply(cubicPolyIn.b)),(c.multiply(cubicPolyIn.c)),(d.multiply(cubicPolyIn.d)));
	     return poly;
	}

	
	
	
	public CubicPoly deriv() {
		DoubleWithAppx newa = new DoubleWithAppx(0);
		DoubleWithAppx newb= new DoubleWithAppx(3).multiply(a);
		DoubleWithAppx newc = new DoubleWithAppx(2).multiply(b); 
		DoubleWithAppx newd = new DoubleWithAppx(1).multiply(c); 
		
		CubicPoly poly =new CubicPoly(newa, newb, newc, newd);
		return poly;
	}


	
	public int compareTo(CubicPoly cubicPolyIn) {
        if (a.equals(cubicPolyIn.getA())&& b.equals(cubicPolyIn.getB())&& c.equals(cubicPolyIn.getC())) {
            return 0;
        }
        if (this.a.compareTo(cubicPolyIn.getA()) < this.b.compareTo(cubicPolyIn.getB())) {
            return -1;
        }
            if  (this.b.compareTo(cubicPolyIn.getB()) < this.c.compareTo(cubicPolyIn.getC())) {
                return -1;
            }
                if (this.c.compareTo(cubicPolyIn.getC())<this.d.compareTo(cubicPolyIn.getD())) {
                    return -1;
                }
                else if (this.d.compareTo(cubicPolyIn.getD()) < this.a.compareTo(cubicPolyIn.getA())) {
                    return -1;
                }
                else {
                    return +1;
                }
             
            }
            
        

	
        
	
	

	
	
	//Challenge Problem
    public String toString() { 
    	return "a:"+a+", b:"+b+", c:"+c+", d:"+d;
		//You only need to implement this for a challenge.
    } 
	

	
    
    
    
    
    
    
	
	
	
	
	//NOTE: THIS JAVA EQUALS METHOD IS WRITTEN FOR YOU - DO NOT CHANGE
	@Override
	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			CubicPoly casted = (CubicPoly)other;
			return (
					a.equals(casted.a) && 
					b.equals(casted.b) && 
					c.equals(casted.c) && 
					d.equals(casted.d)
			);
		}
	}
	
	
}