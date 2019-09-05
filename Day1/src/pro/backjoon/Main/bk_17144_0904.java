/*
 * 26392KB 292MS
 * 
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bk_17144_0904 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R;
	static int C;
	static int T;

	public static void main(String[] args) throws IOException {
		int[][] mapA; // 0 / N+1 아웃
		int[][] mapB;
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		T = stoi(st.nextToken());
		mapA = new int[R][C];
		mapB = new int[R][C];
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				int data = stoi(st.nextToken());
				mapA[row][col] = data;
			}
		}
		// 공기청정기 위치
		int whereR = 0;

		for (int row = 0; row < R; row++) {
			if (mapA[row][0] == -1) {
				whereR = row;
				break;
			}
		}

		int t = 0;
		int[][] temp; // 주소 swap
		// TODO : T while
		while (t < T) {
			// TODO : 확산한다
			spread(mapA, mapB);	//A->B
			temp = mapA;
			mapA = mapB;
			mapB = temp;
			
			// TODO : 공기청정기 작동
			upwind(mapA, mapB, whereR, 0);
			downwind(mapA, mapB, whereR + 1, 0);	//A->B
			temp = mapA;
			mapA = mapB;
			mapB = temp;
			t++;
		}
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if(mapA[row][col]>0)
					ans+=mapA[row][col];
			}
		}
		System.out.println(ans);
	}

	private static void upwind(int[][] mapA, int[][] mapB, int whereR, int whereC) {
		// TODO Auto-generated method stub
		int row = whereR;
		int col = whereC;
		mapA[whereR][whereC] = 0;
		// 우
		for (; col < C - 1; col++) {
			mapB[row][col + 1] = mapA[row][col];
		}
		// 상
		for (; row > 0; row--) {
			mapB[row - 1][col] = mapA[row][col];
		}
		// 좌
		for (; col > 0; col--) {
			mapB[row][col - 1] = mapA[row][col];
		}
		// 하
		for (; row < whereR - 1; row++) {
			mapB[row + 1][col] = mapA[row][col];
		}

		mapB[whereR][whereC] = -1;
//		mapB[whereR - 1][whereC] = 0;
	}

	private static void downwind(int[][] mapA, int[][] mapB, int whereR, int whereC) {
		// TODO Auto-generated method stub
		int row = whereR;
		int col = whereC;
		mapA[whereR][whereC] = 0;
		// 우
		for (; col < C - 1; col++) {
			mapB[row][col + 1] = mapA[row][col];
		}
		// 하
		for (; row < R - 1; row++) {
			mapB[row + 1][col] = mapA[row][col];
		}

		// 좌
		for (; col > 0; col--) {
			mapB[row][col - 1] = mapA[row][col];
		}

		// 상
		for (; row > whereR + 1; row--) {
			mapB[row - 1][col] = mapA[row][col];
		}

		mapB[whereR][whereC] = -1;
//		mapB[whereR + 1][whereC] = 0;
	}

	static int[] dirR = new int[] { -1, 1, 0, 0 }; // 상하좌우
	static int[] dirC = new int[] { 0, 0, -1, 1 };

	private static void spread(int[][] mapA, int[][] mapB) {
		// TODO Auto-generated method stub
		for (int row = 0; row < R; row++) {
			Arrays.fill(mapB[row],0);
		}
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (mapA[row][col] == 0)
					continue; // 0이면 패스

				if (mapA[row][col] < 0) { // 공기청정기 넣기
					mapB[row][col] = -1;
				} else { // 미세먼지있음
					int cnt = 0;
					int data = mapA[row][col];
					for (int dir = 0; dir < 4; dir++) {
						int goRow = row + dirR[dir];
						int goCol = col + dirC[dir];
						// 조건식
						if (goRow < 0 || goRow > R - 1 || goCol < 0 || goCol > C - 1 || mapA[goRow][goCol] == -1)
							continue;
						cnt++;
						mapB[goRow][goCol] += data / 5;
					}
					mapB[row][col] += data - cnt * (data / 5);
				}
			}
		}
		// TODO : SAVE
		for (int row = 0; row < R; row++) {
			mapA[row] = mapB[row].clone();
		}
	}

	private static void Tmap(int[][] map2) {
		// TODO Auto-generated method stub
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				System.out.printf("%2d ", map2[row][col]);
			}
			System.out.println();
		}
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
