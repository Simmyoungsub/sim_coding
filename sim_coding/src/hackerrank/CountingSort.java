package hackerrank;

import java.util.Scanner;

import hackerrank.util.CommonUtils;

public class CountingSort {
	
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
	
	public static void countingSort(int[] ar, int n) {
		
		int max = 0;
		
		for(int i : ar) {
			if(i > max) {
				max = i;
			}
		}
		
		counting(ar, max,n);
	}
	
	public static void counting(int[] ar, int max, int n) {
		int[] countingSort = new int[max+1];
		
		for(int i=0;i<n;i++) {
			countingSort[ar[i]] += 1;
		}
		
		CommonUtils.printArray(countingSort, 0, countingSort.length-1);
	}
}
