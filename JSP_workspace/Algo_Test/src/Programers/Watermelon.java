package Programers;

public class Watermelon {

	public static String subak1(int n) {
		
		String[] arr = {"수", "박"};
		String result ="";
		
		for(int i = 0 ; i < n ; i++) {
			if(i%2 == 0) {
				result += arr[0];
			}else if(i%2 == 1) {
				result += arr[1];
			}
			
		}
		
		return result;
		
	}
	
	
	public static String subak2(int n) {
		
		boolean flag = true;
		String result = "";
		
		while(n--              >0) {
			
			result += flag ? "수" : "박";
			
			flag = !flag;
			
		}
		
		return result;
		
	}
	
	
	public static String subak3(int n) {
		
		StringBuffer result = new StringBuffer();
		
		for(int i = 0 ; i < n ; i++) {
			result.append((i%2 == 0)? "수":"박");
		}
		
		
		
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(subak1(5));
		System.out.println(subak1(2));
		
		System.out.println(subak2(7));
		System.out.println(subak2(4));
		
		System.out.println(subak3(9));
		System.out.println(subak3(1));
		
	}
}
