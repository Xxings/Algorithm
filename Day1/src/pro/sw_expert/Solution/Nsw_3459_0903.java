package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nsw_3459_0903 {
	static long N;
//	static List<Integer> dp = new ArrayList<Integer>();	//10^18승 이라 불가

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			boolean ans = true; // (ans)? Alice | BOB
			N = stol(br.readLine());
			int x = 1;

			int cnt = 1;

			if (N == 1) {
				ans = false;
			}else if(N == 2 || N == 3) {
				ans = true;
			}		
			else {

				while (N+1 > (1L << cnt)) { // 2^n
					cnt++;
				}
				if( (cnt&1) >0) {	//odd
					ans = false;
				}
				if (N-2 < ((1L << cnt))) {
					ans = !ans;
				}
				System.out.print((1L << cnt)-1);
				System.out.print("<");
				System.out.print(N);
				System.out.println();
				System.out.print(N);
				System.out.print("<");
				System.out.print((1L << (cnt))+2);
				System.out.print(" ");
				System.out.println(N-2 < (1L << (1L << cnt)));
				System.out.println((ans) ? "Alice" : "Bob");
				System.out.println("=======");
			}
			sb.append("#").append(Tcase).append(" ");
			sb.append((ans) ? "Alice" : "Bob").append("\n");
		}	// end of TC
		
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static long stol(String str) {
		return Long.parseLong(str);
	}
}
