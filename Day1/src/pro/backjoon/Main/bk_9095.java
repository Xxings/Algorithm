package pro.backjoon.Main;

import java.util.Scanner;

public class bk_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dp = new int[10000];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;	//4
		dp[4] = dp[3]+dp[2]+dp[1];	//7
		dp[5] = dp[4]+dp[3]+dp[2];
		dp[6] = dp[5]+dp[4]+dp[3];
		dp[7] = dp[6]+dp[5]+dp[4];
		dp[8] = dp[7]+dp[6]+dp[5];
		dp[9] = dp[8]+dp[7]+dp[6];
		dp[10] = dp[9]+dp[8]+dp[7];
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int N = sc.nextInt();
			
		
			System.out.println(dp[N]);	
		}
	}
}
