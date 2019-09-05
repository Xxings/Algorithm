/**
 * 92012kb -> 20908kb
 * 1440ms -> 144ms
 * (Stringbuilder 차이)
 */

package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_15649_0902 {
	static int N;
	static int C;
	static int[] arr;
	
	private static final char LINE = '\n';
	private static final char SPACE = ' ';
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken());
		C = stoi(st.nextToken());
		arr = new int[C];
		combi(0,0);
		System.out.println(sb);
	}
	private static void combi(int count, int visited) {
		// TODO Auto-generated method stub
		if(count == C) {
			for (int i = 0; i < C; i++) {
				sb.append(arr[i]).append(SPACE);
			}
			sb.append(LINE);
		}
		else {
			for (int i = 1; i <=N; i++) {
				if((visited&(1<<i))>0) continue;
				arr[count]=i;
				combi(count+1,visited|(1<<i));
			}
		}
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
