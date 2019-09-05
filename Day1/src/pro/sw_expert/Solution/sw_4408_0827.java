/*
 * 26,596 kb 메모리
	115 ms 실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_4408_0827 {
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = 1;
			visited = new int[201];
			sb.append("#").append(Tcase).append(" ");

			int N = stoi(br.readLine().trim());

			for (int loop = 0; loop < N; loop++) {
				st = new StringTokenizer(br.readLine(), " ");
				int stroom = ((stoi(st.nextToken()) + 1) / 2);
				int endroom = ((stoi(st.nextToken()) + 1) / 2);
				if (stroom > endroom) {
					int temp = stroom;
					stroom = endroom;
					endroom = temp;
				}

				for (int i = stroom; i <= endroom; i++) {
					visited[i]++;
				}

				for (int i = 0; i < visited.length; i++) {
					if (ans < visited[i])
						ans = visited[i];
				}
			}

			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
