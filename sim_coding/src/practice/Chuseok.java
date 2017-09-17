package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Chuseok {
	public static void main(String[] args) throws Exception {
		
		Chuseok ch = new Chuseok();
		
//		String[] lines = new String[] {
//				"2016-09-15 20:59:57.421 0.351s",
//				"2016-09-15 20:59:58.233 1.181s",
//				"2016-09-15 20:59:58.299 0.8s",
//				"2016-09-15 20:59:58.688 1.041s",
//				"2016-09-15 20:59:59.591 1.412s",
//				"2016-09-15 21:00:00.464 1.466s",
//				"2016-09-15 21:00:00.741 1.581s",
//				"2016-09-15 21:00:00.748 2.31s",
//				"2016-09-15 21:00:00.966 0.381s",
//				"2016-09-15 21:00:02.066 2.62s"
//		};
		
//		String[] lines = new String[] {
//				"2016-09-15 01:00:04.002 2.0s",
//				"2016-09-15 01:00:07.000 2s"
//		};
		
		String[] lines = new String[] {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		
		int result = ch.solution(lines);
		System.out.println(result);
//		
//		System.out.println(result);
	//	ch.printTime(lines);
		
	}
	
	public Map<String,Long> convertStringToMs(String time) throws ParseException {
		String[] split_item = time.split(" ");
		String end_time = split_item[0] + " " + split_item[1]; 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS",Locale.KOREA);
		Date date = format.parse(end_time);
		int diff = (int)(Float.parseFloat(split_item[2].substring(0, split_item[2].length()-1))*1000);
		long end_time_ms = date.getTime();
		long start_time_ms = end_time_ms - diff;
		
		Map<String,Long> map = new HashMap<>();
		map.put("start_time", start_time_ms);
		map.put("end_time", end_time_ms);
		
		return map;
	}
	
	public int checkTime(Map<String,Long> target,List<Map<String,Long>> dataList) {
		int cnt = 0;
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		
		long target_start_time = target.get("start_time");
		long target_end_time = target.get("end_time");
		
		System.out.println("target start time : " + f.format(new Date(target_start_time)));
    	System.out.println("target end time : " + f.format(new Date(target_end_time)));
    	System.out.println("");
		
		for(Map<String,Long> log : dataList) {
			
			long log_start_time = log.get("start_time"); 
			long log_end_time = log.get("end_time");
			
			System.out.println("log start time : " + f.format(new Date(log_start_time)));
        	System.out.println("log end time : " + f.format(new Date(log_end_time)));
        	System.out.println("");
			
			if( (log_start_time<=target_start_time && target_start_time<=log_end_time) || (log_start_time<=target_end_time && target_end_time<=log_end_time) ) {
				cnt++;
			}else if( log_end_time+6000 >= target_start_time || target_end_time+6000 >= target_end_time ) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public int solution(String[] lines) throws ParseException {
        String[] result = {};
//        List<Map<String,String>> parsing = new ArrayList<>();
        List<Map<String,Long>> parsing = new ArrayList<>();
        int max = 0;
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        
        for(String line : lines) {
        	parsing.add(convertStringToMs(line));
        }
        
        for(int i=0;i<parsing.size();i++) {
        	Map<String,Long> target = parsing.get(i);
        	max = Math.max(max, this.checkTime(target, parsing));
        }
        
//        for(int i=0;i<lines.length;i++) {
//        	Map<String,String> item = new HashMap<>();
//        	String log = lines[i];
//        	String[] split_s = log.split(" ");
//        	
//        	item.put("start", getStart(split_s[1],split_s[2].substring(0, split_s[2].length()-1)));
//        	item.put("end", split_s[1]);
//        	parsing.add(item);
//        }
//        
//        parsing.sort(new Comparator<Map<String,String>>() {
//
//			@Override
//			public int compare(Map<String, String> o1, Map<String, String> o2) {
//				
//				return o1.get("start").compareTo(o2.get("end"));
//			}
//		});
//        
//        
//        for(int i=0;i<parsing.size();i++) {
//        	Map<String,String> item = parsing.get(i);
//        	int cnt = 0;
//        	
//        	for(int j=0;j<parsing.size();j++) {
//        		Map<String,String> subItem = parsing.get(j);
//        		
//        		if(inTimeLimit(item.get("start"),item.get("end"),subItem)) {
//        			cnt ++;
//        		}
//        	}
//        	max = Math.max(max, cnt);
//        }
        
        return max;
	}
	
	public String getStart(String start,String process) {
		String result = "";
		String[] time_spl = start.split(":");
		String ss = time_spl[2];
		
		float mill = Float.parseFloat(ss)-Float.parseFloat(process);
		
		result = time_spl[0]+ ":" + time_spl[1]+ ":" + mill;
		
		return result;
	}
	
	public boolean inTimeLimit(String start, String end, Map<String,String> item) {
		boolean result = false;
		
		String item_start = item.get("start");
		String item_end = item.get("end");
		
		if(start.compareTo(item_start)<=0 && end.compareTo(item_end)>=0) {
			result = true;
		}else if(start.compareTo(item_end)<=0 && end.compareTo(item_end)>=0) {
			result = true;
		}else if(end.compareTo(item_start)>=0 && start.compareTo(item_start)<=0) {
			result = true;
		}
		
		return result;
	}
}
