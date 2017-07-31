package search;

public class BinarySearch {
	public static void main(String[] args) {
		
		int[] ar = new int[] {2,30,31,32,33,34,35};
		int value = 1;
		int result = binarySearch(ar,0,ar.length-1,value);
		
		if(result  >= 0) {
			System.out.println("value : " + value + ", index : " + result);
		}else {
			System.out.println(value + " 를찾을 수 없습니다.");
		}
		
	}
	
	public static int binarySearch(int[] ar, int start, int end, int value) {
		
		if(start <= end) {
			int mid = (start+end)/2;
			
			if(ar[mid] == value) {
				return mid;
			}else if(ar[mid] > value) {
				return binarySearch(ar,start,mid-1,value);
			}else{
				return binarySearch(ar,mid+1,end,value);
			}
			
		}else {
			return -1;
		}
	}
	
}
