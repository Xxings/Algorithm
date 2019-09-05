package pro.Programers.Solution;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class programers_17676_0903 {
	public static void main(String[] args) {
		String[] lines = new String[] {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		
		Solution a = new Solution();
		System.out.println(a.solution(lines));
		
	}
	
	static class Solution {
		static StringTokenizer st;
		static StringTokenizer st1;
		public int solution(String[] lines) {
		      int answer = 0;
		      st = new StringTokenizer(lines[0]," ");
		      String time = st.nextToken()+" "+st.nextToken();
		      st1 = new StringTokenizer(lines[1]," ");
		      String time2 = st1.nextToken()+" "+st1.nextToken();
		      System.out.println(time);
		      SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
		      try {
				Date data = (Date) transFormat.parse(time);
				Date data2 = (Date) transFormat.parse(time2);
				System.out.println(data);
				long now = data.getTime();
				long now2 = data2.getTime();
				
				System.out.println(now);
				System.out.println(now2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      //		      String time = st.nextToken().substring(6);	//04.001
//		      String temp = "54.000";
//		      System.out.println(time.compareTo(temp));	// (1 : >) (-1 : <)
//		      
//		      int result = 0;
//		      for (int st = 0; st < lines.length; st++) {	//기준점
//		    	  String end = time;
//				for (int next = st+1; next < lines.length; next++) {
//					
//				}
//				if(answer < result ) {
//					answer = result;
//				}
//			}
		      
//		      String time2 = st.nextToken().replace("s", "");
		      
//		      System.out.println(time);
//		      System.out.println(time2);
		      return answer;
		  }
		}
}
