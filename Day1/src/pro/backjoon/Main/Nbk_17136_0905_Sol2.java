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

//이유 row가 자꾸 5에서 끊김
public class Nbk_17136_0905_Sol2 {
	static final int MAX_N = 10;
	static final int INF = Integer.MAX_VALUE;
	static int ans = INF;
//	static boolean[][] map = new boolean[MAX_N][MAX_N];	//256ms
	static int[][] map = new int[MAX_N][MAX_N];
	static int[][] chkmap = new int[MAX_N][MAX_N];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for (int i = 0; i < MAX_N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < MAX_N; j++) {
				int data = stoi(st.nextToken());
//				map[i][j] = (st.nextToken().equals("1")) ? true : false; //256ms
				map[i][j] = data;	//252ms
				sum += data;
			}
		}

		int[] cnt = new int[] { 0, 5, 5, 5, 5, 5 };
		if(sum == 100)
			ans = 4;
		else
			dfs(0, 0, cnt, 0, sum); // (0,0)부터 시작

		if (ans == INF)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}

	private static void dfs(int row, int col, int[] cnt, int result, int sumtemp) {
		// TODO Auto-generated method stub
		// 1이라면, 5/4/3/2/1
		if (sumtemp == 0) {
			return;
		}
		if (result >= ans)
			return;
		if (row >= MAX_N) {
			System.out.println("====="+result);
			for (int i = 0; i < MAX_N; i++) {
				System.out.println(Arrays.toString(chkmap[i]));
			}
			if (result < ans) {
				ans = result;
			}
			return;
		} else if (col >= MAX_N) { // 한줄 다음으로 시작
			dfs(row + 1, 0, cnt, result, sumtemp);
		}
		// 주어진 좌표에서 되는지 확인
		else if (map[row][col] == 1 && chkmap[row][col] == 0) { // 채울 수 있는 공간이라면,
			int maxSize = 5;
			for (; maxSize > 0; maxSize--) { // n은 색종이의 크기 5,4,3,2,1
				if (cnt[maxSize] == 0) { // 이미 다사용됨
					continue;
				} 
				else if(success(row, col, maxSize)) {
					break;
				}
			}
			System.out.println("===="+row+","+col);
			for (int i = 0; i < MAX_N; i++) {
				System.out.println(Arrays.toString(chkmap[i]));
			}
			for (int size = maxSize; size > 0; size--) {
				if (cnt[maxSize] == 0) { // 이미 다사용됨
					continue;
				} 
				chkmap = mapping(row, col, size, size);
				cnt[size]--;
				dfs(row, col + size, cnt, result + 1, sumtemp-size*size);
				cnt[size]++;
				chkmap = mapping(row, col, size, 0);
			}
		} else {
			dfs(row, col + 1, cnt, result, sumtemp);
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
		if (row+n >= MAX_N || col+n >= MAX_N)
			return false;
		
		for (int x = row; x < row + n; x++) {
			for (int y = col; y < col + n; y++) {
				if (map[x][y]==0 || chkmap[x][y] != 0) { // 이미 채워진게있다면	//252ms
					return false;
				}
			}
		}
		return true;
	}

}
