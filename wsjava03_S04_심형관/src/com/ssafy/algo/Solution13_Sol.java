package com.ssafy.algo;

import java.util.Scanner;

public class Solution13_Sol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = sc.nextInt();
			char[][] map = new char[n+2][n+2];	//0, n+1안씀
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = sc.next().charAt(0);		//너무 긴경우, buffer로 잘라서 넣는게 더 메모리 좋음
				}
			}
			
			int[] rows = {-1,0,1};	
			int[] cols = {-1,0,1};
			int hight = 0;
			int maxHight = 0;
			
			for (int row = 0; row < cols.length; row++) {
				for (int col = 0; col < cols.length; col++) {
						end : for(int x : rows) {
							for(int y : cols) {
								if(map[row+x][col+y]=='G') {
									hight = 2;
									break end;
								}
						}
					}// end for
				if (hight == 0){
					for (int i = 1; i<= n; i++) {
						if (map[row][i] == 'B') hight++;
						if (map[i][col] == 'B') hight++;
					}
					hight--;
					}
				}
				if(maxHight < hight) maxHight = hight;
			}
			
		}	
	}//end of main
}
