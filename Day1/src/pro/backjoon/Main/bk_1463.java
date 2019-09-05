package pro.backjoon.Main;

import java.util.Arrays;
import java.util.Scanner;

public class bk_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int [N+1];	//1부터 시작
		dp[1] = 0;
		
		if(N>2)
			dp[3] = 1;
		if(N>1)
			dp[2] = 1;
		
		int temp;
		for (int i = 4; i < dp.length; i++) {
			//3으로 나눠질 경우
			temp = 9999;
			if(i%3 == 0) {
				temp = dp[i/3]+1;
			}
			//2로 나눠질 경우
			else if(i%2 == 0) {
				temp = dp[i/2]+1;
			}
			//1빼기와 나누기 MIN 비교
			dp[i] = Math.min(temp, dp[i-1]+1);
		}
		System.out.println(dp[N]);
//		System.out.println(Arrays.toString(dp));
		
	} // end of main
}
