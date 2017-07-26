package algorithm.kakao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
		long start = System.currentTimeMillis();
		//quickSort(unsorted,0,n-1);
		usingComparator(unsorted,n);
		long end = System.currentTimeMillis();
		long diff = end - start;
		for(String s : unsorted) {
        	System.out.println(s);
        }
		System.out.println("-------------------------------------");
		System.out.println("전체 소요시간  : " + diff/1000.f);
	}
	
	public static void qSort(String[] ar, int s, int e) {
		String pivot = ar[(s + e) / 2];
		int left = s, right = e;

		while (left < right) {
			while (left < right && compare(pivot, ar[left]))
				left++;
			while (left < right && compare(ar[right], pivot))
				right--;

			if (left < right) {
				String temp = ar[left];
				ar[left] = ar[right];
				ar[right] = temp;
			}
		}
		
		//pivot change
		String tmp = ar[(s + e) / 2];
		ar[(s + e) / 2] = ar[right];
		ar[right] = tmp;
		
//		for(int i=0;i<ar.length;i++) {
//			System.out.print(ar[i]+" ");
//		}
		//System.out.println("");
		
		if (s < right)
			qSort(ar, s, right-1);
		if (e > left)
			qSort(ar, left+1, e);
	}
	
	public static void quickSort(String[] arr, int left, int right) {
		 
        if (arr == null || arr.length < 0)
            return;
 
        if (left < 0 || right < 0)
            return;
 
        if (left >= right) {
            return;
        }
 
        int lowIdx = left + 1;
        int highIdx = right;
        String pivot = arr[left];
 
        while (lowIdx <= highIdx) {
            while (lowIdx <= right && compare(pivot,arr[lowIdx])) {
                lowIdx++;
            }
 
            while (left + 1 <= highIdx && compare(arr[highIdx],pivot)) {
                highIdx--;
            }
 
            if (lowIdx <= highIdx) {
                String temp = arr[lowIdx];
                arr[lowIdx] = arr[highIdx];
                arr[highIdx] = temp;
            } else {
                arr[left] = arr[highIdx]; // pivot이 자신의 자리를 찾아가는 과정
                arr[highIdx] = pivot;
            }
        }
 
        quickSort(arr, left, highIdx - 1);
        quickSort(arr, highIdx + 1, right);
    }
	
    public static void bubbleSort(String[] arr, int start, int end) {
		for(int i=start;i<=end;i++) {
			for(int j=i;j<=end;j++) {
				if(compare(arr[i],arr[j])) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void qSort(int[] ar, int s, int e) {
		int pivot = ar[s];
		int left = s, right = e;
		
		 do{
			while(ar[left]<pivot) left++;
			while(ar[right]>pivot) right--;
			
			if(left <= right) {
				int temp = ar[left];
				ar[left] = ar[right];
				ar[right] = temp;
				left++;
				right--;
			}
		}while(left<=right);
		
		if(s<right) qSort(ar,s,right);
		if(e>left) qSort(ar,left,e);
	}
	
	public static boolean compare(String o1 , String o2) {
		
		if(o1.length() > 6 || o2.length() > 6) {
			boolean result = compareBigNumber(o1,o2);
			return result;
		}else {
			int diff = Integer.parseInt(o1) - Integer.parseInt(o2);
			return diff<0? false : true;
		}
	}
	
	public static boolean compareBigNumber(String o1, String o2) {
		char[] o1_ar;
		char[] o2_ar;
		
		//변환
		if(o1.length() > o2.length()) {
			int diff = o1.length() - o2.length();
			o1_ar = o1.toCharArray();
			o2_ar = convertStringtoCharArray(o2,diff);
		}else if(o1.length() < o2.length()) {
			int diff = o2.length() - o1.length();
			o1_ar = convertStringtoCharArray(o1,diff);
			o2_ar = o2.toCharArray();
		}else {
			o1_ar = o1.toCharArray();
			o2_ar = o2.toCharArray();
		}
		int[] result = new int[o1_ar.length];
		
		for(int i=0;i<o1_ar.length;i++) {
			int diff = o1_ar[i] - o2_ar[i];
			result[i] = diff;
		}
		
		for(int i=0;i<result.length;i++) {
			if(result[i] > 0) {
				return true;
			}else if(result[i] < 0 ) {
				return false;
			}
		}
		
		return true;
	}
	
	public static char[] convertStringtoCharArray(String o1, int cnt) {
		String tmp="";
		
		for(int i=0;i<cnt;i++) {
			tmp += '0';
		}
		
		tmp += o1;
		
		return tmp.toCharArray();
	}
	
	public static void usingComparator(String[] arr, int n) {
		Arrays.sort(arr, new Comp());
	}
	
}

class Comp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		
		if(o1.length() == o2.length()) {
			return o1.compareTo(o2);
		}else {
			return o1.length() - o2.length();
		}
	}
	
}