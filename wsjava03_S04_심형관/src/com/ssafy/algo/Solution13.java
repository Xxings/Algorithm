package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

class Builder{
	int[][] cnt_map;
	int[] row_map;
	int[] col_map;
	int max_value;
	int max_N;
	static final int THIS_G = -1;
	
	public Builder(int MAX_N) {
		this.cnt_map = new int[MAX_N][MAX_N];
		this.row_map = new int[MAX_N];
		this.col_map = new int[MAX_N];
		this.max_value = 0;
		this.max_N = MAX_N;
	}

	//G넣으면 -1으로 넣기
	public void InsertMap_G(int x, int y) {
		this.cnt_map[x][y] = THIS_G;
	}
	
	public int CheckMap(String[][] map) {
		row_col(map);
//		System.out.println(Arrays.toString(this.row_map));
//		System.out.println(Arrays.toString(this.col_map));
		
		//근접 G 없는거 찾기 -> 찾으면 그 row_map_value 체크
		int cur_val=0;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if(this.cnt_map[row][col]==THIS_G)	//이미 G가 들어간경우
					continue;
				else if(FindG(row,col)){	//G있으면?
					cur_val = 2;
					this.cnt_map[row][col]=cur_val;
				}
				else {	//G없으면?
					cur_val = Update_value(row,col);
					this.cnt_map[row][col] = cur_val;
				}
				
				//최고 값 
				if(this.max_value<cur_val)
					this.max_value = cur_val;
			}
		}
		return max_value;
	}
	//인근거리 G있음 : true : 인근거리 G없음 : false 
	private boolean FindG(int x, int y) {
		int[] List_row = new int[] {-1,-1,-1,0,0,1,1,1};
		int[] List_col = new int[] {-1,0,1,-1,1,-1,0,1};
		boolean[] List_dir = new boolean[8];
		Arrays.fill(List_dir, true);
		
		if(x==0) {
			List_dir[0]=false;
			List_dir[1]=false;
			List_dir[2]=false;
		}
		if(x==this.max_N-1) {
			List_dir[5]=false;
			List_dir[6]=false;
			List_dir[7]=false;
		}
		
		if(y==0) {
			List_dir[0]=false;
			List_dir[3]=false;
			List_dir[5]=false;
		}
		
		if(y==this.max_N-1) {
			List_dir[2]=false;
			List_dir[4]=false;
			List_dir[7]=false;
		}
		
		for (int i = 0; i < List_dir.length; i++) {
			if(List_dir[i]) {
				int go_x = x+List_row[i];
				int go_y = y+List_col[i];
				if(this.cnt_map[go_x][go_y]==THIS_G)
					return true;
			}
		}
		
		return false;
	}
	private void row_col(String[][] map) {
		//check row
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				this.row_map[i] += (map[i][j].equals("B"))?1:0;
				this.col_map[j] += (map[i][j].equals("B"))?1:0;
			}
		}
	}
	
	private int Update_value(int x, int y) {
		return this.row_map[x]+this.col_map[y]-1;	// -1은 자기자신
	}
	
	public void cnt_map() {
		for(int[] test : cnt_map) {
			System.out.println(Arrays.toString(test));
		}
	}
}

public class Solution13 {
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	//TestCase 입력
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int result = 0;
			int N = sc.nextInt();	//N입력
			
			//값 넣기
			// 알고리즘 시작
			
			Builder user = new Builder(N);
			
			String[][] map = new String[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					String data = sc.next();
					map[i][j] = data;
					if(data.equals("G"))
						user.InsertMap_G(i, j);
				}
			}			
			
			
			
			result=user.CheckMap(map);
			
			
			
			System.out.printf("#%d %d \n", Tcase, result);
//			user.cnt_map();
		}
	}
}
