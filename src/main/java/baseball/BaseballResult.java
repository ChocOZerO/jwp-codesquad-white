package baseball;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseballResult {
	
	private ArrayList<Integer> tryNumbers;
	private String resultPrint = "";
	
	
	public ArrayList<Integer> getTryNumbers() {
		return tryNumbers;
	}
	public void setTryNumbers(ArrayList<Integer> tryNumbers) {
		this.tryNumbers = tryNumbers;
	}
	public String getResultPrint() {
		return resultPrint;
	}
	public void setResultPrint(String resultPrint) {
		this.resultPrint = resultPrint;
	}
	
}
