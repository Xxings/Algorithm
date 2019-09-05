/*
52,764 kb
메모리
189 ms
실행시간
 * 
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_3459_0903_rules {
	static long N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long X;
		boolean ans;
		int cnt;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			 ans = false; // (ans)? Alice | BOB
			N = Long.parseLong(br.readLine());
			if (N != 1) {
				X = 1L;
				cnt = 3;
				while ( (X += (1L << cnt)) < N) {
					cnt += 2;
				}
				if ((X -= (1L << (cnt - 1))) >= N) {
					ans = !ans;
				}
			}
			sb.append("#").append(Tcase).append(" ");
			sb.append((ans) ? "Alice" : "Bob").append("\n");
		} // end of TC
		System.out.print(sb);
	}
}
