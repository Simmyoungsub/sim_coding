package algorithm.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args) {
		String pat1 = "((1[0-9])#|(2[0-6])#|([1-9]))(\\((([1-9][0-9]+)|([2-9]))\\))?";
		String pat2 = "(1[0-9]|2[0-6])#\\((([1-9][0-9]+)|([2-9]))\\)";
		String pat3 = "([1-9]$)|(1[0-9]|2[0-6])#$";
		
		String patt1 = "(([1-9]))(\\(([1-9][0-9]+|[2-9])\\))?";
		String patt2 = "(((1[0-9])#|(2[0-6])#)|([1-9]))\\(([1-9][0-9]+|[2-9])\\)";
		Pattern p = Pattern.compile(pat1);
		String input = "123#17#(3)9(7)25#(5)";
		Matcher m = p.matcher(input);
		List<String> matching = new ArrayList<>();
		List<String> matching2 = new ArrayList<>();
		List<String>noCount = new ArrayList<>();
		List<String>Count = new ArrayList<>();
		int[] alphabets = new int[26];
		
		while(m.find()){
			//System.out.println(m.group(0));
			String fac = m.group(0);
			
			if(fac.indexOf("#")>=0){
				Count.add(fac);
			}else{
				noCount.add(fac);
			}
		}
		
		String px_p = "\\(([1-9][0-9]+|[2-9])\\)";
		Pattern px = Pattern.compile(px_p);

		for(String s : Count){
		//	System.out.println(s);
			String[] split_s = s.split("#");
			
			if(split_s.length == 1){
				alphabets[Integer.parseInt(split_s[0])-1]++;
			}else{
				Matcher px_m = px.matcher(split_s[1]);
				
				if(px_m.find()){
					alphabets[Integer.parseInt(split_s[0])-1] += Integer.parseInt(px_m.group(1));
				}
			}
		}
		
		String px_p2 = "\\(([1-9][0-9]+|[2-9])\\)";
		Pattern px2 = Pattern.compile(px_p2);
		
		for(String s : noCount){
			Matcher px_m2 = px2.matcher(s);
			
			if(px_m2.find()){
				int sub_idx = s.indexOf("(");
				alphabets[Integer.parseInt(s.substring(0, sub_idx))-1] += Integer.parseInt(px_m2.group(1));
			}else{
				alphabets[Integer.parseInt(s)-1]++;
			}
		}
		
		for(int i=0;i<alphabets.length;i++){
			System.out.print(alphabets[i]);
			System.out.print(" ");
		}
	}

}
