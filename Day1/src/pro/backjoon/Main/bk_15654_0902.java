/**
 * 메모리 31208kb
 * 시간 220ms
 * 
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bk_15654_0902 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] datas;
	static int[] arr;
	static final char SPACE = ' ';
	static final char NEWLINE = '\n';
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		datas = new int[N];
		M = stoi(st.nextToken());
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			datas[i] = stoi(st.nextToken());
		}
		
		Arrays.sort(datas);
		condi(0,0);
		
		System.out.print(sb);
		
	}
	private static void condi(int step, int visited) {
		// TODO Auto-generated method stub
		if(step == M) {
			for (int idx = 0; idx < M; idx++) {
				sb.append(arr[idx]).append(SPACE);
			}
			sb.append(NEWLINE);
		}
		
		else {
			for (int idx = 0; idx < N; idx++) {
				if((visited&(1<<idx))>0) continue;
				arr[step] = datas[idx];
				condi(step+1, visited|(1<<idx));
			} // end of for
			
		}
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
