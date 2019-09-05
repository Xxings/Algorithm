package algo.study;
import java.util.Arrays;

public class Z13_연습문제3 {
	static int N;
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{9,20,2,18,11},
			{19,1,25,3,21},
			{8,24,10,17,7},
			{15,4,16,5,6},
			{12,13,22,23,14}
		};
		
		for (int row = 0; row < arr.length; row++) {
			Arrays.sort(arr[row]);
		}
		
		
		N=arr.length;
		int[] value = new int[N*N];
		
		
		//값 1차원 배열로 정리
		int cnt = 0;
		for (int[] rows : arr) {
			for (int data : rows) {
				value[cnt++]=data;
			}
		}
		Arrays.sort(value);

		int[][] map = make_map(value);

		for (int row = 0; row < map.length; row++) {
			System.out.print("  ");
			for (int col = 0; col < map.length; col++) {
				System.out.printf("%2d ",map[row][col]);
			}
			System.out.println();
		}

	}	//end of main


	static final int RIGHT = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int UP = 3;
	
	/**
	 * make_map
	 * 달팽이 모양으로 오름차순 값 넣기
	 * @param value
	 * @return int[][]
	 */
	private static int[][] make_map(int[] value) {
		int result[][] = new int [N][N];
		
		int idx = 0;
		
		int row = 0;
		int col = 0;
		int dir = 0;	//0우 1하 2좌 3상
		while(idx != N*N) {
			result[row][col] = value[idx];
			switch(dir) {
			case RIGHT:	//우
				col++;
				if(col == N-1||result[row][col+1] != 0)
					dir = (dir+1)%4;
				break;
			case DOWN:	//하
				row++;
				if(row == N-1 || result[row+1][col] != 0)
					dir = (dir+1)%4;
				break;
			case LEFT: //좌
				col--;
				if(col == 0 || result[row][col-1] != 0)
					dir = (dir+1)%4;
				break;
			case UP: //상
				row--;
				if(row == 0 || result[row-1][col] != 0)
					dir = (dir+1)%4;
				break;
			}
			idx++;
		}
		return result;
	}
}
