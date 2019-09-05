/*
 * 메모리 15292kb
 * 시간	96ms
 *  
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_15652_0902 {
	static final char LINE = '\n';
	static final char SPACE = ' ';
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[M];
		
		perm(0,1);
		System.out.println(sb);
	}
	private static void perm(int step, int start) {
		// TODO Auto-generated method stub
		if(step == M) {
			for (int idx = 0; idx < M; idx++) {
				sb.append(arr[idx]).append(SPACE);
			}
			sb.append(LINE);
		}
		else {
			for (int i = start; i <= N; i++) {
				arr[step] = i;
				perm(step+1,i);
			}
		}
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
