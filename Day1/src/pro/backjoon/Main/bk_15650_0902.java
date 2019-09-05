/* 메모리
 * 12948kb	
 * 시간
 * 76ms
 * 
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_15650_0902 {
	static int[] arr;
	static final char SPACE = ' ';
	static final char NEWLINE = '\n';
	static int N;
	static int C;
	static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		N = stoi(st.nextToken());
		C = stoi(st.nextToken());
		arr = new int[C];
		perm(0,1);
		
		System.out.println(sb);
		
		
		
	}
	private static void perm(int step, int start) {
		// TODO Auto-generated method stub
		if(step == C) {
			for (int i = 0; i < C; i++) {
				sb.append(arr[i]).append(SPACE);
			}
			sb.append(NEWLINE);
		}
		else {
			for (int i = start; i <= N; i++) {
				arr[step] = i;
				perm(step+1,i+1);
			}
		}
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
