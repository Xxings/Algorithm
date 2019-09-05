// DFS
// 47,564 kb 메모리
// 402 ms 실행시간 
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class sw_1244_0814_sol2 {
	static char[] number;
	static int result = 0;
//	static boolean[][] visited;
	static ArrayList<String> st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			sb.append("#").append(Tcase).append(" ");

			String[] input = br.readLine().split(" ");
			number = input[0].toCharArray();
			int nchange = stoi(input[1]);

//			visited = new boolean[1_000_000][nchange+1];
			st = new ArrayList<>();
			result = toInt();
			// 완탐
			dfs(0, nchange, 0);

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int start, int nchange, int max) {
		// TODO Auto-generated method stub
//		if(visited[toInt()][nchange]) return;
//		else visited[toInt()][nchange]=true;

		if (st.contains(nchange + "," + toInt()))
			return;
		st.add(nchange + "," + toInt());
		if (nchange == 0) {
			result = Math.max(result, toInt());
		}

		else {
			for (int idx = start; idx < number.length; idx++) {
				for (int cmp = idx + 1; cmp < number.length; cmp++) {
					if (number[idx] <= number[cmp]) {	//최적화
						swap(idx, cmp);
						dfs(idx, nchange - 1, max);
						swap(idx, cmp);
					}
				}
			}
		}

	}

	private static int toInt() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < number.length; i++) {
			str += number[i];
		}
		return stoi(str);
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub

		char temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}

	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}

}
