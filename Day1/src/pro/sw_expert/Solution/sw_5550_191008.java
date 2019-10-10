package pro.sw_expert.Solution;
/*
19,128 kb
메모리
276 ms
실행시간
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
  
public class sw_5550_191008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] count = new int[26]; // c,r,o,a,k
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			boolean flag = true;
			Arrays.fill(count, 0);
			sb.append("#").append(Tcase).append(" ");
			char[] input = br.readLine().toCharArray();
			int ans = 0;
			for (char val : input) {
				int idx = val - 'a';
				switch (val) {
				case 'k':
					if(ans < count['c'-'a']-count[idx]) {
						ans = count['c'-'a']-count[idx];
					}
					if (count['a' - 'a'] < count[idx]+1) {
						flag=false;						
						break;
					}
				case 'a':
					if (count['o' - 'a'] < count[idx]+1) {
						flag=false;
						break;
					}
				case 'o':
					if (count['r' - 'a'] < count[idx]+1) {
						flag=false;
						break;
					}
				case 'r':
					if (count['c' - 'a'] < count[idx]+1) {
						flag=false;
						break;
					}
				case 'c':
					count[idx]++;
					break;
				default:
					flag=false;
					break;
				} // end of switch;
				if(!flag) {
					break;
				}
			} //end of input
			if(flag) {	//입력에 문제가 없었다면
				int val = count['c'-'a'];
					 if(val!=count['r'-'a']) flag=false;
				else if(val!=count['o'-'a']) flag=false;
				else if(val!=count['c'-'a']) flag=false;
				else if(val!=count['k'-'a']) flag=false;
			}
			
			if(!flag) ans=-1;
			sb.append(ans).append("\n");
		} // end of TC
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
