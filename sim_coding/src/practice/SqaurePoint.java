package practice;

public class SqaurePoint {
	public static void main(String[] args) {
		int[][] points = new int[][]{
			{1,4},
			{3,4},
			{3,10}
		};
		
		int[] result = solution(points);
		
		System.out.println(result[0]+", "+result[1]);
		
	}
	
	public static int[] solution(int[][] v) {
        int[] answer = {};
        answer = new int[2];
        int x1=0,x2=0;
        int y1=0,y2=0;
        int x_sum = 0;
        int y_sum = 0;
        int ori_sum_x = 0;
        int ori_sum_y = 0;
        
        for(int i=0;i<v.length;i++) {
        	int[] item = v[i];
        	
        	if(x1 == 0 || x1 == item[0]) {
        		x1 = item[0];
        	}else {
        		x2 = item[0];
        	}
        	
        	if(y1 == 0 || y1 == item[1]) {
        		y1 = item[1];
        	}else {
        		y2 = item[1];
        	}
        	
        	x_sum += item[0];
        	y_sum += item[1];
        }
        
        ori_sum_x = x1*2 + x2*2;
        ori_sum_y = y1*2 + y2*2;
        
        answer[0] = ori_sum_x - x_sum;
        answer[1] = ori_sum_y - y_sum;
        
        return answer;
    }
}
