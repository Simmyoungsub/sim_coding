package hackerrank;

import java.util.Scanner;

public class SortingChallenge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int value = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			if(arr[i] == value) {
				System.out.println(i);
			}
		}
	}
	
	public int searchValueIndex(int[] ar) {
		return 0;
	}
}
