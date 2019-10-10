package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_6549_191008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			//line start
			st = new StringTokenizer(br.readLine()," ");
			int N = stoi(st.nextToken());
			if(N == 0)
				break;
			//algo Start
			int[][] dp = new int[N][2];
			
			
			
		
		}
		
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
