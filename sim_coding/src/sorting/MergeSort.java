package sorting;

import hackerrank.util.CommonUtils;

public class MergeSort {
	public static void main(String[] args) {
		
	}
	
	public static void merge_sort(int[] ar, int start, int end) {
		int mid;
		
		if(start < end) {
			mid = (start + end)/2;
			merge_sort(ar, start, mid);
			merge_sort(ar, mid+1, end);
			merge(ar,start,mid,end);
			CommonUtils.printArray(ar,start,end);
		}
	}
	
	public static void merge(int[] ar,int left,int mid, int right) {
		int[] tmpArray = new int[right-left+1];
		int tmp_idx = 0;
		int l =left;
		int r = mid+1;
		
		while((l<=mid) && (r <= right)) {
			if(ar[l] < ar[r]) {
				tmpArray[tmp_idx++] = ar[l++];
			}else {
				tmpArray[tmp_idx++] = ar[r++];
			}
		}
		
		while(l <= mid) {
			tmpArray[tmp_idx++] = ar[l++];
		}
		
		while(r <= right) {
			tmpArray[tmp_idx++] = ar[r++];
		}

		tmp_idx = 0;
		
		for(int i=left;i<=right;i++) {
			ar[i] = tmpArray[tmp_idx++];
		}
	}
}
