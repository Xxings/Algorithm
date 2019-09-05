package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_1213_0820 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = 0;
			br.readLine(); // Tcase : 버림
			char[] sytax = br.readLine().toCharArray();
			char[] input = br.readLine().toCharArray();
//			int sidx = sytax.length - 1;
			
			
			for (int iidx = input.length - 1; iidx >=0; iidx--) {
				boolean isOk = true;
				int iiidx = iidx;
				for (int sidx = sytax.length -1; sidx >= 0; sidx--) {
					if(input[iiidx--]!=sytax[sidx]) {
						isOk =false;
						break;
					}
				}
				if(isOk) ans++;
			}
			
			
			sb.append("#").append(Tcase).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);

	}
}
