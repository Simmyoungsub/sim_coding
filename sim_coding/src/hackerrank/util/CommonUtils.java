package hackerrank.util;

public class CommonUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void swap(int[] ar , int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public static void printArray(int[] ar,int start,int end) {
		for(int i=start;i<=end;i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}
}
