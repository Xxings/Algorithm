/*
 * 	메모리16216	
 *  시간 136
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_4963_191007 {
	static int[][] map;
	static boolean[][] visited;
	static int W; // <=50
	static int H; // <=50
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			W = stoi(st.nextToken());
			H = stoi(st.nextToken());
			if(W==0 && H==0) break;
			map = new int[H + 2][W + 2]; // 0과 N+1 안씀
			for (int row = 1; row <= H; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 1; col <= W; col++) {
					map[row][col] = stoi(st.nextToken());
				}
			}
			visited = new boolean[H + 2][W + 2];
			// bfs로
			int curR = 1; // ->H
			int curC = 1; // ->W

			// 가로부터 탐색
			while (curR != H || curC != W) {
				if (curC > W) {
					curR++;
					curC = 1;
					continue;
				} // 가로 넘을때
				if (visited[curR][curC]) {
					curC++;
					continue;
				} // 이미 했을때
				visited[curR][curC] = true;
				if (map[curR][curC] == 1) {
					q.add(new int[] { curR, curC });
					ans++;
					while (!q.isEmpty()) {
						int[] pair = q.poll();
						for (int dir = 0; dir < dR.length; dir++) {
							int goR = pair[0] + dR[dir];
							int goC = pair[1] + dC[dir];
							if (goR < 1 || goR > H || goC < 1 || goC > W)
								continue;
							if (visited[goR][goC])
								continue;
							visited[goR][goC] = true;
							if (map[goR][goC] == 1)
								q.add(new int[] { goR, goC });
						}
					}
				}
//				Tmap(visited);

				curC++;
			} // end of while
			if (!visited[curR][curC] && map[curR][curC] == 1) {
				visited[curR][curC] = true;
				ans++;
			}
//			Tmap(visited);
			sb.append(ans+"\n");
		}//end of 문제반복
		System.out.print(sb);
	}

	private static void Tmap(boolean[][] visited2) {
		// TODO Auto-generated method stub
		System.out.println("=====");
		for (int i = 0; i < visited2.length; i++) {
			System.out.println(Arrays.toString(visited2[i]));
		}
	}

	static int[] dR = new int[] { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우/좌상/좌하/우상/우하
	static int[] dC = new int[] { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상하좌우/좌상/좌하/우상/우하
	static Queue<int[]> q = new LinkedList<int[]>();

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
