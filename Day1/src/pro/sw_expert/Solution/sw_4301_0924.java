/*
 * 25,180 kb
메모리
155 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_4301_0924 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			int ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			boolean[][] map = new boolean[N+1][M+1];	//0안씀
			
			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= M; col++) {
					if(map[row][col]) continue;
					map[row][col] = true;
					ans++;
					if( row+2 <= N) map[row+2][col] = true;
					if( col+2 <= M) map[row][col+2] = true;
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
