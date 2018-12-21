package Sort_test;

public class Bubble_Sort {
	
	public static void bubble_asc1(int[] arr) {
		
		for(int i = 0; i < arr.length ; i ++) {
			for(int j = 0 ; j < arr.length-1-i; j ++) {
				
				if(arr[j] > arr[j+1]) {
					int temp = 0;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
		}
		
	}
	
	
	public static void bubble_desc1(int[] arr) {
		
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j < arr.length-1-i ; j++) {
				
				if(arr[j]<arr[j+1]) {
					int temp = 0;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
		}
		
	}
	
	
	public static void bubble_asc2(int[] arr) {
		
		for(int i = 0 ; i<arr.length ; i++) {
			for(int j = arr.length-1 ; j > i ; j--) {
				
				if(arr[j] < arr[j-1]) {
					int temp = 0;
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					
				}
				
			}
		}
		
	}
	
	public static void bubble_desc2(int[] arr) {
		
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = arr.length-1 ; j > i ; j--) {
				
				if(arr[j] > arr[j-1]) {
					int temp = 0;
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {3,40,26,69,12,36};
		
		int total = 100;
		int[] arrr = new int[total];
		for(int i = 0 ; i < total ; i++) {
			arrr[i] = (int)(Math.random()*100);
		}
		
		/*bubble_asc1(arrr);
		for(int num : arrr) {
			System.out.print(num + " ");
		}*/
		
		/*bubble_desc1(arr);
		for(int num : arr) {
			System.out.print(num + " ");
		}*/
	
		/*bubble_asc2(arr);
		for(int num : arr) {
			System.out.print(num + " ");
		}*/
		
		bubble_desc2(arr);
		for(int num : arr) {
			System.out.println(num + " ");
		}
		
	}
}
