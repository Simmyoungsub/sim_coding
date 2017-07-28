package sorting;

import java.util.Scanner;

public class InsertSorting1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		insertSorting(arr);
	}
	
	public static void insertSorting(int[] arr) {
		
		int j = 0;//삽입될 자리를 기억하기 위해 
		
		for(int i=(arr.length-1);i>=0;i--) {
			int current = arr[i];
			
			for(j=i-1; j>=0 && current<arr[j]; j--) {
				arr[j+1] = arr[j];
				printArray(arr);
			}		
			arr[j+1] = current;
		}
		printArray(arr);
	}
	
	public static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}
}
