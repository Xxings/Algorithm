package pro.codeForce.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class div2_73_Knights {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				flag ^= true;
				if(flag) sb.append('W');
				else sb.append('B');
			}
			if((N&1)==0) flag ^= true;
			sb.append('\n');
		}

		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
