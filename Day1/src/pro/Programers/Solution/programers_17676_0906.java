package pro.Programers.Solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class programers_17676_0906 {
	public static void main(String[] args) {
		
		String[] lines = new String[] { 
				"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
//				"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
				};

		Solution a = new Solution();
		System.out.println(a.solution(lines));

	}

	static class Solution {

		public int solution(String[] lines) {
			StringTokenizer st;
			int answer = 0;
			Date dateTime;
			String time1;
			String time2;
			int N = lines.length;
			long duration;
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			long[] dataList = new long[lines.length];
			long[] durationList = new long[lines.length];
			
			//INPUT DATA
			try {
				for (int idx = 0; idx < N; idx++) {
					st = new StringTokenizer(lines[idx], " ");
					time1 = st.nextToken() + " " + st.nextToken();
					time2 = st.nextToken();
					duration = (long)(Double.parseDouble(time2.substring(0, time2.length()-1))*1000);
					dateTime = (Date) transFormat.parse(time1);
					dataList[idx] = dateTime.getTime();
					durationList[idx] = duration;
					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(Arrays.toString(dataList));
//			System.out.println(Arrays.toString(durationList));
			
			for (int front = 0; front < N; front++) {
				long maxTime = dataList[front];	//1초
				int result = 1;
				for (int rear = front+1; rear < N; rear++) {
					long cmpTime = dataList[rear]-durationList[rear]+1-999;
//					System.out.println("======"+front + "vs" + rear);
//					System.out.println(cmpTime + " " + maxTime);
					if(cmpTime <= maxTime) {
//						System.out.println("+1");
						result++;
					}
				}
//				System.out.println("########"+front+"  : "+result);
				if(answer > N-front) {	//가지치기
					break;
				}
				if(answer < result) {
					answer = result;
				}
			}
			
			
			return answer;
		}
	} // end of solution
}
