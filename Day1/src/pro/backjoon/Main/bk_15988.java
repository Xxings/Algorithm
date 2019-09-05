package pro.backjoon.Main;

import java.util.Scanner;

public class bk_15988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4; // 4
		dp[4] = dp[3] + dp[2] + dp[1]; // 7
		dp[5] = dp[4] + dp[3] + dp[2];
		dp[6] = dp[5] + dp[4] + dp[3];
		dp[7] = dp[6] + dp[5] + dp[4];
		dp[8] = dp[7] + dp[6] + dp[5];
		dp[9] = dp[8] + dp[7] + dp[6];
		dp[10] = dp[9] + dp[8] + dp[7];

		long MOD = 1_000_000_009L;
		for (int i = 11; i <= 1000000; i++) {
			dp[i] = ((dp[i-1] + dp[i-2] + dp[i-3])%MOD);	//오버플로우
		}
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int N = sc.nextInt();
			
			System.out.println(dp[N]);
		}
	}
}
