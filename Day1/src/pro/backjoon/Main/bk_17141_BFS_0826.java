/**
 * 40892kb	216ms
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_17141_BFS_0826 {
	static int[][] map;
	static int[][] clonemap;
	static int N;
	static int M;
	static List<Pair> list;
	static int INF = Integer.MAX_VALUE;
	static int ans = INF;
	static int Sum;
	static int Zero = 0;
	static int One = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		Sum = N * N;

		map = new int[N][N];
		clonemap = new int[N][N];
		list = new ArrayList<Pair>();
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int col = 0; col < N; col++) {
				int data = stoi(st.nextToken());
				map[row][col] = data;
				if (data == 2) {
					map[row][col] = 0;
					list.add(new Pair(row, col));
				} else if (data == 1)
					One++; // 속도 향상

			}
		} // end of set
		condi(0, 0, 0);

		System.out.println((ans == INF) ? -1 : ans);

	}// end of list;

	//순열 조합 실수
	private static void condi(int cnt, int st, int visited) {
		// TODO Auto-generated method stub
		if (cnt == M) {
			bfs(visited);
		} else {
			for (int start = st; start < list.size(); start++) {
				if (start == list.size() - 1 && cnt != M - 1)
					return;
				condi(cnt + 1, start + 1, visited | (1 << start));
			}
		}
	}

	static int[] dirRow = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dirCol = { 0, 0, -1, 1 }; // 상하좌우

	private static void bfs(int visited) {
		// TODO Auto-generated method stub
		for (int row = 0; row < N; row++) {
			clonemap[row] = map[row].clone();	//여기가 시간초과의 문제점 | nCr * n;
		}
//		clonemap = new int[N][N];

		int result = 0;
		Queue<Pair> q1 = new LinkedList<>();

		Zero = 0;
		for (int i = 0; i < list.size(); i++) {
			if ((visited & (1 << i)) > 0) {
				Pair temp = list.get(i);
				clonemap[temp.row][temp.col] = 1;
				q1.add(temp);
			}
		}
		while (!q1.isEmpty()) {
			Pair cur = q1.poll();
			for (int dir = 0; dir < dirCol.length; dir++) {
				int goRow = cur.row + dirRow[dir];
				int goCol = cur.col + dirCol[dir];
				if (goRow < 0 || goCol < 0 || goRow > N - 1 || goCol > N - 1)
					continue;
				if (clonemap[goRow][goCol] != 0)
					continue;
				q1.add(new Pair(goRow, goCol));
				Zero++;
				result = clonemap[cur.row][cur.col] + 1; // 처음이 1로 세팅했으므로
				clonemap[goRow][goCol] = result;
			}
			if (result - 1 >= ans) // -1이 결국 결과값
				return;
		}
		if (Sum == One + Zero + M)
			ans = (result==0)? 0 : result - 1;
		//답이 0일때 조심
	}

	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}

	private static class Pair {
		int row;
		int col;

		protected Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}
}
