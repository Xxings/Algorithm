/*
 * 메모리11MB	실행시간193ms
 */
package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jg_2543_0930_3S {
	static int[][] map;
	static int[][] block1 = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 } };
	static int[][] block2 = new int[][] { { 1, 0 }, { 0, -1 }, { 1, -1 } };
	static int[][] block3 = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 } };
	static int[][] block4 = new int[][] { { -1, -1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 분할탐색 4등분
		int N = stoi(br.readLine());
//		int N = 8;
		map = new int[N][N];
		st = new StringTokenizer(br.readLine(), " ");
		int r = stoi(st.nextToken());
		int c = stoi(st.nextToken());
//		int r = 2;
//		int c = 3;

		map[r][c] = 0;
		printData(0, 0, r, c, N);

//		int ans = 0;
//		System.out.println(ans);
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < N; row++) {
			sb.append(map[row][0]);
			for (int col = 1; col < N; col++) {
				sb.append(" ").append(map[row][col]);
			}
			if(row != N-1) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	private static void printData(int strow, int stcol, int r, int c, int size) {
		// TODO Auto-generated method stub
		// 1,2,3,4 분면 찾기
		int midrow = (strow+size/2)-1;
		int midcol = (stcol+size/2)-1;
		if (r < strow + size / 2) { // 1,2분면
			if (c < stcol + size / 2) {
				for (int[] block : block1) {
					map[midrow + block[0]][midcol + block[1]] = 1;
				}
				if (size != 2) {
					printData(strow, stcol, r, c, size/2); // 1 사분면
					printData(strow, midcol+1, midrow, midcol+1, size/2); // 2 사분면
					printData(midrow+1, stcol, midrow+1, midcol, size/2); // 3 사분면
					printData(midrow+1, midcol+1, midrow+1, midcol+1, size/2); // 4 사분면
				}
			} else { // 2분면
				for (int[] block : block2) {
					map[midrow + block[0]][midcol+1 + block[1]] = 2;
				}
				if (size != 2) {
					printData(strow, stcol, midrow, midcol, size/2); // 1 사분면
					printData(strow, midcol+1, r, c, size/2); // 2 사분면
					printData(midrow+1, stcol, midrow+1, midcol, size/2); // 3 사분면
					printData(midrow+1, midcol+1, midrow+1, midcol+1, size/2); // 4 사분면
				}
			}
		} else {	//3분면
			if (c < stcol + size / 2) {
				for (int[] block : block3) {
					map[midrow+1 + block[0]][midcol + block[1]] = 3;
				}
				if (size != 2) {
					printData(strow, stcol, midrow, midcol, size/2); // 1 사분면
					printData(strow, midcol+1, midrow, midcol+1, size/2); // 2 사분면
					printData(midrow+1, stcol, r, c, size/2); // 3 사분면
					printData(midrow+1, midcol+1, midrow+1, midcol+1, size/2); // 4 사분면
				}
			} else { // 4분면
				for (int[] block : block4) {
					map[midrow+1 + block[0]][midcol+1 + block[1]] = 4;
				}
				if (size != 2) {
					printData(strow, stcol, midrow, midcol, size/2); // 1 사분면
					printData(strow, midcol+1, midrow, midcol+1, size/2); // 2 사분면
					printData(midrow+1, stcol, midrow+1, midcol, size/2); // 3 사분면
					printData(midrow+1, midcol+1, r, c, size/2); // 4 사분면
				}
			}
		}
//		Tmap(map);
	}
	private static void Tmap(int[][] map) {
		// TODO Auto-generated method stub
		System.out.println("====");
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
