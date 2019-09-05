package pro.sw_expert.Solution;

import java.util.Scanner;

/**
 * 
 * 사용자의 입력을 받는 방법
 * 1. BufferedReader
 * 2. Scanner : 101,648 kb |메모리 355 ms 실행시간
 * 3. JOptionPane swing 에서 사용
 */

public class sw_1210 {
	public static void main(String[] args) {
		
		int[][] map;
		int result;
		
		//Scanner
		
		Scanner sc = new Scanner(System.in);
		for (int loop = 1; loop <= 10; loop++) {
			int Tcase = sc.nextInt();
			result = 0;
			map = new int[100][100];	//맵생성
			for (int row = 0; row < map.length; row++) {
				for (int col = 0; col < map[row].length; col++) {
					map[row][col] = sc.nextInt();
				}
			}
			
			int goal_num = 0;
			for (int col = 0; col < map[map.length-1].length; col++) {
				if(map[map.length-1][col] == 2)
					goal_num = col;		// 도착점 [lenght-1, x]
			}
			
			//0 출발점까지 달리기
			int cur_row = map.length-1;
			int cur_col = goal_num;
			boolean arrow = true;
			while(cur_row!=0) {
				while(cur_col>0 && map[cur_row][cur_col-1]==1) {	//좌로
					cur_col--;
					arrow = true;
				}
				if(!arrow) {
					while(cur_col<map.length-1 && map[cur_row][cur_col+1]==1) {	//우로
						cur_col++;
					}
				}
				cur_row--;
				arrow =false;
			}
			result = cur_col;
			
			System.out.printf("#%d %d \n", Tcase, result);
		}
	} // end of main
	
}
