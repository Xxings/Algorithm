package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_1218_0729 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// () 0 [] 1 {} 2 <> 3
		
		int T = 10;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			
			int[] check = new int[4];
			int idxTop = -1;
			char[] input = br.readLine().toCharArray();
			out:for(char data : input) {
				switch(data) {
				case '(':
					check[0]++;
					break;
				case ')':
					check[0]--;
					if(check[0] <0)
						break out;
					break;
				case '[':
					check[1]++;
					break;
				case ']':
					check[1]--;
					if(check[1] <0)
						break out;
					break;
				case '{':
					check[2]++;
					break;
				case '}':
					check[2]--;
					if(check[2] <0)
						break out;
					break;
				case '<':
					check[3]++;
					break;
				case '>':
					check[3]--;
					if(check[3] <0)
						break out;
					break;
				}
			}
			result =1;
			for (int data : check) {
				if(data != 0 ) {
					result = 0;
					break;
				}
					
			}
			
			System.out.printf("#%d %d \n", Tcase, result);
		}
	}
}
