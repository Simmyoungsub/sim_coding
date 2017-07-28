package sorting;

import java.util.Scanner;

public class QuickSorting1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] ar = new int[n];
		
		for(int i=0;i<n;i++) {
			ar[i] = sc.nextInt();
		}
		
		quickSorting(ar);
		sc.close();
	}
	
	public static void quickSorting(int[] ar) {
		
		int pivot = ar[0];
		int[] left = partitionLeft(ar,pivot);
		int[] right = partitionRight(ar,pivot);
		
		for(int i : left) {
			System.out.print(i+" ");
		}
		
		System.out.print(pivot+" ");
		
		for(int i : right) {
			System.out.print(i+" ");
		}
	}
	
	public static int[] partitionLeft(int[] ar,int pivot) {
		int[] result = null;
		int n = 0;
		
		for(int i : ar) {
			if(i<pivot) {
				n++;
			}
		}
		
		result = new int[n];
		int result_idx = 0;
		
		for(int i : ar) {
			if(i<pivot) {
				result[result_idx++] = i;
			}
		}
		
		return result;
	}
	
	public static int[] partitionRight(int[] ar,int pivot) {
		int[] result = null;
		int n = 0;
		
		for(int i : ar) {
			if(i>pivot) {
				n++;
			}
		}
		
		result = new int[n];
		int result_idx = 0;
		
		for(int i : ar) {
			if(i>pivot) {
				result[result_idx++] = i;
			}
		}
		
		return result;
	}
}
