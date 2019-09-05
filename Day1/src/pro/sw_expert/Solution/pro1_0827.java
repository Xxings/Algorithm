package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro1_0827 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = 0;
			sb.append("#").append(Tcase).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			int[][] map = new int[N][M];
			int[] count = new int[11];
			int K = stoi(st.nextToken());
			boolean flag;
			for (int loop = 0; loop < K; loop++) {
				flag = true;
				st = new StringTokenizer(br.readLine(), " ");
				int stRow = stoi(st.nextToken());
				int stCol = stoi(st.nextToken());
				int edRow = stoi(st.nextToken());
				int edCol = stoi(st.nextToken());
				int value = stoi(st.nextToken()); // 명도

				for (int row = stRow; row <= edRow; row++) {
					for (int col = stCol; col <= edCol; col++) {
						if (value < map[row][col])
							flag = false;
					}
				}	// end of search
				if (flag) {
					for (int row = stRow; row <= edRow; row++) {
						for (int col = stCol; col <= edCol; col++) {
							map[row][col] = value;
						}
					}
				}
			} // end of fills map;

			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					count[map[row][col]]++;
				}
			}

			for (int idx = 0; idx < 11; idx++) {
				if (ans < count[idx])
					ans = count[idx];
			}

			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
