/**
 * 메모리 113032 kb
 * 시간 312ms
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_15651_0902 {
	static final char NEWLINE = '\n';
	static final char SPACE = ' ';
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int C;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		C = stoi(st.nextToken());
		arr = new int[C];
		
		
		perm(0);
		
		System.out.print(sb);
		
	}
	private static void perm(int step) {
		// TODO Auto-generated method stub
		if(step == C) {
			for (int idx = 0; idx < C; idx++) {
				sb.append(arr[idx]).append(SPACE);
			}
			sb.append(NEWLINE);
		}
		
		else {
			for (int idx = 1; idx <= N; idx++) {
				arr[step]=idx;
				perm(step+1);
			}
		}
	}
	
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
