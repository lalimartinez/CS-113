package edu.miracosta.cs113;

public class Term implements Comparable<Object>, Cloneable{
    private int mExponent;
    private int mCoefficient;

    public Term(int coefficient, int exponent) {
        mExponent = exponent;
        mCoefficient = coefficient;
    }

    //Default Constructor
    public Term() {
        mExponent = 1;
        mCoefficient = 1;
    }


    //Copy Constructor
    public Term(Term term) {
        this.mExponent = term.mExponent;
        this.mCoefficient = term.mCoefficient;
    }

    public Term(String t) {
        int coefficient = 0, exponent = 0;
        if(!t.isEmpty()) {
        	if(t.contains("x")) {
        		String parts[] = t.split("x");
        		if(parts[0].length() == 1 && parts[0].equals("-"))
        	        coefficient = -1;
        	      else if(parts[0].length() == 1 && parts[0].equals("+"))
        	        coefficient = 1;
        	      else
        	        coefficient = Integer.parseInt(parts[0]);
        		if(parts.length == 2) 
        			exponent = Integer.parseInt(parts[1].substring(1));
        		else
        			exponent = 1;
        	}
        	else {
        		coefficient = Integer.parseInt(t);
        		exponent = 0;
        	}
        }
        else {
        	coefficient = 0;
        	exponent = 0;
        }
        mCoefficient = coefficient;
        mExponent = exponent;
    }

    public int getExponent() {
        return mExponent;
    }

    public int getCoefficient() {
        return mCoefficient;
    }

    public void setExponent(int exponent) {
        mExponent = exponent;
    }

    public void setCoefficient(int coefficient) {
        mCoefficient= coefficient;
    }

    public void setAll(int coefficient, int exponent) {
        mExponent = exponent;
        mCoefficient = coefficient;
    }

    @Override
    public String toString() {
        String t = "";
        if(mCoefficient == 0) 
        	return t;
        
        if(mCoefficient > 0) {
        	t += "+";
        	if(mCoefficient > 1) 
        		t += mCoefficient;	
        }
        else {
        	if(mCoefficient < -1) 
        		t += mCoefficient;
        	else
        		t += "-";
        }
        
        if(mExponent == 0)
        	return t;
        
        if(mExponent == 1) 
        	t += "x";      
        else 
        	t += "x^" + mExponent;
           	
    	return t;
    }

    @Override
    public boolean equals(Object o) {
        //if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        //if(!super.equals(o)) return false;
        Term that = (Term) o;
        return mExponent == that.mExponent && mCoefficient == that.mCoefficient;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Term) {
            Term other = (Term) o;
            int exponentComp = mExponent - other.mExponent;
            if(exponentComp != 0)
                return exponentComp;
            int coefficientComp = mCoefficient - other.mCoefficient;
            return coefficientComp;
        }
        else
            return -1;
    }

    public Object clone() {
    	try {
    		return super.clone();
    	} catch (CloneNotSupportedException e) {
    		return null;
    	}
    }
 
    
  

}
