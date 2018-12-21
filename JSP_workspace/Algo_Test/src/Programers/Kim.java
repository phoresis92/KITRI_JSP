package Programers;

import java.util.Arrays;
import java.util.Vector;

public class Kim {

	public static String seobang1(String[] seoul) {
		
		String result = null;
		for (int i = 0; i < seoul.length; i++) {
			if ((seoul[i].equals("Kim")))
				result = "김서방은 "+ i +"에 있다";
		}

		return result;

	}
	
	public static String seobang2(String[] seoul) {
		
		int x = Arrays.asList(seoul).indexOf("Kim");
		
		return "김서방은 "+ x +"에 있다";
		
	}
	
	public static void main(String[] args) {
		
		String[] seoul = {"Jane","Jane","Jane","Kim"};
		
		System.out.println(seobang1(seoul));
		
		System.out.println(seobang2(seoul));
		
	}
}
