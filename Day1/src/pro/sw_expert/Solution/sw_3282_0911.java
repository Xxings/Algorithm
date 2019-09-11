package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_3282_0911 {
	static StringTokenizer st;
	static int N;
	static int K;
	static int[][] data;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		data = new int[100][2];
		dp = new int[100][2];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = 0;
			sb.append("#").append(Tcase).append(" ");
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			K = stoi(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				data[i][0] = stoi(st.nextToken()); // V 부피
				data[i][1] = stoi(st.nextToken()); // C 가치
			}
			Arrays.sort(data, 0, N, (a, b) -> {
				if ((a[1] / a[0] == b[1] / b[0]))
					return (a[0] > a[1]) ? 1 : -1;
				else
					return (a[1] / a[0] > b[1] / b[0]) ? 1 : -1;
			});

			System.out.println(Arrays.toString(data[0]));
			System.out.println(Arrays.toString(data[1]));
			System.out.println(Arrays.toString(data[2]));
			System.out.println(Arrays.toString(data[3]));
			
			for (int i = 0; i < N; i++) {
				dp[i][0] = max
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
