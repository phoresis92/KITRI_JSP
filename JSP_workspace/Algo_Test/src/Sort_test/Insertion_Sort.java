package Sort_test;

public class Insertion_Sort {

	public static void insertion_asc(int[] arr) {
		
		for(int i = 1 ; i < arr.length ; i++) {
			int n = 0;
			for(int j = i-1 ; j >= 0 ; j--) {
				if(arr[i-n] < arr[j]) {
					int temp = arr[i-n];
					arr[i-n] = arr[j];
					arr[j] = temp;
				}
				n++;
			}
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

	}
	
	
	public static void insertion_asc3(int[] arr) {
		
		for(int i = 1 ; i < arr.length ; i++) {
			int temp = arr[i];
			int j = 0;
			for(j = i - 1 ; j >= 0 && temp<arr[j] ; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp; 
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	
	public static void insertion_asc2(int[] arr) {
		
		for(int i = 1 ; i < arr.length ; i++) {
			int other = i-1;
			int standard = arr[i];
			while(standard < arr[other] && other>=0) {
				arr[other+1] = arr[other];
				other--;
			}
			arr[other+1] = standard;
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {3,40,26,69,12,36};
		
		insertion_asc(arr);
		
		insertion_asc2(arr);
		
		insertion_asc3(arr);
		
	}
		
}
