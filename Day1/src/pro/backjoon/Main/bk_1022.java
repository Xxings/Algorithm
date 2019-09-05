package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bk_1022 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int r1 = -3;
		int c1 = -3;
		int r2 = 2;
		int c2 = 0;
		int N_rows = Math.abs(r2-r1)+1;
		int N_cols = Math.abs(c2-c1)+1;
		
		int[][] map = new int [N_rows][N_cols];

		//대각 계차수열
		int[] dia1 = new int[N_rows];
		dia1[0] = 4;
		int[] dia2 = new int[N_rows];
		dia2[0] = 2;
		int[] dia3 = new int[N_rows];
		dia3[0] = 8;
		int[] dia4 = new int[N_rows];
		dia4[0] = 6;
		
		for (int i = 1; i < dia4.length; i++) {
			dia1[1] = 
		}
		
//		int no = 1;
//		int cnt = 1;
//		
//		while(cnt != N_rows*N_cols) {
//			if(false) {
//				cnt++;
//			}
//			
//			no++;
//		}
		
	}
}
