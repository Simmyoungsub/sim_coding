package hackerrank.util;

import hackerrank.QuickSorting2;

public class CommonUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void swap(int[] ar , int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public static void swap(int[] ar , int i, int j,int cnt) {
		QuickSorting2.cnt++;
		swap(ar,i,j);
	}
	
	public static void printArray(int[] ar,int start,int end) {
		for(int i=start;i<=end;i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}
}
