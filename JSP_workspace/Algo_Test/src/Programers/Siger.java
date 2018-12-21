package Programers;

public class Siger {
	
	
	public static String siger(String str, int n) {
		String result = "";
		
		for(int i = 0 ; i < str.length() ; i++) {
			byte st = (byte)str.charAt(i);
			
			int sum = st+n;
			
			if(st > 96) {
				result += (char)(sum%96+96);
			}else if(st > 64) {
				result += (char)(sum%64+64);
			}else if(st == 32) {
				result += (char)32;
			}
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		byte a = 'a';
		byte z = 'z';

		byte A = 'A';
		byte Z = 'Z';
		byte sp = (byte)' ';
		
		
		System.out.println(a);
		System.out.println(z);
		System.out.println();
		System.out.println(z-a);
		System.out.println();
		System.out.println(A);
		System.out.println(Z);
		System.out.println();
		System.out.println(Z-A);
		System.out.println();
		System.out.println(sp);
		
		String str1 =  "a B z";
		String str2 = "z";
		System.out.println(siger(str1, 4));
		System.out.println(siger(str2, 1));
	}
	
}
