package problemCSWeek1;

import java.util.ArrayList;

public class Polynomial {
	
	public ArrayList<Term> DEFAULT_TERMS = new ArrayList<Term>();
	private ArrayList<Term> terms = new ArrayList<Term>();
	
	
	//--------CONSTRUCTORS----------
	
	//default
	public Polynomial() {
		setTerms(DEFAULT_TERMS);
	}
	//full
	public Polynomial(ArrayList<Term> terms) {
		setTerms(terms);
	}
	//copy
	public Polynomial(Polynomial poly) {
		setTerms(poly.getTerms());
	}
	//string
	public Polynomial(String p) throws IllegalArgumentException{
		
		//======= ENSURING WE HAVE A LEGAL POLYNOMIAL =========
		try {
			//alright lets find out
			testMyPolynomial(p);
		}
		catch (IllegalArgumentException i) {
			//nope! it was illegal, tell the Main function!
			throw new IllegalArgumentException();
		}
		
		
		//========= MAKING THE LIST OF TERMS =============
		
		//takes the string and remove all the whitespace
		p.replace(" ","");
		//make a list of our terms together, 3x^2-4x+1 will look like [3x^2,4x,1]
		//String[] termsList = p.split("[\\+-]");
		
		//if I enter 2x^4-3x^-1 this .split program will break my stuff into [2x^4,3x^,1]
		//time to take matters into MY OWN HANDS
	
		//make my OWN list
		ArrayList<String> termsList = new ArrayList<String>();
		
		//make a copy of the user's input
		String text = p;
		
		//this loop will continue until
		//		a. there is no + left
		//		b. there is no - left (unless the - is not ahead of a ^ such as 3x^-2)
		while( (text.indexOf("+")>-1) || (     text.indexOf("-")>-1     &&     !(text.substring(text.indexOf("-")-1,text.indexOf("-")).equals("^"))    )) {
			if(text.indexOf("+")>-1) {
				System.out.println("There is a + left in the text");
			}
			if(text.indexOf("-")>-1) {
				System.out.println("There is a - left in the text");
			}
			System.out.println("This is the text we're dealing with: "+text);
			for(int i=1;i<text.length();i++) { 
				System.out.println("In the Loop at number "+i);
				//if im on a plus, then chop it up
				if(text.substring(i,i+1).equals("+")){
					System.out.println("Found a + at "+i);
					//add it to our terms list
					termsList.add(text.substring(0,i));
					System.out.println("Added a term! It's "+text.substring(0,i));
					//chop it off so we don't re-add it later
					text = text.substring(i+1);
					System.out.print("Look for another plus or minus with: "+text);
					
				}
				
				//if im on a negative
				else if(text.substring(i,i+1).equals("-")){
					//check if its the first negative (-3x^2 v.s. 3x^-2, chop one but leave the other)
					if(text.substring(i-1,i).equals("^")) {
						//if it's a carrot then we're dealing with a negative exponent
					}
					else {
						//if it's not, then we need a new term
						
						//add it to our terms list
						termsList.add(text.substring(0,i));
						System.out.println("Added a term! It's "+text.substring(0,i));
						//chop it off so we don't re-add it later
						text = text.substring(i+1);
					}
					
					
				}
			}
		}
		//there is one last chunk left, so let's add it at the end
		termsList.add(text);
		
		
		//I need to end up at the end with a list of terms separated correctly despite having negative exponents
		
		
		
		
		
		//========= MAKING THE CORRESPONDING LIST OF CONSTANT SIGNS (+ or -) =============
		ArrayList<Boolean> constantSignsList = new ArrayList<Boolean>();
		
		//If our polynomial starts with 3x^2 then we add + to the start of our signs list
		// so we do not miss the first sign
		if(!p.substring(0,1).equals("-")) {
			constantSignsList.add(true);
		}
		
		//look through and find all the signs
		for(int i=0;i<p.length()-1;i++) {
			//if there is a negative
			if(p.substring(i,i+1).equals("-")) {
				//and it's the first (such as -3x^2+5x+3)
				if(i==0) {
					//then add a negative
					constantSignsList.add(false);
				}
				//if it's just a negative exponent (like 3x^-3)
				else if (p.substring(i-1,i).equals("^")) {
					//then do nothing
				}
				//if its a random negative (such as 3x-1)
				else {
					//then add a negative to the list
					constantSignsList.add(false);
				}
				
			}
			//if it's a positive
			else if(p.substring(i,i+1).equals("+")) {
				//add a positive to the list
				constantSignsList.add(true);
			}
			else {
				//if its just some rando number then dont add to the list
			}
		}
		
		
		
		
		
		//========= MAKING THE CORRESPONDING LIST OF EXPONENT SIGNS (3x^5 or 3x^-5) =============
		ArrayList<Integer> exponentSignsList = new ArrayList<Integer>();

		
		//just to make sure, check that it's not just 2, or 2x, but that it even HAS exponents
		if(p.indexOf("^")>-1) {
			System.out.println("there are exponents!");
			//loop through each character of the polynomial
			for(int i=0;i<p.length();i++) {
				System.out.println("inside the loop "+i+" times and analizing "+p.substring(i,i+1));
				String currentLetter = p.substring(i,i+1);
				//search for exponents
				if(currentLetter.equals("^")) {
					System.out.println("found a ^");
					//gotcha! an exponent!
					//now let's find if it's a negative or a positive exponent by looking at the thing before the ^
					if(p.substring(i+1,i+2).equals("-")) {
						System.out.println("found a negative exponent");
						//we've got a negative exponent! let's add it to our list
						exponentSignsList.add(-1);
					}
					else {
						//if it's 3x^3, then the number ahead of ^is just a constant, we dont write 3x^+3, so just add + to the list
//						System.out.println("found a positive exponent");
						exponentSignsList.add(1);
					}
				}
				else if (currentLetter.equals("+")) {
					//if the letter we are on is a +, it might mean we're at the start of term (like 3x^2+2x)
					exponentSignsList.add(0);
				}
				else if (currentLetter.equals("-")) {
					//if we find a - it could mean were at the start of term (such as -3x^2)
					//or we're at a negative exponent (such as 3x^-2)
				}
				
				
			}
		}
		
		//========= PUTTING IT ALL TOGETHER ============
		System.out.println("HERE ARE ALL OF THE TERMS!:  \n");
		for(String t : termsList) {
			System.out.println(t.toString());
		}
		System.out.println(termsList.size()+" is the number of terms, "+constantSignsList.size()+" is the number of constant signs, "+exponentSignsList.size()+" is the amount of exponent signs we have");
		int exponentSignCounter = 0;
		for(int i=0;i<termsList.size();i++) {
			
			
			//we don't want to use up the exponent signs in the exponentSignsList because not every equation has a ton of exponents
			//so we will only access the exponent signs list when there is an exponent present in our term
			
			//if the term we're looking at has an exponent present
			if(termsList.get(i).indexOf("^")>-1) {
				//make a new term using our terms list, the signs of all of our constants, and the exponent signs
				terms.add(new Term(termsList.get(i), constantSignsList.get(i), exponentSignsList.get(exponentSignCounter)));
				exponentSignCounter++;
			}
			else {
				//if there no exponent then don't access the list!
				terms.add(new Term(termsList.get(i), constantSignsList.get(i), 0));
			}
			
		}
		
		//======= ONE FINAL CHECK ==========
		String total = "";
		for(Term t : terms) {
			total = total + t.toString();
			System.out.println("The first term is "+t.toString()+". It's constant is "+t.getConstant()+". It's exponent is "+t.getExponent());
		}
		System.out.println(total.substring(1));
		
	}

	//--------GETTERS----------
	public ArrayList<Term> getTerms(){
		return this.terms;
	}
	
	
	//--------SETTERS----------
	public boolean setTerms(ArrayList<Term> terms) {
		this.terms.addAll(terms);
		return true;
	}
	
	//--------OTHERS-----------
	
	private void testMyPolynomial(String p) throws IllegalArgumentException{
		//none of these are allowed in a polynomial
		String[] list = {"a","b","c","d","e","f","g","h","i","j","k",
						"l","m","n","o","p","q","r","s","t","u","v",
						"w","y","z",",",".","/",";","'","[","]", "/",
						"<",">",":","{","}","!","@","#","$","a","%",
						"&","*","(",")","_","="};
		for(int i=0;i<list.length;i++) {
			//if the polynomial received has ANY of these characters
			if(p.indexOf(list[i])>-1) {
				//throw an illegal argument exception
				throw new IllegalArgumentException();
			}
		}
		
	}
	
	@Override
	public String toString() {
		String finish = "";
		for(Term t : terms) {
			finish=finish+(t.toString());
		}
		
		//Because of line 95 in Term.java that generalizes the terms and includes + for all positives
		//(regardless of if they're at the start)
		//we must remove the starting terms positive sign if it is present (for looks)
		
	
		if(finish.substring(0,1).equals(("+"))){
			return finish.substring(1);
		}
		else {
			return finish;
		}
		
	}
	
	


}
