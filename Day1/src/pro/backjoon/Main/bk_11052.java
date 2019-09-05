package pro.backjoon.Main;

import java.util.Scanner;

public class bk_11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[1001];	// 1부터 시작
		int[] val = new int[1001];
		int cmp = 0;
		for (int i = 1; i <= N; i++) {
			 cmp = sc.nextInt();
			 dp[i] = cmp;
			 for(int j = 1; j <=i/2; j++) {
				 cmp = dp[i-j] + dp[j];
				 if(cmp > dp[i])
					 dp[i] = cmp;
			 }
//			 dp[i] = dp[i-1] + dp[1];
//			 val[i] = cmp/i;
//			 if(cmp > dp[i])	//최댓값
//				 dp[i] = cmp;
		}
		
		System.out.println(dp[N]);

	}
}
