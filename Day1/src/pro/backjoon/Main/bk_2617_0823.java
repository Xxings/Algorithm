package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bk_2617_0823 {
	static boolean[][] map;
	static int N;
	static int avg;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		avg = (N+1)>>1;
				
		map = new boolean[N+1][N+1];
        visited = new boolean[N+1];
		for (int loop = 0; loop < M; loop++) {
			st = new StringTokenizer(br.readLine());
			int big = stoi(st.nextToken());
			int small = stoi(st.nextToken());
			map[big][small] = true;
		}	//map 삽입
		
        
		for (int loop = 1; loop < N+1; loop++) {
			bigresult = 0;
			smallresult = 0;
			
            visited[loop] = true;
            DFS(loop, true);
            Arrays.fill(visited, false);
			
            visited[loop] = true;
            DFS(loop, false);
            Arrays.fill(visited, false);
            
			if(bigresult>=avg || smallresult>=avg) {
				ans++;
				continue;
			}			
		}
		
		System.out.println(ans);
		
	}

	static int bigresult;
	static int smallresult;
	static boolean[] visited;

	private static void DFS(int start, boolean chk) {
		// TODO Auto-generated method stub
		if(bigresult>=avg || smallresult>=avg) {
			return;
		}
		for (int col = 1; col < N+1; col++) {
			if(chk && map[start][col]) {
				if(visited[col]) continue;
				visited[col] = true;
				bigresult++;
				
				DFS(col, true);
			}
			else if(!chk && map[col][start]) {
				if(visited[col]) continue;
				visited[col] = true;
				smallresult++;
				DFS(col, false);
			}
		}
		return;
	}

	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}
}
