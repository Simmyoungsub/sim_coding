package hackerrank;

import java.util.Scanner;

import hackerrank.util.CommonUtils;

public class QuickSorting2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		
		for(int i=0;i<n;i++) {
			ar[i] = sc.nextInt();
		}
		long start = System.currentTimeMillis();
		quickSort(ar, 0, ar.length-1);
		long end = System.currentTimeMillis();

		System.out.println("소요시간 : " + (end-start)/1000.0f);
		
		sc.close();
	}
	
	public static void quickSort(int[] ar,int start,int end) {
		if(start < end) {
			int quick_sort_idx = partition(ar,start,end,"mid");
			quickSort(ar,start,quick_sort_idx-1);
			quickSort(ar,quick_sort_idx+1,end);
			CommonUtils.printArray(ar,0,ar.length-1);
		}
	}
	
	public static int partition(int[] ar, int start, int end, String mode) {
		switch(mode) {
		case "start":
			return partitionStartPoint(ar,start,end);
		case "end":
			return partitionEndPoint(ar,start,end);
		case "mid":
			return partitionMidPoint(ar,start,end);
		default :
			return partitionMidPoint(ar,start,end);
		}
	}
	
	public static int partitionStartPoint(int[] ar, int start, int end) {
		int pivot_idx = start;
		int pivot = ar[pivot_idx];
		int left = start+1;
		int right = end;
		
		while(left <= right) {
			while((left<=right) && (ar[left] <= pivot)) left++;
			while((left<=right) && (ar[right] >= pivot)) right--;
			
			if(left<=right) {
				CommonUtils.swap(ar,left,right);
			}
		}
		
		CommonUtils.swap(ar,pivot_idx,right);
		
		return right;
	}
	
	public static int partitionEndPoint(int[] ar, int start, int end) {
		int pivot_idx = start;
		int pivot = ar[pivot_idx];
		int left = start+1;
		int right = end;
		
		while(left <= right) {
			while((left<=right) && (ar[left] <= pivot)) left++;
			while((left<=right) && (ar[right] >= pivot)) right--;
			
			if(left<=right) {
				CommonUtils.swap(ar,left,right);
			}
		}
		
		CommonUtils.swap(ar,pivot_idx,right);
		
		return right;
	}
	
	public static int partitionMidPoint(int[] ar, int start, int end) {
		int pivot_idx = (start+end)/2;
		int pivot = ar[pivot_idx];
		int left = start;
		int right = end;
		
		while(left < right) {
			while((left<right) && (ar[left] < pivot)) left++;
			while((left<right) && (ar[right] > pivot)) right--;
			
			if(left<right) {
				CommonUtils.swap(ar,left,right);
			}
		}
		//start나 end는 start 혹은 end의 포인트 지점이 1씩 차이가 나기때문에 mid와는 다름 
		//CommonUtils.swap(ar,pivot_idx,left);
		
		return left;
	}
}
