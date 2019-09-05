/*
 * 21628KB -> 21124KB -> 21112kb
 * 240ms -> 256ms -> 252ms -> 264ms
 * 
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bk_17136_0905 {
	static final int MAX_N = 10;
	static final int INF = Integer.MAX_VALUE;
	static int ans = INF;
//	static boolean[][] map = new boolean[MAX_N][MAX_N];	//256ms
	static int[][] map = new int[MAX_N][MAX_N];
	static int[][] chkmap = new int[MAX_N][MAX_N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < MAX_N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < MAX_N; j++) {
//				map[i][j] = (st.nextToken().equals("1")) ? true : false; //256ms
				map[i][j] = stoi(st.nextToken());	//252ms
			}
		}

		int[] cnt = new int[] { 0, 5, 5, 5, 5, 5 };

		dfs(0, 0, cnt, 0); // (0,0)부터 시작

		if (ans == INF)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}

	private static void dfs(int row, int col, int[] cnt, int result) {
		// TODO Auto-generated method stub
		// 1이라면, 5/4/3/2/1
		if (result >= ans)
			return;
		if (row == MAX_N) {
			if (result < ans) {
				ans = result;
			}
			return;
		} else if (col == MAX_N) { // 한줄 다음으로 시작
			dfs(row + 1, 0, cnt, result);
		}
		// 주어진 좌표에서 되는지 확인
//		else if (map[row][col] && chkmap[row][col] == 0) { // 채울 수 있는 공간이라면,
		else if (map[row][col] == 1 && chkmap[row][col] == 0) { // 채울 수 있는 공간이라면,
			boolean isOk = false; // 속도 줄이기용
			for (int n = 5; n > 0; n--) { // n은 색종이의 크기 5,4,3,2,1
				if (cnt[n] == 0) { // 이미 다사용됨
					continue;
				} else if (isOk || success(row, col, n)) { // 큰거되면 다됨.
					isOk = true;
					// 완전탐색
					cnt[n]--;
					chkmap = mapping(row, col, n, n);
					dfs(row, col + n, cnt, result + 1);
					cnt[n]++;
					chkmap = mapping(row, col, n, 0);
				}
			}
		} else {
			dfs(row, col + 1, cnt, result);
		}
	}

	private static int[][] mapping(int row, int col, int n, int val) {
		// TODO Auto-generated method stub
		for (int x = row; x < row + n; x++) {
			Arrays.fill(chkmap[x], col, col + n, val);
		}
		return chkmap;
	}

	private static boolean success(int row, int col, int n) {
		// TODO Auto-generated method stub
		for (int x = row; x < row + n; x++) {
			for (int y = col; y < col + n; y++) {
				if (x == MAX_N)
					return false;
				else if (y == MAX_N)
					return false;
//				else if (!map[x][y] || chkmap[x][y] != 0) { // 이미 채워진게있다면	//256ms
				else if (map[x][y]==0 || chkmap[x][y] != 0) { // 이미 채워진게있다면	//252ms
					return false;
				}
			}
		}
		return true;
	}

}
