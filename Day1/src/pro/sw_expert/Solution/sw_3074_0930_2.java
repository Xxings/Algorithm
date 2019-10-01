/*
 * 59,728 kb->59,784 kb
	메모리
   567ms 	-> 489 ms ->418ms
	실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_3074_0930_2 {
	static int N;
	static int M;
	static long[] tester;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		long MIN;						//시작
		long MID;
		long MAX;						//종료
		Long ans;
		StringTokenizer st;
		for(int Tcase=1; Tcase <= T; Tcase++){
			ans = 0L;
			MIN = 1L;						//시작
			MAX = 1L;						//종료
			st = new StringTokenizer(br.readLine(), " ");
			N = stoi(st.nextToken()); // 테이블 수
			M = stoi(st.nextToken());

			tester = new long[N];
			for (int idx = 0; idx < tester.length; idx++) {
				tester[idx] = stol(br.readLine());
				if(MAX<tester[idx]) {
					MAX=tester[idx];
				}
			}
			MIN = 1;
			MAX = M*MAX;
			
			while(MIN <= MAX) {
				MID = (MAX+MIN)/2;
//				System.out.println(MID);
				if(isOK(MID)) {	//좌측
					ans = MID;
					MAX = MID-1;
				}else{	//우측
					MIN = MID+1;
				}
			}
			
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	private static long stol(String readLine) {
		// TODO Auto-generated method stub
		return Long.parseLong(readLine);
	}
	private static boolean isOK(long MID) {
		// TODO Auto-generated method stub
		long cnt = 0;
		for (int idx = 0; idx < tester.length; idx++) {
			cnt += MID/tester[idx];
			if(cnt>=M) return true;
		}
//		System.out.println(cnt+" : cnt");
		return false;
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
