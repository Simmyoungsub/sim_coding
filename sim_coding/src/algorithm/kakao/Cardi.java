package algorithm.kakao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author sim
 * 각 data의 2진수 1의 갯수를 구하여 갯수를 기준으로 오름차순으로 정렬
 */
public class Cardi {
	
	private static final int MAX_LEN = 20;
	
	public static int[] test(int[]data) {
		
		int[] copy_data = data.clone();
		int[] result=new int[data.length];
		int result_idx = 0;
		boolean[] cardinal_set = new boolean[MAX_LEN];
		List<Integer> cardinal_arr = new ArrayList<>();
		
		Arrays.sort(copy_data);
		
		for(int i : copy_data) {
			int value = cardinality(i);
			cardinal_arr.add(value);
			hasCardinal(cardinal_set,value);
		}
		
		for(int i=0;i<cardinal_set.length;i++) {
			if(cardinal_set[i]) {
				int value = i+1;
				
				List<Integer> indexes = getIndexes(cardinal_arr,value);
				
				for(Integer item : indexes) {
					result[result_idx++] = copy_data[item];
				}
			}
		}
		
		return result; 
	}
	/**
	 * 
	 * @param cardinal_arr
	 * @param value
	 * 
	 * 배열 요소들 중에서 value값과 일치하는 인덱스값들의 리스트를 반환
	 * @return
	 */
	public static List<Integer> getIndexes(List<Integer> cardinal_arr, int value){
		List<Integer> indexes = new ArrayList<>();
		
		for(int j=0;j<cardinal_arr.size();j++) {
			
			if(cardinal_arr.get(j) == value) {
				indexes.add(j);
			}
		}
		
		return indexes;
	}
	/**
	 * 테스트용으로 사용함
	 * @param data
	 */
	@Deprecated
	public static void printBoolArray(boolean[] data) {
		for(boolean b : data) {
			System.out.print(b);
			System.out.print(" ");
		}
	}
	/**
	 * 테스트용
	 * @param value
	 */
	@Deprecated
	public static void print(Object value) {
		//System.out.print(value);
		//System.out.print(" ");
	}
	public static void printIntArray(int[] data) {
		for(int i : data) {
			System.out.println(i);
		}
	}
	/**
	 * set에 value값이 존재하는지 검사
	 * @param cardinal_set
	 * @param value
	 */
	public static void hasCardinal(boolean[] cardinal_set, int value) {
		if(!(cardinal_set[value-1])) {
			cardinal_set[value-1] = true;
		}
	}
	/**
	 * 2진수로 변환하여 값을 반환
	 * @param data
	 * @return
	 */
	public static String convertToBinary(int data) {
		print(data);
		return Integer.toBinaryString(data);
	}
	/**
	 * 2진수의 1의 갯수를 반환
	 * @param data
	 * @return
	 */
	public static int cardinality(int data) {
		//int value = binarySum(convertToBinary(data));
		int value = binarySum(data);
		print(value);
		return value;
	}
	/**
	 * binary의 1의 갯수를 구함
	 * @param binary
	 * @return
	 */
	public static int binarySum(String binary) {
		print(binary);
		
		int sum = 0;
		
		for(int i=0;i<binary.length();i++) {
			sum += binary.charAt(i)-'0';
		}
	
		return sum;
	}
	
	public static int binarySum(int data) {
		int cnt = 0;
		
		while(data != 0) {
			if((data & 1) ==  1) {
				cnt++;
			}
			data = data>>>1;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		File f = new File("C:\\Users\\dbs\\eclipse-workspace\\test\\src\\test\\data.txt");
		FileReader fr = null;
		BufferedReader bs = null;
		
		try {
			fr = new FileReader(f);
			bs = new BufferedReader(fr);
			String line = "";
				
			while((line = bs.readLine()) != null) {
				String[] split_s = line.split(",");
				int[] data = new int[split_s.length];
				int data_idx = 0;
				
				for(String item : split_s) {
					data[data_idx++] = Integer.parseInt(item);
				}
				long start = System.currentTimeMillis();
				int[] result = test(data);
				long end = System.currentTimeMillis();
				long diff = end - start;
				printIntArray(result);
				System.out.println("데이터 수 : " + data.length);
				System.out.println("소요시간  : " + (long)(diff)/1000.0f + " 초");
				System.out.println("---------------------------------------------------");
			}
			fr.close();
			bs.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
