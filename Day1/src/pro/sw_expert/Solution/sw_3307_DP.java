package pro.sw_expert.Solution;

import java.util.Scanner;

public class sw_3307_DP {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, cmp, cnt;
		int[] arr, dp;
		
		int T = sc.nextInt();
		int result=0;
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			result = 0;
			N = sc.nextInt();
			arr = new int[N];
			dp = new int[N];
			// 입력부
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int j = 0; j < arr.length; j++) {
				cmp = arr[j];	//첫값
				cnt = dp[j];
				for (int j2 = j+1; j2 < arr.length; j2++) {
					if(arr[j2] < cmp || dp[j2]>cnt )
						continue;
//					if(arr[j2] >= cmp & dp[j2]<(cnt+1)) {	//LIS <=
					dp[j2] = cnt+1;
//				}
					result=Math.max(result, dp[j2]);
				}
			}
			
//			for(int current : dp)
//				if (current > result)
//					result=current;
			
			System.out.println("#" + Tcase + " " + (result+1));
		}
	}
}
