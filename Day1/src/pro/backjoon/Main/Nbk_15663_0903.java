package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Nbk_15663_0903 {
	static StringBuilder sb = new StringBuilder();
	static final char SPACE = ' ';
	static final char NEWLINE = '\n';
	static int N;
	static int M;
	static int[] arr;
	static int[] condi;
	static boolean[] visited = new boolean[10001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N= stoi(st.nextToken());
		M= stoi(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i]=stoi(st.nextToken());
		}
		condi = new int[M];
		Arrays.sort(arr);
		dfs(0,0);
		
//		sets.stream().forEach((str)->System.out.println(str.replace("[", "").replace(",", "").replace("]", "")));
		System.out.println(sb);
	}
//	static Set<String> sets = new TreeSet<>();
	private static void dfs(int step, int visited) {
		// TODO Auto-generated method stub
		if(step == M) {
			for (int i = 0; i < M; i++) {
				sb.append(condi[i]).append(SPACE);
			}
			sb.append(NEWLINE);
		}
		else {
			for (int i = 0; i < N; i++) {
				if((visited &(1<<i))>0) continue;
				condi[step] = arr[i];
				dfs(step+1, visited | (1<<i));
			}
		}
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
