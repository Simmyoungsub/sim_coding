package sorting;

import java.util.Scanner;

public class InsertSorting2 {
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
		int cnt = 0;
		
		for(int i=1;i<arr.length;i++) {
			int current = arr[i];
			
			for(j=i-1; j>=0 && current<arr[j]; j--) {
				arr[j+1] = arr[j];
				cnt++;
			}		
			arr[j+1] = current;
		}
		System.out.println(cnt);
	}
	
	public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j > 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }
	
	public static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}
}
