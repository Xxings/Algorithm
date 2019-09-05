/*
 * 4단고음
 * 
 */
package pro.Programers.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class programers_1831_0827 {
	public static void main(String[] args) throws IOException {
		Solution test = new Solution();
		System.out.println(test.solution(5));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			int ans=0;
			sb.append("#").append(Tcase).append(" ");
			
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}

	
	public static class Solution {
		public int solution(int n) {
			int answer = 0;
			
			back(n);
			
			
			
			return answer;
		}

		private int back(int n) {
			// TODO Auto-generated method stub
			return 1;
		}
	}
}
