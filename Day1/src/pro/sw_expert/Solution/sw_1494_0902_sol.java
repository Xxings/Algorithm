/*
25,312 kb
메모리
391 ms
실행시간
 * 
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_1494_0902_sol {
	static long ans;
	static int N;
	static List<Pair> lists;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		lists = new ArrayList<>();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			ans = Long.MAX_VALUE;
			lists.clear();
			N = stoi(br.readLine()); // 지렁이의 수 20개의 짝수
			for (int loop = 0; loop < N; loop++) {
				st = new StringTokenizer(br.readLine(), " ");
				int row = stoi(st.nextToken());
				int col = stoi(st.nextToken());
				lists.add(new Pair(row, col));
			}
			combi(0,0, 0, 0, 0);
//			System.out.println("sumX :\t"+sumX+"\tsumY :\t"+sumY);
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	static int cnt = 0;

	private static void combi(int st, int minus, int visited, int saveRow, int saveCol) {
		// TODO Auto-generated method stub
		if (minus == N/2) {
			// 순열종료
			for (int i = 0; i < N; i++) {
				if((visited & (1<<i))==0) {
					Pair data = lists.get(i);
					saveRow += data.row;
					saveCol += data.col;
				}
			}
			long result;
			result = (long) saveRow * saveRow;
			result += (long) saveCol * saveCol;
			if (ans > result) { // 벡터의 절대값의 크기비교 || Error |A|+|B|>|A'|+|B'| !=> |A^2| + |B^2| > |A'|^2+|B'|^2 
				ans = result;
			}
		} else {
			for (int i = st; i < N; i++) {
				if ((visited & (1 << i)) > 0)
					continue; // 이미 방문함
				Pair data = lists.get(i);
				combi(i, minus+1, visited | (1 << i), saveRow - data.row, saveCol - data.col);
			}
		} // end of perm
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static class Pair {
		int row;
		int col;

		protected Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}
}
