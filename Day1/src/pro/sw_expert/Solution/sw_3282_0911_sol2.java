package pro.sw_expert.Solution;

import java.util.Scanner;
public class sw_3282_0911_sol2{
	static int[] taste;
	static int[] kalori;
	static int N;
	static int L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			//TESTCASE 시작
			N = sc.nextInt();
			L = sc.nextInt();
			
			taste = new int[N];
			kalori = new int[N];
			
			for (int i = 0; i < N; i++) {
				kalori[i] = sc.nextInt();
				taste[i] = sc.nextInt();
			}
			System.out.println("#"+Tcase+" "+branch(0,0,0));
			
		} 
		
	}
	static int dp[] = new int[100];
	public static int branch(int T_tasts, int T_kalori, int start) {
		if(dp[start] != 0)
			return dp[start];
		
		if(T_kalori>L)
			return T_tasts-taste[start-1];
        
        if(start==N)
			return T_tasts;

		
		return dp[start+1]=(Math.max(
					branch(T_tasts+taste[start], T_kalori+kalori[start], start+1)
					,branch(T_tasts, T_kalori, start+1)));
	}
}