package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt((br.readLine()).trim());
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int N = Integer.parseInt((br.readLine()).trim());
			
			int map[][] = createMap(N);

			System.out.printf("#%d\n", Tcase);
			for (int[] rows : map) {
				for(int data : rows) {
					System.out.printf(data+" ");
				}
				System.out.println();
			}
		}
		

	}

	private static int[][] createMap(int N) {
		int[][] result = new int[N][N];
		int cnt = 1;
		int dir = 0;
		int row = 0;
		int col = 0;
		while(cnt<N*N+1) {
			result[row][col] = cnt++;
			switch(dir) {
			case 0:	//우
				col++;
				if(col+1 > N-1 || result[row][col+1]!=0)
					dir = (dir+1)%4;
				break;
			
			case 1:	//아래
				row++;
				if(row+1 > N-1 || result[row+1][col]!=0)
					dir = (dir+1)%4;
				break;
				
			case 2:	//좌
				col--;
				if(col-1 < 0 || result[row][col-1]!=0)
					dir = (dir+1)%4;
				break;
				
			case 3:	//상
				row--;
				if(row-1 < 0 || result[row-1][col]!=0)
					dir = (dir+1)%4;
				break;
			}
		}
		return result;
	}
}
