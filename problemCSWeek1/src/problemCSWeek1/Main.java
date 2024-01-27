package problemCSWeek1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//setup the scanner
		Scanner s = new Scanner(System.in);
		Boolean badInput = true;
		
		//ask for the polynomial
		System.out.println("Please enter your polynomial (Example: 3x^3 + 2x^2 + 3x + 1): ");
		
		while(badInput) {
			try {
				//get it using scanner
				String polynomialString = s.nextLine();

				//pass the string through
				Polynomial p = new Polynomial(polynomialString);
				
				//it passed? set badInput to false to get out of the while loop
				badInput = false;
				
			}
			catch (IllegalArgumentException e) {
				//UH OH! The person entered some wild stuff, let's restart
				System.out.println("Something was wrong with the polynomial you gave.");
				//ask for the polynomial
				System.out.println("Please reenter your polynomial (Example: 3x^3 + 2x^2 + 3x + 1): ");
				//keep the loop going
				badInput = true;
			}
		}
		
		
	}

}
