package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_17086 {
	
	static int ROW;
	static int COL;
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		ROW = Integer.parseInt(str[0]);
		COL = Integer.parseInt(str[1]);
		
		int[][] map = new int[ROW][COL];
		//bfs
		
		StringTokenizer st;
		for (int row = 0; row < ROW; row++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int col = 0; col < COL; col++) {
				map[row][col]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0,0,map, new boolean[100]);
//		int[][] chkmap = new int[ROW][];
//		for (int row = 0; row < ROW; row++) {
//			for (int col = 0; col < COL; col++) {
//				if(map[row][col] == 1) continue;
//				for(int i = 0; i < ROW; i++) {
//					chkmap[i] = map[i].clone();	
//				}
//				bfs(row,col,0,chkmap, new boolean[100]);
//			}
//		}
		System.out.println(ans);
	}
	static int[] dir_row = {-1,1,0,0,-1,-1,1,1};	//상하좌우 // 좌상 우상 좌하 우하 
	static int[] dir_col = {0,0,-1,1,-1,1,-1,1};	//상하좌우 // 좌상 우상 좌하 우하
	
	private static void bfs(int row, int col, int cnt, int map[][],boolean[] chk) {
		// TODO Auto-generated method stub
		if(chk[cnt] == true) return;
		for (int dir = 0; dir < 4; dir++) {	//상하좌우 방향 탐색
			int go_row = row+dir_row[dir];
			int go_col = col+dir_col[dir];
			//범위밖
			if(go_row<0 || go_row == ROW || go_col <0 || go_col == COL) continue;
			
			if(map[go_row][go_col]!=1) {	//상어가 아니면
				map[go_row][go_col]=1;
				bfs(go_row,go_col,cnt+1,map,chk);
			}
			else {
				int idx = 0;
				chk[cnt]=true;
				int result=0;
				while(!chk[idx]) {
					result = idx;
					idx++;
				}
				if(ans < result) {	//상어만나면
					ans = result;
				}
				return;
			}
		}
	}
}
