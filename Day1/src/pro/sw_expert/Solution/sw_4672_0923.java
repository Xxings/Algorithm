/*
18,288 kb
메모리
117 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw_4672_0923 {
	//펠린드롭
	static final int nAlpabet = 26;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] countSet = new int[nAlpabet];	//알파벳 개수 
		for(int Tcase=1; Tcase <= T; Tcase++){
			//_init_
			Arrays.fill(countSet, 0);
			int ans = 0;
			//_input_
			String input = br.readLine();
			for (int idx = 0; idx < input.length(); idx++) {
				int data = input.charAt(idx)-'a';
				countSet[data]++;
			}
			
			//_Calc_
//			System.out.println(Arrays.toString(countSet));
			for (int idx = 0; idx < nAlpabet; idx++) {
				if(countSet[idx]>0) {
						ans+=countSet[idx]*(countSet[idx]+1)/2;
				}
			}
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
