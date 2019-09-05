
package pro.backjoon.Main;

import java.util.Scanner;

public class bk_11726 {
	static int[] dp = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		dp[1] = 1;
		dp[2] = 2;
		
		final int MOD = 10_007;
		
		for (int loop = 3; loop <= N; loop++) {
			if(dp[loop]!=0)
				continue;
			dp[loop] = (dp[loop-1] + dp[loop-2])%MOD;
		}
		
		
		System.out.println(dp[N]);
		
	}
}
