package edu.miracosta.cs113;
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Term> mTerms;

    public Polynomial(int coefficient, int exponent) {
        mTerms.add(new Term(coefficient, exponent));
    }

    public Polynomial() {
        mTerms = new LinkedList<Term>();
    }
    
    
    public Polynomial(Polynomial polynomial) {
		mTerms = new LinkedList<Term>();
		for(int i = 0; i < polynomial.getNumTerms(); i++)
			mTerms.add(new Term(polynomial.getTerm(i)));
	}

	public void add(Polynomial polynomial) {
    	for(int i = 0; i < polynomial.getNumTerms(); i++)
    		addTerm(polynomial.getTerm(i));	
    }

    public Term getTerm(int index) {
        return mTerms.get(index);
    }

    public void clear() {
        mTerms.clear();
    }

    public int getNumTerms() {
        return mTerms.size();
    }
    
    public void addTerm(Term term) {
    	Term current;
    	if(mTerms.size() == 0)
    		mTerms.add(term);
    	
    	else { 
    		for(int i = 0; i < getNumTerms(); i++) {
    			current = getTerm(i);
    			if(current.equals(getTerm(getNumTerms()-1))) {
    				if(term.getExponent() > current.getExponent()) {
    					mTerms.add(i, term);
    					return;
    				}
    				else if(term.getExponent() == current.getExponent()) {
    					int c = current.getCoefficient() + term.getCoefficient();
    					if(c != 0) {
    						current.setCoefficient(c);
    						mTerms.set(i, current);
    					}
    					else
    						mTerms.remove(i);
    					return;
    				}
    				else {
    					mTerms.add(term);
    					return;
    				}
    			}
    			
    			if(current.getExponent() < term.getExponent()) {
    				mTerms.add(i, term);
    				return;
    			}
    			if(current.getExponent() == term.getExponent()) {
    				int c = current.getCoefficient() + term.getCoefficient();
    				if(c != 0) {
    					current.setCoefficient(c);
    					mTerms.set(i, current);
    				}
    				else
    					mTerms.remove(i);
    				return;
    			}
    			if(term.getExponent() < current.getExponent() && term.getExponent() > getTerm(i+1).getExponent()) {
    				mTerms.add(i + 1, term);
    				return;
    			}
    		}
    	}
    }
    
    @Override
    public String toString() {
    	String p = "";
    	if(mTerms.size() == 0)
    		return "0";
    	else {
    		for(int i = 0; i < mTerms.size(); i++) 
    			p += getTerm(i).toString();
    		if(p.charAt(0) == '+')
    			p = p.substring(1);
    		return p;
    	}
    }
    
    @Override
    public boolean equals(Object o) {
    	if(o == null || getClass() != o.getClass()) return false;
    	Polynomial that = (Polynomial) o;
    	if(getNumTerms() != that.getNumTerms()) return false;
    	for(int i = 0; i < getNumTerms(); i++) {
    		if(!(getTerm(i).equals(that.getTerm(i))))
    			return false;
    	}
    	return true;
    }


}
