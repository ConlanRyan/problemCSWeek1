package problemCSWeek1;

import java.util.ArrayList;

public class IllegalPolynomialException extends Exception {
	
	//my list of incorrect characters
	private ArrayList<String> whyItsWrong = new ArrayList<String>();
	
	
	public IllegalPolynomialException(ArrayList<String> a) {
		whyItsWrong.addAll(a);
	}
	
	public ArrayList<String> getListOfWhyItsWrong() {
		return whyItsWrong;
	}
}
