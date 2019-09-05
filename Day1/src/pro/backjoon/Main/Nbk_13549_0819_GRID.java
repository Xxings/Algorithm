//BIT COMPUTE FAIL
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nbk_13549_0819_GRID {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());

		int left = 0;
		int right = 0;
		int right_ans = 0;
		int left_ans = 0;

		if (N == K) {
			System.out.println(0);
			return;
		}

		if (N == 0) { // 비트연산불가능
			N += 1;
			left_ans += 1;
			right_ans += 1;
		}

		if (N < K) { // N<K
			while ((N << 1) < K) {
				N = (N << 1);
			}
			right = (N << 1) - K;
			left = K - N;
			int temp = 1;
			if (right != 0) {
				right = right >> 1;
				right_ans++;
				while (right != 0) {
					right_ans += temp;
					right = right >> 1;
					temp = temp << 1;
				}
			}
			temp = 1;
			if (left != 0) {
				left = left >> 1;
				left_ans++;

				while (left != 0) {
					left_ans += temp;
					left = left >> 1;
					temp = temp << 1;
				}
			}

		} else if (N > K) { // N>K
			right_ans = N - K;
			left_ans = N - K;
		}

		System.out.println((right_ans < left_ans) ? right_ans : left_ans);

	}

	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}
}
