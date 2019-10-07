/*
91,460 kb
메모리
1,174 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_5643_191007 {
	static int N;
	static boolean map[][] = new boolean[501][501];
	static int memory[][] = new int[501][2]; // 0은 p, 1은 c 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine().trim()); // 15
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int p;
		int c;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = 0;
			N = stoi(br.readLine().trim()); // 500
			int M = stoi(br.readLine().trim()); // 500*(499)/2

			// 일단 다 해보기
			for (int row = 1; row <= N; row++) {
				Arrays.fill(map[row], 1, N + 1, false); // 초기화(0은 안씀)
				Arrays.fill(memory[row], -1);
			}
			for (int loop = 0; loop < M; loop++) {
				st = new StringTokenizer(br.readLine());
				p = stoi(st.nextToken());
				c = stoi(st.nextToken());
				map[p][c] = true;
			} // end of input
			for (int idx = 1; idx <= N; idx++) {
				pdfs(idx, idx, 0, new boolean[N + 1]);
				cdfs(idx, idx, 0, new boolean[N + 1]);
				if(1+memory[idx][0]+memory[idx][1] == N) ans++;
			}

//			Tmap(map);
//			Tmap(memory);

			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	private static void Tmap(int[][] memory2) {
		// TODO Auto-generated method stub
		System.out.println("----memory");
		for (int i = 1; i < memory2.length; i++) {
			System.out.println(i + " : " + Arrays.toString(memory2[i]));
		}
	}

	private static void Tmap(boolean[][] map2) {
		// TODO Auto-generated method stub
		System.out.println("----map");
		for (int i = 1; i < map2.length; i++) {
			System.out.println(Arrays.toString(map2[i]));
		}
	}

	private static int pdfs(int start, int go, int count, boolean[] visited) {
		int result = 0;
		if (memory[start][0] >= 0)
			return memory[start][0];

		// dfs - 단방향
		for (int col = 1; col <= N; col++) {
			if (!visited[col] && map[go][col]) { // 연결되어있다면
				visited[col] = true;
				result += pdfs(start, col, count + 1, visited);
			}
		}
		memory[go][0] = result;
		return memory[go][0] + 1;
	}
	
	private static int cdfs(int start, int go, int count, boolean[] visited) {
		int result = 0;
		if (memory[start][1] >= 0)
			return memory[start][1];

		// dfs - 단방향
		for (int col = 1; col <= N; col++) {
			if (!visited[col] && map[col][go]) { // 연결되어있다면
				visited[col] = true;
				result += cdfs(start, col, count + 1, visited);
			}
		}
		memory[go][1] = result;
		return memory[go][1] + 1;
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
