package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_4301_0924_sol_greed {
	/*
	 *  N bean	N/4	M/4
	 *  0   0		0
	 *  1   1		0
	 *  2   2	0	0
	 *  3   2		1
	 *  ============
	 *  4   2		2
	 *  5   3	1	2		1*2 + (0,1,2,2)
	 *  6   4		2
	 *  7   4		3
	 *  ============
	 *  8   4 		4
	 */
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			int ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			
			int[] rest1 = {0,1,2,2};
			int row1 = N/4*2 + rest1[N%4];
			System.out.println("row1 : "+row1);
			
			int[] rest2 = {0,0,0,1};
			int row2 = N/4*2 + rest2[N%4];
			System.out.println("row2 : "+row2);
			
			int result = row1*(M/4)*2 + row1*rest1[M%4]	//홀수행의 개수
					+ row2*(M/4)*2 + row2*rest2[M%4];	//짝수행의 개수
			
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
