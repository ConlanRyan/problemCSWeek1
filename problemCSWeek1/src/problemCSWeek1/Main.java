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
				String polynomialString = s.nextLine();
				
				Polynomial p = new Polynomial(polynomialString);
				System.out.println(p.toString());
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
