package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_5432_0729 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			
			int result = 0;
			String str = br.readLine();
			char[] input = str.toCharArray();
			char[] stack = new char[100_000];
			int idxTop = -1;
			int cnt = 0;
			boolean lazor = false;
			for(char data : input) {
				
				switch(data) {
				case '(':
					stack[++idxTop] = data;
					cnt++;
					lazor = true;
					break;
					
				case ')':
					cnt--;
					if(idxTop>=0 && stack[idxTop] == '(' && lazor) {	//레이저 빔
						result += cnt;	
						lazor = false;
					}
					else {	//낫 레이저 빔
						result += 1;
					}
					idxTop--;
					break;
					default :
						
				}
				
			}
			System.out.printf("#%d %d\n", Tcase, result);
		}
	}
}
