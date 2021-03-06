package Sort_test;

public class Selection_Sort {
	
	public static void selection_asc1(int[] arr) {
		
		for(int i = 0 ; i < arr.length-1 ; i++) { //arr.length-1 : 마지막 요소는 자연스럽게 정렬됨
			int min_index = i;
			for(int j = i+1 ; j < arr.length ; j++) {
				
				if(arr[j] < arr[min_index]) {
					min_index = j;
				}
				
			}
			int temp ;
			temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
			
		}
		
		for(int print_num : arr) {
			System.out.print(print_num + " ");
		}
		System.out.println();
		
	}
	
	
	public static void selection_desc1(int[] arr) {
		
		for(int i = 0 ; i < arr.length -1 ; i++) {
			int max_index = i;
			for(int j = i+1 ; j < arr.length ; j++) {
				
				if(arr[max_index] < arr[j]) {
					max_index = j;
				}
				
			}
			int temp;
			temp = arr[max_index];
			arr[max_index] = arr[i];
			arr[i] = temp;
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		
	}
	
	
	public static void selection_asc2(int[] arr) {
		
		for(int i = arr.length-1 ; i >= 1 ; i--) {
			int max_index = i;
			for(int j = i-1 ; j >= 0 ; j--) {
				
				if(arr[max_index] < arr[j]) {
					max_index = j;
				}
				
			}
			int temp = arr[max_index];
			arr[max_index] = arr[i];
			arr[i] = temp;
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void selection_desc2(int[] arr) {
		
		for(int i = arr.length-1 ; i >=1 ; i--) {
			int min_index = i;
			for(int j = i-1 ; j >= 0 ; j--) {
				
				if(arr[min_index] > arr[j]) {
					min_index = j;
				}
				
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {3,40,26,69,12,36};

		//selection_asc1(arr);
		//selection_desc1(arr);
		selection_asc2(arr);
		selection_desc2(arr);
	}
}
