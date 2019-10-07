/*
21,696 kb
메모리
846 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_1249_191007 {
	static int ans;
	static int N;
	static int[][] map = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	static int[][] memory = new int[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			ans = Integer.MAX_VALUE;
			//맵 - dp ->  [상하좌우] 이므로X
			N = stoi(br.readLine());
			
			memory = new int[N][N];
			visited = new boolean[N][N];
			for (int row = 0; row < N; row++) {
				String input = br.readLine();
				for (int col = 0; col < N; col++) {
					map[row][col] = input.charAt(col)-'0';
				}
				//'0'~'9'
				Arrays.fill(memory[row],0,N,-1);
				Arrays.fill(visited[row],0,N,false);
			}
			//DFS로
			visited[0][0] = true;
			
			dfs(0,0,(map[0][0]));	//row,col,cost
			
			
			
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	static final int[] dR = new int[] {0,1,-1,0};	//우하상좌
	static final int[] dC = new int[] {1,0,0,-1};	//
	private static void dfs(int curR, int curC, int cost) {
		if(memory[curR][curC]<0) memory[curR][curC]=cost;
		else if(memory[curR][curC] <= cost) return;
		else {
			memory[curR][curC] = cost;
		}
		if(cost>ans) return;
		if(curR==N-1 && curC == N-1) {
			if(ans>cost) {
				ans=cost;
			}
			return;
		}	//종료조건
		for (int dir = 0; dir < 4; dir++) {
			int goR = curR + dR[dir]; 
			int goC = curC + dC[dir]; 
			if(goR<0 || goR>N-1 || goC <0 || goC>N-1) continue;	//맵 밖을나감
			if(visited[goR][goC]) continue;
			visited[goR][goC] = true;
			dfs(goR,goC,cost+(map[goR][goC]));
			visited[goR][goC] = false;
		}
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
