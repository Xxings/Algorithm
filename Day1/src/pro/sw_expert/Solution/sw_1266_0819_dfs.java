package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_1266_0819_dfs {
	static double reverseAnsA;
	static double reverseAnsB;
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
				
//		for (int num = 0; num <= 18; num++) {
//			if(decimal[num]) continue;
//			decimalList[num] = Combination(18,num);
//		}
				 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		double total = (Math.pow(2,18)-1);	//262143
		
		int T = stoi(br.readLine());
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			double ans = 0;
			sb.append("#").append(Tcase).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			reverseAnsB = 0.0;
			reverseAnsA = 0.0;
			skillOfMasterA = stoi(st.nextToken());
			skillOfMasterB = stoi(st.nextToken());
			
			skillOfMasterA = skillOfMasterA/100.0;
			skillOfMasterB = skillOfMasterB/100.0;
			
			CalcA(0,0,1);
			CalcB(0,0,1);
			
			ans = 1.0-(reverseAnsA*reverseAnsB);
			sb.append(String.format("%6f", ans)).append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void CalcA(int count, int save, double skillOfMaster) {
		// TODO Auto-generated method stub
		if(skillOfMaster == 0) return;
		if(count == 18) {
			if(decimal[save]) return;
			reverseAnsA += skillOfMaster;
		}
		else {
			CalcA(count+1, save+1, skillOfMaster*skillOfMasterA);
			CalcA(count+1, save, skillOfMaster*(1-skillOfMasterA));
		}
	}
	
	private static void CalcB(int count, int save, double skillOfMaster) {
		// TODO Auto-generated method stub
		if(count == 18) {
			if(decimal[save]) return;
			reverseAnsB += skillOfMaster;
		}
		else {
			CalcB(count+1, save+1, skillOfMaster*skillOfMasterB);
			CalcB(count+1, save, skillOfMaster*(1-skillOfMasterB));
		}
	}
//	private static int Combination(int n, int r) {
//		// TODO Auto-generated method stub
//		if(n<r) return 0;
//		if(n-r<r) return Combination(n,n-r);
//		if(r==0 || n==r) {
//			return 1;
//		}
//		return Combination(n-1,r-1)+Combination(n-1, r);
//	}
	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}
}
