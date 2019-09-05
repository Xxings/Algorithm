package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sw_2805 {
	static char[][] map;
	static int ROW;
	static int COL;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int N = Integer.valueOf(br.readLine());
			ans = 0;
			map = new char[N][N];
			ROW = N;
			COL = N;
			
			for (int row = 0; row < ROW; row++) {
				map[row] = (br.readLine().toCharArray()).clone();
			}
			
			bfs(N/2,N/2);
			sb.append("#");
			sb.append(Tcase);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
	static int[] dir_row = {-1,1,0,0};//상,하,좌,우
	static int[] dir_col = {0,0,-1,1};//상,하,좌,우
	static int ans;
	static int goRow;
	static int goCol;
	private static void bfs(int row, int col) {
		// TODO Auto-generated method stub
		Queue<String> q = new LinkedList<String>();
		boolean[][] chk = new boolean[ROW][COL];
		ans += map[row][col]-'0';	//첫 중앙
		chk[row][col] = true;
		q.add(row+","+col);
		
		end:while(!q.isEmpty()) {
			String[] temp = q.poll().split(",");
			for (int dir = 0; dir < 4; dir++) {
				goRow = Integer.parseInt(temp[0])+dir_row[dir];
				goCol = Integer.parseInt(temp[1])+dir_col[dir];
				if(goRow<0 || goRow==ROW || goCol<0 || goCol==COL) break end;	//종료
				if(chk[goRow][goCol]) continue;
				
				ans += map[goRow][goCol]-'0';	//++
				chk[goRow][goCol] = true;	//++
				q.add(goRow+","+goCol);
			}//end for
		}
	}
}
