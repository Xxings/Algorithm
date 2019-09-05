package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class People {
	private int x;
	private int y;
	private int cnt;

	private int reward=0;
	private boolean isOut = false;
	
	private final int DIR_RIGHT = 1;
	private final int DIR_DOWN = 2;
	private final int DIR_LEFT = 3;
	private final int DIR_UP = 4;
	
	public People(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.reward -= 1000; //참가비
	}

	public void jump(int[][] map, int MAX_ROW, int MAX_COL) {
		int count = this.cnt;
		int row=this.x;
		int col=this.y;
		int dir;
		int move;
		
		int next;
		END: while(count>0 && !isOut) {
			next = map[row][col];

			if(next == 0)
				break;
			dir = next/10;	//방향
			move = next%10;	//이동거리
			
			for (int i = 0; i < move; i++) {
				switch(dir) {
				case DIR_RIGHT :
					col++;
					break;
				case DIR_DOWN :
					row++;
					break;
				case DIR_LEFT :
					col--;
					break;
				case DIR_UP :
					row--;
					break;
				default :
					System.out.println("잘못된 이동");
				}
			}
			
			//맵을 나감
			if(col<0 || col>MAX_COL-1
					|| row < 0 || row > MAX_ROW - 1) {
//				System.out.println("맵아웃");
				Out();
				break END;
			}
			else if(map[row][col]==0) {
//				System.out.println("함정");
				Out();
				break END;
			}
			count--;
		}
		if(this.isOut)
			set_reward(0);
		else
			set_reward(map[row][col]);
		this.x = row;
		this.y = col;
	}
	
	private void Out() {
		this.isOut= true;
	}
	//상금 세팅
	private void set_reward(int value) {
		int result = this.reward;
		
		result += value*100;
		
		this.reward = result;
	}
	public int view_reword() {
		System.out.println(this.reward);
		return this.reward;
	}
}

public class Solution32 {
	static int map[][];
	static ArrayList<People> Orders;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int result = 0;

			int row = sc.nextInt();
			int col = sc.nextInt();
			int N = sc.nextInt(); // People

			map = new int[row][col];

			// 맵 정보 넣기
			for (int x = 0; x < row; x++) {
				for (int y = 0; y < col; y++) {
					map[x][y] = sc.nextInt();
				}
			}
			
			Orders = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int cnt = sc.nextInt();
				Orders.add(new People(x-1, y-1, cnt));
			}
			
			int trap_cnt = sc.nextInt();
			for (int i = 0; i < trap_cnt; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				trap_set(x-1,y-1);
			}
//			T_map();
			for(People A : Orders) {
				A.jump(map,row,col);
				result += A.view_reword();
			}
			

			System.out.printf("#%d %d \n", Tcase, result);
		}
	} //end of main
	public static void trap_set(int x, int y) {
		map[x][y] = 0;
	}
	public static void T_map() {
		for(int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
	}
}
