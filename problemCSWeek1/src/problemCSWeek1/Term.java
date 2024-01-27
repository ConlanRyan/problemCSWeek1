package problemCSWeek1;

public class Term {
	public int DEFAULT_CONSTANT = 1;
	public int DEFAULT_EXPONENT = 1;
	public boolean DEFAULT_CONSTANTSIGN = true; 
	public int DEFAULT_EXPONENTSIGN = 1; 

	
	
	private int constant;
	private int exponent;
	private boolean constantSign;
	private int exponentSign;
	
	//--------CONSTRUCTORS------------
	
	//full
	public Term(int c, int e, boolean constantSign,int exponentSign) {
		setAll(c,e,constantSign,exponentSign);
	}
	//default
	public Term() {
		setAll(DEFAULT_CONSTANT,DEFAULT_EXPONENT,DEFAULT_CONSTANTSIGN,DEFAULT_EXPONENTSIGN);
	}
	//copy
	public Term(Term t) {
		setAll(t.getConstant(),t.getExponent(),t.getConstantSign(),t.getExponentSign());
	}
	//String
	public Term (String s, Boolean newConstantSign, int newExponentSign) {
		//variables that will be edited later and sent into our setters
		int newConstant = 0;
		int newExponent = 0;
		//System.out.println(s);
		
		if(s.indexOf("x")>-1) {
			//there is an x in there somewhere
			
			//check if there is a ^
			if(s.indexOf("^")>-1) {
				//there is one!
				//let's get the position as an integer
				int positionOfCarrot = s.indexOf("^");
								
				//the end of the constant should be 2 before the carrot
				//so if ^ was 4 then in 334x^2, the end of 334 should be 2
				int endOfConstant = positionOfCarrot-1;
				
				//everything after the carrot is our exponent
				System.out.println((s.substring(positionOfCarrot+1)));
				newExponent = Integer.valueOf(s.substring(positionOfCarrot+1));
				
				//everything before the x is the constant
				newConstant = Integer.valueOf(s.substring(0,endOfConstant));
				
				System.out.println(newConstant+" is the constant. "+newExponent+" is the exponent.");
			}
		}
		else if(s.indexOf("x")==0) {
			//it's just x
			newConstant = 1;
			newExponent = 1;
		}
		else if(s.indexOf("x")<0) {
			//no x at all, just a constant
			newConstant = Integer.valueOf(s);
			newExponent = 0;
		}
		
		
		//finally let's set it
		setAll(newConstant,newExponent,newConstantSign,newExponentSign);
	}
	
	
	//---------SETTERS------------

	public boolean setConstant(int c) {
		constant = c;
		return true;
		
		//TODO
	}
	public boolean setExponent(int e) {
		exponent = e;
		return true;
		
		//TODO
	}
	public boolean setConstantSign(boolean s) {
		constantSign = s;
		return true;
	}
	public boolean setExponentSign(int s) {
		exponentSign = s;
		return true;
	}
	public boolean setAll(int c, int e, boolean sc, int se) {
		return( setConstant(c) && setExponent(e) && setConstantSign(sc) && setExponentSign(se));
	}
	
	
	//----------GETTERS-----------
	public int getConstant() {
		return this.constant;
	}
	public int getExponent() {
		return this.exponent;
	}
	public boolean getConstantSign() {
		return this.constantSign;
	}
	public int getExponentSign() {
		return this.exponentSign;
	}
	
	@Override
	public String toString() {
		String written = "";
		
		//is it negative? if so, write a constantSign
		if(constantSign) {
			written = "+";
		}
		else {
			written = "-";
		}
		
		//if it's just a constant, like 3, then just write that
		if(exponent==0) {
			written = written+constant+"";
		}
		//if it's a constant and variable, like 5x, then write that
		else if (exponent==1) {
			written = written+constant+"x";
		}
		//if it's at a higher power, like 4x^5, then write that
		else {
			//if the exponent is negative, add it after the carrot
			if(exponentSign==-1) {
				written = written+constant+"x^-"+exponent;
			}
			else {
				//if not just write it normally
				written = written+constant+"x^"+exponent;
			}
			
		}
		return written;
	}
}
