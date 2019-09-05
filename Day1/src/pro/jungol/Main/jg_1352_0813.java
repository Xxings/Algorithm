//190813 0950 - 1014
//8MB	97ms
package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class jg_1352_0813 {
	static List<Integer> input;
	static boolean[] memory;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		input = new ArrayList<>(); // 30개 인풋받음

		// 최대 15000
		memory = new boolean[15001]; // 500g * 300;
		int N = stoi(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			dp(stoi(st.nextToken()));
		}

		br.readLine(); // 버림
		st = new StringTokenizer(br.readLine());
		int max = 0; // 판단식?
		while (st.hasMoreTokens()) {
			// DP
			int data = stoi(st.nextToken());
			if(data > 15001) sb.append("N");
			else sb.append(memory[data]?"Y":"N");
			sb.append(" ");
		}
		System.out.println(sb);
	}

	private static void dp(int chk) {
		// TODO Auto-generated method stub
		memory[chk] = true;
		int cnt = input.size();
		for (int i = 0; i < cnt; i++) {
			int sub = Math.abs(input.get(i) - chk);
			int add = input.get(i) + chk;
			if(!memory[sub]) {
				input.add(sub);
				memory[sub] = true;
			}
			if(!memory[add]) {
				input.add(add);
				memory[add] = true;
			}
		}
		input.add(chk);
	}

	private static int stoi(String string) {
		// TODO Auto-generated method stub
		return Integer.parseInt(string);
	}
}
