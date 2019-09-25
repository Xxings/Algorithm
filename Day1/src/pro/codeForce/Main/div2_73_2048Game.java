package pro.codeForce.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class div2_73_2048Game {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int cmp = (1 << 11);
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			boolean ans = false;

			int N = stoi(br.readLine());
			int data = 0;
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int target = stoi(st.nextToken());

				while ((data & target) > 0) {
					data ^= target;
					target = target << 1;
				}
				data ^= target;

				if ((data & cmp) > 0) {
					ans = true;
					break;
				}
			}
			sb.append((ans)?"YES":"NO").append("\n");
		}
		System.out.print(sb);
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
