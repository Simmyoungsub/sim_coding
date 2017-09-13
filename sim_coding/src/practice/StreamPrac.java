package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPrac {
	public static void main(String[] args) {
//		List<String> lines = Arrays.asList("apple","banana","grape");
//		
//		List<String> result = lines.stream().filter(line -> !"grape".equals(line)).collect(Collectors.toList());
//		
//		result.forEach(System.out::println);
		
		StreamPrac sp = new StreamPrac();
		int[] arr = new int[] {4,1,3};
		List<Integer> list = sp.setList(arr);
		
		list.forEach(System.out::println);
	}
	
	public List<Integer> setList(int[] arr){
		
		//List<Integer> list = Arrays.stream(arr).collect(Collectors.toList());
		List<Integer> list = null;
		return list;
	}
}
