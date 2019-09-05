package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_1209 {
	public static void main(String[] args) throws IOException {
		int[][] arr = new int [100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int X = 1; X <= T; X++) {
			int Tcase = Integer.parseInt(br.readLine());
			int result = 0;
			int[] values = new int [202];
			int cnt=0;
			int sum=0;
			int diagonal_sum1 = 0;
			int diagonal_sum2 = 0;
			
			for (int row = 0; row < 100; row++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int col = 0; col < 100; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
					sum+= arr[row][col];		//흔틈 가로넣기
					if(row==col)
						diagonal_sum1 += 0;
					if(row+col == 99)
						diagonal_sum2 += 0;
				}
				values[cnt++] = sum;
				sum=0;
			}
			values[cnt++] = diagonal_sum1;
			values[cnt++] = diagonal_sum2;
			
			//세로넣기
			for (int col = 0; col < 100; col++) {
				for (int row = 0; row < 100; row++) {
					sum+= arr[row][col];
				}
				values[cnt++] = sum;
				sum=0;
			}
			Arrays.sort(values);
			result = values[201];
			System.out.printf("#%d %d \n", Tcase, result);
		}
	}
}
