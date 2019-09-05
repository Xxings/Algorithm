//22MB	1438ms => 21MB 597ms
package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jg_1809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int N = 5;
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int [N];
		int[] ans = new int [N];
//		String[] input = {"6", "9", "5", "7", "4"};
		String[] input = br.readLine().split(" ");
//		StringTokenizer st = new StringTokenizer(br.readLine);
		
		
		StringBuilder sb = new StringBuilder();
		int idxTop = -1;
		int cmp;
		for(int idx = 0; idx < input.length; idx++) {	//push
			cmp = Integer.parseInt(input[idx]);
			//stack empty - push
			if(idxTop == -1) {	
				stack[++idxTop] = cmp;
				ans[idxTop] = idx+1;		//result
			}
			else if(stack[idxTop]<=cmp) {
				while(stack[idxTop] <= cmp) {
					idxTop--;
					if(idxTop == -1)		//stack empty
						break;
				}
				stack[++idxTop] = cmp;
				ans[idxTop] = idx+1;
			}
			else {	//작다
				stack[++idxTop] = cmp;
				ans[idxTop] = idx+1;
			}
			
			if(idxTop == 0)
				sb.append(0);
			else {
				sb.append(ans[idxTop-1]);
			}
			sb.append(" ");
		}		
		System.out.println(sb);
	}
}
