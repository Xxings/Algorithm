package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	메모리13644	시간 996ms -> 780ms -> 764ms	
public class bk_1987_191001 {
	static char[][] map;
	static int R;
	static int C;
	static boolean[] alpaVisited = new boolean[26];	//'A'~'Z'
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		
		map = new char[R][C];
		
		for (int row = 0; row < R; row++) {
			map[row] = br.readLine().toCharArray();
		}
		
		//단순 DFS
		ans=0;
		dfs(0,0,1,(1 << (map[0][0] - 'A')));
		
		System.out.print(ans);
		
	}
	static final int[] dirR = new int[] { -1, 1, 0, 0 };
	static final int[] dirC = new int[] { 0, 0, -1, 1 };
	
	private static void dfs(int r, int c, int cnt,int visited) {
		if(ans == 26)	//알파벳최대 26개
			return;
		if(cnt>ans) {
			ans = cnt;
		}
		for (int dir = 0; dir < 4; dir++) {
			int goRow = r + dirR[dir];
			int goCol = c + dirC[dir];
			if (goRow < 0 || goRow > R - 1 || goCol < 0 || goCol > C - 1)
				continue;
			int alpabet = map[goRow][goCol]-'A';
			if ((visited & (1 << alpabet)) > 0) continue; // 이미 방문함
			dfs(goRow, goCol, cnt+1, visited | (1 << alpabet));
		}
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
