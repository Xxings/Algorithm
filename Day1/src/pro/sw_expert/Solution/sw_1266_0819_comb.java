/*
19,464 kb
메모리
124 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_1266_0819_comb {
	static boolean[] decimal;
	static int[] decimalList;
	static double skillOfMasterA;
	static double skillOfMasterB;
	public static void main(String[] args) throws IOException {
		//소수목록
		decimal = new boolean[19];
		decimal[2] = true;
		decimal[3] = true;
		decimal[5] = true;
		decimal[7] = true;
		decimal[11] = true;
		decimal[13] = true;
		decimal[17] = true;
		//7개
		decimalList = new int[19];	//11개
				 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
				
		int T = stoi(br.readLine());
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			double ans = 0.0;
			double reverseAnsA = 0.0;
			double reverseAnsB = 0.0;
			
			sb.append("#").append(Tcase).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			reverseAnsB = 0.0;
			reverseAnsA = 0.0;
			skillOfMasterA = stoi(st.nextToken());
			skillOfMasterB = stoi(st.nextToken());
			
			skillOfMasterA = skillOfMasterA/100.0;
			double reverseSkillOfMasterA = 1-skillOfMasterA;
			skillOfMasterB = skillOfMasterB/100.0;
			double reverseSkillOfMasterB = 1-skillOfMasterB;
			
			for (int idx = 0; idx <= 18; idx++) {
				if(decimal[idx]) continue;
				reverseAnsA+=Combination(18, idx)*(
						Math.pow(skillOfMasterA, idx)*Math.pow(reverseSkillOfMasterA, 18-idx)
						);
				reverseAnsB+=Combination(18, idx)*(
						Math.pow(skillOfMasterB, idx)*Math.pow(reverseSkillOfMasterB, 18-idx)
						);
			}
			
			ans = 1.0-(reverseAnsA*reverseAnsB);
			sb.append(String.format("%6f", ans)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int[][] dp = new int[20][20];
	private static int Combination(int n, int r) {
		// TODO Auto-generated method stub
		if(dp[n][r]!=0) return dp[n][r];
		
		if(n<r) return 0;
		if(n-r<r) return Combination(n,n-r);
		if(r==0 || n==r) {
			return 1;
		}
		dp[n][r] =Combination(n-1,r-1)+Combination(n-1, r);
		return dp[n][r];
	}
	
	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}
}
