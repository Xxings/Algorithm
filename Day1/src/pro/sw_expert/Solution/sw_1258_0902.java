/*
 * 34,864 kb
메모리
186 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_1258_0902 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<Pair> ans = new ArrayList<Pair>();
		StringTokenizer st;
		boolean[][] map = new boolean[100][100]; // 최대크기 100;
		boolean[][] visited;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			ans.clear(); // 초기화

			int N = stoi(br.readLine());
			visited = new boolean[N][N]; // 채우는게 더 오래걸리겠다.
			for (int row = 0; row < N; row++) {
				int cnt = 0;
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < N; col++) {
					// 크기 판단은 필요없습니다.
					map[row][col] = (st.nextToken().equals("0")) ? false : true;
				}
			}
			// 초기화

			// blood fills;
			int nrow = 0;
			int ncol = 0;
			for (int row = 0; row < N; row++) {
				int stcol = 0;
				for (int col = 0; col < N; col++) {
					if (visited[row][col])
						continue;
					visited[row][col] = true;

					if (map[row][col]) {
						if(ncol==0) stcol = col;
						ncol++;
					}

					if (((!map[row][col]) || (col + 1 == N)) && ncol > 0) {
						for (int row2 = row; row2 < N; row2++) {
							for (int col2 = col-1; col2 >=stcol; col2--) {
								visited[row2][col2] = true;
							}
							if (map[row2][col - 1]) {
								nrow++;
							} else {
								ans.add(new Pair(nrow, ncol));
								break;
							}
						}
						nrow = 0;
						ncol = 0;
					}
				} // end of col
			}

			// 크기 작은순으로
			ans.sort((a,b)->{
					if(a.area() == b.area())
						return (a.row>b.row)?1:-1;
					else {
						return (a.area()>b.area())?1:-1;
					}
			});
			// 행이 작은 순으로
			sb.append("#").append(Tcase).append(" ").append(ans.size());
			for (int loop = 0; loop < ans.size(); loop++) {
				Pair data = ans.get(loop);
				sb.append(" ").append(data.row).append(" ").append(data.col);
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	private static class Pair {
		int row;
		int col;

		protected Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		protected int area() {
			return row*col;
		}
		
	}
}
