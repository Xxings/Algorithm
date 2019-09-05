package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class bk_10971_0821 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = stoi(br.readLine());
		int[][]map = new int[N][N];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int col = 0; col < args.length; col++) {
				map[row][col] = stoi(st.nextToken());
			}
		}
		int ans = 0;
			
		for (int bit = 0; bit < (1<<N); bit++) {
			for (int no = 0; no < N; no++) {
				if( (bit & (1<<no)) > 0) {
					
				}
			}
		}	
			
		
		System.out.print(ans);
	}
	
	private static int stoi(String readLine){
		return Integer.parseInt(readLine);
	}
}
