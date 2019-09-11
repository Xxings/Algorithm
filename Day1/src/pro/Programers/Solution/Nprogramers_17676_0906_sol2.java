// O(N^2) -> O(N)
package pro.Programers.Solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Nprogramers_17676_0906_sol2 {
	public static void main(String[] args) {

		String[] lines = new String[] {
//				"2016-09-15 20:59:57.421 0.351s"
				"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
//				"2016-09-15 01:00:04.002 2.0s",	"2016-09-15 01:00:07.000 2s"
//				"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
//				"2016-09-15 00:00:00.000 3s" 
		};

		Solution a = new Solution();
		System.out.println(a.solution(lines));

	}

	static class Solution {
		public int solution(String[] lines) {
			StringTokenizer st;
			int answer = 0; // @return : int
			String time1; // Date 임시 저장
			String time2; // Duration 임시 저장
			Date dateTime; // 각 스케쥴 데이터로 담음
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			int N = lines.length; // 타임라인 개수
			long duration;
			long[][] dataList = new long[N][2]; // [idx][0] : 시작시간 [idx][1] : 끝시간

			// INPUT DATA
			try {
				for (int idx = 0; idx < N; idx++) {
					st = new StringTokenizer(lines[idx], " ");
					time1 = st.nextToken() + " " + st.nextToken(); // 2016-09-15 20:59:57.421
					time2 = st.nextToken(); // 0.351s
					duration = (long) (Double.parseDouble(time2.substring(0, time2.length() - 1)) * 1000);
					dateTime = (Date) transFormat.parse(time1);

					dataList[idx][0] = dateTime.getTime() - duration + 1; // 시작시간
					dataList[idx][1] = dateTime.getTime(); // 끝나는시간

				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// O(N^2) => O(N)
			int startIdx = 0;
			int endIdx = 0;
			int A = 0;
			Long startpoint = dataList[endIdx][0];
			Long endpoint = dataList[startIdx][1] + 999; // 1초 MAX

			while (true) {
				if (startpoint <= endpoint) {
					System.out.println(startIdx + "  " + endIdx);
					A++;
					if (endIdx == N - 1)
						break;
					startpoint = dataList[++endIdx][0];
				} else {
					// TODO : 시작값이 끝값보다 높음
					endpoint = dataList[++startIdx][1] + 999;
					A--;
				}
			}
			answer = A;
			return answer;
		} // end of solution
	}
}
