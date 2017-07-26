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
		usingComparator(unsorted,n);
		long end = System.currentTimeMillis();
		long diff = end - start;
		
		System.out.println("-------------------------------------");
		System.out.println("전체 소요시간  : " + diff/1000.f);
	}
	
	public static void usingComparator(String[] arr, int n) {
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}else {
					return o1.length() - o2.length();
				}
			}
			
		});
		
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
