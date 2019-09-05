//190812 171-->1606
package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class jg_2298 {
	static int[][] map;
	static boolean[][] chkmap;
	static boolean[][] visited;
	static int N;
	static int ans;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 1;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		chkmap = new boolean[N][N];
		
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// 강수가 쏟아진다.
		// 전체 배열 -1
		// 물 잠기면 chkmap[] = true; //잠김표시
		// result가 전보다 작아지면 break;
		result = 1;
		while (result != 0) {
//			Tmap(map);
//			Tmap(chkmap);
			rain();
			visited = new boolean[N][N];
			result = 0;
			chkarea();
//			System.out.println(ans + "|" +result);
			// 종료조건
			if (ans < result) {
				ans = result;
			}
//			else if (ans > result) {
//				break;
//			}
		}
		System.out.println(ans);
	}// end of rain

	static int[] dir_row = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dir_col = { 0, 0, -1, 1 }; // 상하좌우

	private static void chkarea() {
		// TODO Auto-generated method stub
		// init
		
		// 순차탐색 = true면 패스 / 만약 영역근처에있으면 result올릴필요없겠지
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if(visited[row][col]||chkmap[row][col]) continue;	//이미 지나거나 잠수
				Queue<Pair> q = new LinkedList<Pair>();
				
				q.add(new Pair(row,col));
				visited[row][col] = true;
				
				while(!q.isEmpty()) {
					Pair p = q.poll();
					//상하좌우
					for (int dir = 0; dir < 4; dir++) {
						int goRow = p.row + dir_row[dir];
						int goCol = p.col + dir_col[dir];
						if(goRow <0 || goRow > N-1 || goCol < 0 || goCol > N-1) continue;
						else if(!visited[goRow][goCol]  && !chkmap[goRow][goCol]) {
							visited[goRow][goCol] = true;
							q.add(new Pair(goRow,goCol));
						}
					}
				}
				result+=1;
//				Tmap(visited);
			}
		}

	}

	private static void Tmap(boolean[][] chkmap2) {
		// TODO Auto-generated method stub
		for (int row = 0; row < chkmap2.length; row++) {
			System.out.println(Arrays.toString(chkmap2[row]));
		}
		System.out.println();
	}

	private static void Tmap(int[][] map2) {
		// TODO Auto-generated method stub
		for (int row = 0; row < map2.length; row++) {
			System.out.println(Arrays.toString(map2[row]));
		}
		System.out.println();
	}

	private static void rain() {
		// TODO Auto-generated method stub
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (chkmap[row][col])
					continue;
				else if ((map[row][col] -= 1) == 0) {	//1부터 높이있으니까 -는 안되겠네
					chkmap[row][col] = true; // 물에 잠김
				}
			}
		}
	} // end of rain
	static class Pair{
		int row;
		int col;
		protected Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
}
