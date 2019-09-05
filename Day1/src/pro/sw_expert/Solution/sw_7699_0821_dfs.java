/*
20,540 kb -> 20004kb
메모리
2,124 ms -> 134ms
실행시간
 * 
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_7699_0821_dfs {
	static int[][] map;
	static int ROW;
	static int COL;
	static int dir_row[] = new int[] { -1, 1, 0, 0 }; // 상하좌우
	static int dir_col[] = new int[] { 0, 0, -1, 1 };
	static int ans;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = stoi(br.readLine());
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			ans = 0;
			st = new StringTokenizer(br.readLine()," ");
			ROW = stoi(st.nextToken());
			COL = stoi(st.nextToken());
			map = new int[ROW][COL];

			for (int row = 0; row < ROW; row++) {
				String data = br.readLine();
				for (int col = 0; col < COL; col++) {
					map[row][col] = data.charAt(col)-'A';
				}
			}
			/////////// 입력부 완료
			int visited = 0 | (1 << (map[0][0]));
			dfs(0, 0, visited, 1);

			sb.append("#").append(Tcase).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);

	}

	

	private static void dfs(int row, int col, int visited, int result) {
		if(ans == 26)	//134ms
			return;
		if(ans<result)
			ans =result;
		
		//상하좌우
		if(0 <= row-1 && (visited & (1<<map[row-1][col]))==0)
			dfs(row-1,col,visited|(1<<map[row-1][col]),result+1);
		
		if(row+1<ROW && (visited & (1<<map[row+1][col]))==0)
			dfs(row+1,col,visited|(1<<map[row+1][col]),result+1);
		
		if(0 <= col-1 && (visited & (1<<map[row][col-1]))==0)
			dfs(row,col-1,visited|(1<<map[row][col-1]),result+1);
		
		if(col+1<COL && (visited & (1<<map[row][col+1]))==0)
			dfs(row,col+1,visited|(1<<map[row][col+1]),result+1);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
}
