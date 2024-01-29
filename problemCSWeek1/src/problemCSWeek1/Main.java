package problemCSWeek1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) {
		ArrayList<String> testPolynomials = new ArrayList<String>();

		//setup the scanner
		Scanner s = new Scanner(System.in);
		Boolean badInput = true;
		
		//ask for the polynomial
		System.out.println("Please enter your polynomial (Example: 3x^3 + 2x^2 + 3x + 1): ");
		
		while(badInput) {
			try {
				//get it using scanner
				//String polynomialString = s.nextLine();
				testPolynomials.add("3x^2 - 5x + 2");
		        testPolynomials.add("4x^3 + 7x^2 - 2x + 1");
		        testPolynomials.add("x^4 - 6x^3 + 11x^2 - 6x + 1");
		        testPolynomials.add("2x^2 + 8x - 3");
		        testPolynomials.add("5x^3 - 2x^2 + 3x - 7");
		        testPolynomials.add("x^5 - 3x^4 + 5x^3 - 2x^2 + 1");
		        testPolynomials.add("3x^2 - x + 4");
		        testPolynomials.add("6x^4 + 2x^3 - 8x^2 + x - 5");
		        testPolynomials.add("4x^3 + 6x^2 - x - 2");
		        testPolynomials.add("x^2 - 4x + 7");
		        testPolynomials.add("2x^4 - x^3 + 3x^2 - 7x + 1");
		        testPolynomials.add("5x^3 - 2x^2 + 8x - 1");
		        testPolynomials.add("x^3 - 2x^2 + 4x - 8");
		        testPolynomials.add("3x^2 + 5x - 2");
		        testPolynomials.add("4x^4 - 7x^3 + 2x^2 + 1");
		        testPolynomials.add("x^5 - x^4 + 2x^3 - 5x^2 + 3x - 1");
		        testPolynomials.add("2x^2 - 3x + 1");
		        testPolynomials.add("6x^3 + 4x^2 - 9x + 2");
		        testPolynomials.add("x^4 - 5x^3 + 7x^2 - 4x + 2");
		        testPolynomials.add("4x^2 + x - 3");
		        testPolynomials.add("3x^3 - x^2 + 5x - 2");
		        testPolynomials.add("2x^4 - 3x^3 + 4x^2 - x + 7");
		        testPolynomials.add("7x^2 - 2x + 4");
		        testPolynomials.add("x^5 + 2x^4 - 4x^3 + 3x^2 - x + 6");
		        testPolynomials.add("5x^3 - 4x^2 + 2x - 1");
		        testPolynomials.add("2x^2 - 6x + 1");
		        testPolynomials.add("x^4 - x^3 + 3x^2 + 4x - 2");
		        testPolynomials.add("4x^3 + x^2 - 2x + 8");
		        testPolynomials.add("3x^2 - 7x + 2");
		        testPolynomials.add("x^5 - 2x^4 + 5x^3 - 4x^2 + 1");
		        testPolynomials.add("6x^4 - 3x^3 + 2x^2 - x + 4");
		        testPolynomials.add("2x^3 + 3x^2 - 4x + 1");
		        testPolynomials.add("x^4 + 2x^3 - 3x^2 + x - 6");
		        testPolynomials.add("5x^3 - x^2 + 4x - 2");
		        testPolynomials.add("3x^2 + 2x - 1");
		        testPolynomials.add("4x^4 - x^3 + 3x^2 - 7x + 2");
		        testPolynomials.add("x^5 - 3x^4 + 2x^3 - 4x^2 + 1");
		        testPolynomials.add("2x^2 - 5x + 3");
		        testPolynomials.add("7x^3 + 2x^2 - 4x + 1");
		        testPolynomials.add("x^4 - 4x^3 + 2x^2 - 1");
		        testPolynomials.add("4x^2 + 3x - 2");
		        testPolynomials.add("6x^3 - x^2 + 4x - 3");
		        testPolynomials.add("x^5 - x^4 + 3x^3 - 2x^2 + 5x - 1");
		        testPolynomials.add("3x^2 - 6x + 2");
		        testPolynomials.add("5x^4 + 2x^3 - x^2 + 4x - 1");
		        testPolynomials.add("2x^3 + x^2 - 3x + 4");
		        testPolynomials.add("x^4 - 3x^3 + 5x^2 - 2x + 1");
		        testPolynomials.add("4x^2 - 2x + 7");
		        testPolynomials.add("7x^3 - 4x^2 + 2x - 1");
		        testPolynomials.add("x^5 - 2x^4 + x^3 + 3x^2 - 4x + 1");
		        testPolynomials.add("2x^4 - 3x^3 + 4x^2 - x + 6");
		        testPolynomials.add("3x^2 + x - 5");
		        testPolynomials.add("6x^3 + 2x^2 - 4x + 1");
		        testPolynomials.add("x^4 - x^3 + 2x^2 - 5x + 3");
		        testPolynomials.add("4x^2 - 7x + 2");
		        testPolynomials.add("5x^3 + 3x^2 - 2x + 1");
		        testPolynomials.add("x^5 - 3x^4 + 4x^3 - 2x^2 + 1");
		        testPolynomials.add("2x^2 + 4x - 1");
		        testPolynomials.add("3x^3 - x^2 + 5x - 2");
		        testPolynomials.add("x^4 - 2x^3 + 4x^2 - 3x + 1");
		        testPolynomials.add("4x^2 + 6x - 1");

				for(int i =0;i<testPolynomials.size();i++) {
					Polynomial p = new Polynomial(testPolynomials.get(i));
				}
				//pass the string through
				
				
				//it passed? set badInput to false to get out of the while loop
				badInput = false;
				
			}
			catch (IllegalPolynomialException e) {
				//UH OH! The person entered some wild stuff, let's restart
				System.out.println("You entered ");
				
				if(e.getListOfWhyItsWrong().size()>1) {
					for(int i=0;i<e.getListOfWhyItsWrong().size()-1;i++) {
						System.out.print("'"+e.getListOfWhyItsWrong().get(i)+"', ");
					}
					System.out.print("'"+e.getListOfWhyItsWrong().get(e.getListOfWhyItsWrong().size()-1)+"'. ");
				}
				else {
					System.out.print("'"+e.getListOfWhyItsWrong().get(e.getListOfWhyItsWrong().size()-1)+"'. ");
				}
				System.out.print("This is wrong, ");
				//ask for the polynomial
				System.out.println("please reenter your polynomial (Example: 3x^3 + 2x^2 + 3x + 1): ");
				//keep the loop going
				badInput = true;
			}
		}
		
		
	}
	
}
