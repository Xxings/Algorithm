package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw_4366_0923_sol {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= TC; testCase++) {
			String sys2 = br.readLine(); // 2진수
			String sys3 = br.readLine(); // 3진수
			long result = -1;
			String temp;
			for (int i = 0; i < sys2.length(); i++) {
				int digit2 = sys2.charAt(i) - '0';
				temp = sys2.substring(0, i) + (1 - digit2) + sys2.substring(i + 1);
				long bNum = Long.valueOf(temp, 2);
				for (int j = 0; j < sys3.length(); j++) {
					int digit3 = sys3.charAt(j) - '0';
					for (int k = 0; k < 3; k++) {
						if (digit3 == k)
							continue;
						temp = sys3.substring(0, j) + k + sys3.substring(j + 1);
						long tNum = Long.valueOf(temp, 3);
						if (bNum == tNum) {
							result = tNum;
							break;
						}
					}
				}
			}

			sb.append('#').append(testCase).append(' ').append(result).append('\n');
		} // end of for testCase
		System.out.print(sb);
	} // end of main
} // end of class
