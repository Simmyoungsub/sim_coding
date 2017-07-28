package sorting;

import java.util.Scanner;

public class CountingSort2 {
	
	public static final int MAX_VALUE = 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] ar = new int[n];
		
		for(int i=0;i<n;i++) {
			ar[i] = sc.nextInt();
		}
		long start = System.currentTimeMillis();
		countingSort(ar,n);
		long end = System.currentTimeMillis();
		long diff = end -start;
		System.out.println("소요 시간 : " + diff/1000.0f);
		sc.close();
	}
	
	public static void countingSort(int[] ar , int n ) {
		int[] coutingArray = counting(ar,n);
		sort(coutingArray,coutingArray.length);
		
	}
	
	public static int[] counting(int[] ar, int n) {
		int[] countingSort = new int[MAX_VALUE];
		
		for(int i=0;i<n;i++) {
			countingSort[ar[i]] += 1;
		}
		
		//CommonUtils.printArray(countingSort, 0, countingSort.length-1);
		return countingSort;
	}
	
	public static void sort(int[] ar, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<ar[i];j++) {
				System.out.print(i + " ");
			}
		}
		System.out.println("");
	}
}
