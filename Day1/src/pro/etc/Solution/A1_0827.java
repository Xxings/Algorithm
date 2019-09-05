package pro.etc.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* 
 * Shuffle-O-Matic 
 * */
public class A1_0827 {
	static int N;
	static int ans;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			ans = INF;
			sb.append("#").append(Tcase).append(" ");

			N = stoi(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] input = new int[N];
			int cnt = -1;
			while (st.hasMoreTokens()) {
				input[++cnt] = stoi(st.nextToken());
			}

			if (isSorted(input)) {
				ans = 0;
			} else {
				// 정렬 판단
				// bfs -> 정렬판단
				dfs(0, input.clone());
			}
			if(ans==INF)	ans = -1;
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	/**
	 * 
	 * @param count 횟수
	 * @param start
	 * @param input
	 */
	private static void dfs(int count, int[] input) {
		// TODO Auto-generated method stub
		if (count > ans) { // 가지치기
			return;
		} else if (count > 5) { // 종료조건
			return;
		} else if (isSorted(input)) {
			ans = count;
			return;
		}

		for (int x = 1; x < input.length; x++) { // 0은 소용이 없음
			dfs(count + 1, suffle(x, input));
		}

	}

	private static boolean isSorted(int[] input) {
		// TODO Auto-generated method stub

		for (int i = 1; i < N; i++) {
			if (Math.abs(input[i] - input[i - 1]) != 1)
				return false;
		}
		return true;
	}

	private static int[] suffle(int n, int[] input) {
		int divide = N / 2; // 짝수이므로
		int[] result = new int[N];

		int left_idx = -1;
		int right_idx = divide - 1;

		int type = n;

		if (type > divide - 1) {
			left_idx = divide - 1;
			right_idx = -1;
			type = N - 1 - n;
		}

		int cnt = -1;
		for (int i = 0; i < divide - type; i++) {
			result[++cnt] = input[++left_idx];
		}

		for (int i = 0; i < type; i++) {
			result[++cnt] = input[++right_idx];
			result[++cnt] = input[++left_idx];
		}
		
		for (int i = 0; i < divide - type; i++) {
			result[++cnt] = input[++right_idx];
		}
		
		return result;
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
