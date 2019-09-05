//시작 4:40분
package com.ssafy.algo;

import java.util.Scanner;

public class Solution42 {
	
	static final int DIR_UP = 1;
	static final int DIR_RIGHT = 2;
	static final int DIR_DOWN = 3;
	static final int DIR_LEFT = 4;
	
	static final int JUMPER = 11;
	static final int OUT = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map;				//맵
		int[] move_d, move_s;		//이동지시 (방향/움직임)
		int T = sc.nextInt();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int result_row=0, result_col=0;
			
			int N = sc.nextInt();	//배열크기
			int st_row = sc.nextInt();
			int st_col = sc.nextInt();
			int jumpcnt = sc.nextInt(); //점퍼 갯수
			
			map = new int[N+1][N+1]; //좌표 0 시작
			for (int loop = 0; loop < jumpcnt; loop++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				map[row][col] = JUMPER;
			}
			
			int dircnt =sc.nextInt();
			move_d = new int[dircnt];
			move_s = new int[dircnt];
			
			for (int loop = 0; loop < dircnt; loop++) {
				move_d[loop] = sc.nextInt();
				move_s[loop] = sc.nextInt();
			}
			
			boolean out_flag = false;	//나가는 플래그
			
			
			int curX = st_row;
			int curY = st_col;
			
			for (int loop = 0; loop < dircnt; loop++) {
				switch(move_d[loop]) {
				case DIR_RIGHT:
					for (int i = 0; i < move_s[loop]; i++) {
						curY++;
						if(curY >= N||map[curX][curY] == JUMPER) {
							out_flag = true;
							break;
						}
					}
					break;
				case DIR_LEFT:
					for (int i = 0; i < move_s[loop]; i++) {
						curY--;
						if(curY <= 0||map[curX][curY] == JUMPER) {
							out_flag = true;
							break;
						}
					}					
					break;
				case DIR_UP:
					for (int i = 0; i < move_s[loop]; i++) {
						curX--;
						if(curX <= 0 ||map[curX][curY] == JUMPER) {
							out_flag = true;
							break;
						}
					}					
					break;
				case DIR_DOWN:
					for (int i = 0; i < move_s[loop]; i++) {
						curX++;
						if(curX >= N || map[curX][curY] == JUMPER) {
							out_flag = true;
							break;
						}
					}										
					break;
				default:
					System.out.println("잘못된 입력");
				}
			}
			if(out_flag)
				result_row = result_col = 0;
			else {
				result_row = curX;
				result_col = curY;
			}
			System.out.printf("#%d %d %d\n", Tcase, result_row,result_col);
		}
	}
}
