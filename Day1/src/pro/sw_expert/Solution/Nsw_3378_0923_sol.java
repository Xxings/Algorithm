package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nsw_3378_0923_sol {
	private static int[][] m;
	private static int[][] dap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // p 스타일리쉬를 마스터한 사람의 코드 줄 수 (1 ≤ p, q ≤ 10)
			int q = Integer.parseInt(st.nextToken()); // q 당신 코드의 줄 수 (1 ≤ p, q ≤ 10)

			m = new int[p][4]; // 위에부터 누적한 괄호의 개수 [0]., [1]소, [2]중, [3]대
			for (int i = 0; i < p; i++) {
				String line = br.readLine();
				int index = 0;
				while (line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index; // .의 개수
				if (i > 0) {
					m[i][1] = m[i - 1][1];
					m[i][2] = m[i - 1][2];
					m[i][3] = m[i - 1][3];
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(':
						m[i][1]++;
						break;
					case ')':
						m[i][1]--;
						break;
					case '{':
						m[i][2]++;
						break;
					case '}':
						m[i][2]--;
						break;
					case '[':
						m[i][3]++;
						break;
					case ']':
						m[i][3]--;
						break;
					}
				}
			}

			dap = new int[q][4]; // 위에부터 누적한 괄호의 개수 [0]., [1]소, [2]중, [3]대
			for (int i = 0; i < q; i++) {
				String line = br.readLine();
				int index = 0;
				if (i > 0) {
					dap[i][1] = dap[i - 1][1];
					dap[i][2] = dap[i - 1][2];
					dap[i][3] = dap[i - 1][3];
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(':
						dap[i][1]++;
						break;
					case ')':
						dap[i][1]--;
						break;
					case '{':
						dap[i][2]++;
						break;
					case '}':
						dap[i][2]--;
						break;
					case '[':
						dap[i][3]++;
						break;
					case ']':
						dap[i][3]--;
						break;
					}
				}
			}

			for (int i = 0; i < q; i++) {
				dap[i][0] = -2; // 초기값
			}
			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if (check(R, C, S)) {
							cal(R, C, S);
						}
					}
				}
			}

			sb.append('#').append(testCase).append(" 0");
			for (int i = 1; i < dap.length; i++) {
				sb.append(' ').append(dap[i][0]);
			}
			sb.append('\n');
		} // end of for testCase
		System.out.print(sb);
	} // end of main

	/** 내 코드에서 R, C, S 값을 구하기 */
	public static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i - 1][1] * R + dap[i - 1][2] * C + dap[i - 1][3] * S;
			if (dap[i][0] == -2) { // 답을 구한적이 없으면
				dap[i][0] = dap[i - 1][1] * R + dap[i - 1][2] * C + dap[i - 1][3] * S;
			} else if (dap[i][0] == -1) { // 답이 여러개 있다면,

			} else if (dap[i][0] != x) { // 답은 구했는데, 기존 구한 답과 다르면
				dap[i][0] = -1;
			}
		}
	}

	/** 스타일리쉬를 마스터 코드에서 R, C, S 값이 맞는지 체크 */
	public static boolean check(int R, int C, int S) {
		for (int i = 1; i < m.length; i++) {
			if (m[i][0] != m[i - 1][1] * R + m[i - 1][2] * C + m[i - 1][3] * S) {
				return false;
			}
		}
		return true;
	}
} // end of class
