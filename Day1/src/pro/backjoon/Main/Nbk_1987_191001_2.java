package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리13644	시간 996ms	
// 불가능 : 1. 최장거리 2. 이전경로를 가져올수없음
public class Nbk_1987_191001_2 {
	static char[][] map;
	static int R;
	static int C;
	static boolean[] alpaVisited = new boolean[26]; // 'A'~'Z'
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = stoi(st.nextToken());
		C = stoi(st.nextToken());

		map = new char[R][C];
		memory = new int[R][C];
		for (int row = 0; row < R; row++) {
			map[row] = br.readLine().toCharArray();
			Arrays.fill(memory[row], -1); // -1로 초기화
		}
		// DFS->DP
		// DP로 풀어보자
		dp(0, 0, (1 << (map[0][0] - 'A')));
		System.out.print(memory[0][0]);
		Tmap(memory);
	}

	private static void Tmap(int[][] dp2) {
		// TODO Auto-generated method stub
		System.out.println("=====");
		for (int i = 0; i < dp2.length; i++) {
			System.out.println(Arrays.toString(dp2[i]));
		}
	}

	static final int[] dirR = new int[] { -1, 1, 0, 0 };
	static final int[] dirC = new int[] { 0, 0, -1, 1 };
	static int[][] memory;

	private static int dp(int r, int c, int visited) {
//		if(memory[r][c] != -1) return memory[r][c];
		int cnt = 0;
		for (int dir = 0; dir < 4; dir++) {
			int goR = r + dirR[dir];
			int goC = c + dirC[dir];
			if (goR < 0 || goR > R - 1 || goC < 0 || goC > C - 1)
				continue;
			int alpabet = map[goR][goC] - 'A';
			if ((visited & (1 << alpabet)) > 0)
				continue; // 이미 방문함
			int data = dp(goR, goC, visited | (1 << alpabet));
			if (cnt < data) {
				cnt = data;
			}
		}

		return memory[r][c]=cnt+1;
//				= (memory[r][c]<(cnt + 1))?cnt+1:memory[r][c];
	}

	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}
}
