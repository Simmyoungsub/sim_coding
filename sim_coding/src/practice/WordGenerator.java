package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordGenerator {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String target1 = "banana";
		String target2 = "apple";
		String target3 = "banana";
		String str1[] = {"ba","na","n","a"};
		String str2[] = {"app","ap","p","l","e","ple","pp"};
		String str3[] = {"ba","an","nan","ban","n"};
		//System.out.println(str.indexOf(word));
		
		int rs1 = match(str1,target1);
		System.out.println(rs1);
		
		int rs2 = match(str2,target2);
		System.out.println(rs2);
		
		int rs3 = match(str3,target3);
		System.out.println(rs3);
	}
	
	
	public static int match(String[] str,String target){
		long start = System.currentTimeMillis();
		int result = -1;
		String t = new String(target);
		
		int cnt = 0;
		int[] min = new int[1];
		bestMatch(str,target,cnt,min);
		
		min[0] = min[0] > 0?min[0]:-1;
		result = min[0];
		
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)/1000.0f);
		return result;
	}
	
	public static void bestMatch(String[] str, String target, int cnt, int[] min) {
		if(target == null) {
			return ;
		}else if("".equals(target)) {
			if(min[0] == 0 || cnt < min[0]) {
				min[0] = cnt;
			}
			return ;
		}else {
			for(int i=0;i<str.length;i++) {
				String item = str[i];
				if(target.indexOf(item) == 0) {
					bestMatch(str,getSubStr(target,item),cnt+1,min);
				}
			}
		}
	}
	
	public static String getSubStr(String src, String target) {
		if(src.contains(target)) {
			return src.substring(target.length());
		}else {
			return null;
		}
	}
}
