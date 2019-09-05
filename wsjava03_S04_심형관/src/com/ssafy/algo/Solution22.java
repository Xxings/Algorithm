package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Waterstride {
	private int x;
	private int y;
	private int no;
	private int dir; // 하 : 1 | 우 : 2
	private boolean is_out = false;
	private final int DIR_TOP = 1;
	private final int DIR_DOWN = 2;
	private final int DIR_LEFT = 3;
	private final int DIR_RIGHT = 4;

	private final int[] jump_stack = new int[] { 3, 2, 1 };
	private int jump_cnt = 0;

	public Waterstride(int no, int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.no = no;
		this.dir = dir;

	}
	
	public boolean Jump(String[][] map, int MAX_N) {
		int cur_x = this.x;
		int cur_y = this.y;
		int jump_cnt = this.jump_cnt;
		switch(this.dir) {
		case DIR_TOP:
//			System.out.println("위로 점프");
			cur_x -= jump_stack[jump_cnt];

			if (cur_x < 0) {
				MapOut();
				return true; // 아웃!
			}
			jump_cnt++;
			break;
			
		case DIR_DOWN:
//			System.out.println("아래로 점프");
			cur_x += jump_stack[jump_cnt];

			if (cur_x >= MAX_N) {
				MapOut();
				return true; // 아웃!
			}
			jump_cnt++;
			break;
			
		case DIR_LEFT:
//			System.out.println("좌측으로 점프");
			cur_y -= jump_stack[jump_cnt];
			if (cur_y < 0) {
				MapOut();
				return true; // 아웃!
			}
			jump_cnt++;
			break;
			
		case DIR_RIGHT:
//			System.out.println("우측으로 점프");
			cur_y += jump_stack[jump_cnt];
			if (cur_y >= MAX_N) {
				MapOut();
				return true; // 아웃!
			}
			jump_cnt++;
			break;
		default :
			System.out.println("잘못된 점프값");
		}
		
		if (jump_cnt >= 3)
			jump_cnt = jump_cnt % 3;

		this.jump_cnt = jump_cnt;
		this.x = cur_x;
		this.y = cur_y;
//		System.out.printf("no : %d | (%d,%d)로 점프함 \n",this.no,this.x,this.y);
		return false; // 점프 함

	}
	public int alive() {
//		System.out.printf("no : %d | %s \n",this.no,(this.is_out)?"die":"살아있음");
		return (this.is_out)?0:1;
	}
	public int whoareyou() {
		return this.no;
	}

	public int current_X() { // map 저장용
		return this.x;
	}

	public int current_Y() { // map 저장용
		return this.y;
	}

	public boolean IsOut() {
		return this.is_out;
	}
	public void CollpseOut() {
//		System.out.println(this.no + "번 소금쟁이 충돌사");
		this.is_out = true;
	}
	public void MapOut() {
//		System.out.println(this.no + "번 소금쟁이 맵밖에나감");
		this.is_out = true;
	}

}

public class Solution22 {
	static ArrayList<Waterstride> Orders;
	static String[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int result;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int N = sc.nextInt(); // 연못의 크기
			int M = sc.nextInt(); // 소금쟁이 수
			//////// 초기화//////
			result = 0;
			Orders = new ArrayList<>();
			map = new String[N][N];
			/////////////////////
			for (int i = 1; i <= M; i++) { // 소금쟁이 {1,2,3,4}
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt(); // 상 1 하 2 좌 3 우 4 
				Orders.add(new Waterstride(i, x, y, dir));
				if(map[x][y]==null)	//기존에 들어온얘가 있으면?
					mapping(x,y);
				else
					Orders.get(i-1).CollpseOut();
			}
//			T_mapViewer(N);
			// 알고리즘 //
			for (Waterstride object : Orders) {
				// 3번뜁니다.
				for (int i = 0; i < 3; i++) { // 3번뜁니다.
					if (object.IsOut())
						break;
					
					//점프전 위치 지우기
					int x = object.current_X();
					int y = object.current_Y();
					pass_mapping(x, y);

					object.Jump(map, N);
					x = object.current_X();
					y = object.current_Y();
		
					if (map[x][y]!=null) {
						object.CollpseOut();
						break;
					}
					else
						mapping(x,y);
				}
				
				result += object.alive();
			}

			System.out.println("#" + Tcase + " " + result);
		}
	} // end of main

	private static void T_mapViewer(int Max_N) {
		for (String[] data : map) {
			System.out.println(Arrays.toString(data));
		}
	}

	private static void mapping(int x, int y) {
		map[x][y] = "F";
	}
	
	private static void pass_mapping(int x, int y) {
		map[x][y] = null;
	}
}