package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ujg_2543_0930_2 {
	// r,c 더해줄값 (블럭위치)
	static int[][] block1 = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 } };
	static int[][] block2 = new int[][] { { 1, 0 }, { 0, -1 }, { 1, -1 } };
	static int[][] block3 = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 } };
	static int[][] block4 = new int[][] { { -1, -1 }, { -1, 0 }, { 0, -1 } };
	static int[][] map;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = stoi(br.readLine()); //(2^9)
		
		st = new StringTokenizer(br.readLine(), " ");
		int r = stoi(st.nextToken());
		int c = stoi(st.nextToken());
//		N = 8;
//		int r = 2;
//		int c = 3;
		map = new int[N][N];
		map[r][c] = 9;
		// 상하좌우 짝수가 되게 배치만 하면 (3*2) (2*3)모두 배치가능
		int upSize = r;
		int downSize = N - r - 1;
		int leftSize = c;
		int rightSize = N - c - 1;

		
		// end of empty space
		Tmap(map);
		// 4개사각형으로 나누기 -> X 대각선으로 따개비처럼 붙어야됨
		/*
		 * -------
		 * |___| |
		 * | |0|_|
		 * |_|___|
		 */
		//Cycle 1
		fills(r,c);
		
		Tmap(map);
	}


	private static void fills(int r, int c) {
		// TODO Auto-generated method stub
		if(r<0 || r>N-1 || c<0 || c>N-1) {
			return;
		}
		int flag=1;
		map[r][c] = 8;
		
		int upSize = r;
		int downSize = N - r - 1;
		int leftSize = c;
		int rightSize = N - c - 1;
		
		if ((downSize & 1) > 0) { // 아래 홀수
			if ((rightSize & 1) > 0) { // 우측 홀수
				// 1번 채워넣음
				for (int[] block : block1) {
					map[r + block[0]][c + block[1]] = 1;
				}
				leftSize--;
				flag=1;

			} else {
				// 2번 채워넣음
				for (int[] block : block2) {
					map[r + block[0]][c + block[1]] = 2;
				}
				
				rightSize--;
				flag=2;
			}
			downSize--;
		} else { // 아래 짝수면 위는 무조건 홀수
			if ((rightSize & 1) > 0) { // 우측 홀수
				// 3번 채워넣음
				for (int[] block : block3) {
					map[r + block[0]][c + block[1]] = 3;
				}
				leftSize--;
				
				flag=3;
			} else {
				// 4번 채워넣음
				for (int[] block : block4) {
					map[r + block[0]][c + block[1]] = 4;
				}
				rightSize--;
				flag=4;
			}
			upSize--;
		}
		Tmap(map);
		System.out.println(upSize + " "+ downSize);
		System.out.println(leftSize + " "+ rightSize);
		switch(flag) {
		case 1:
//			fills(upSize,leftSize);
			break;
		case 2:
			fills(upSize+1,leftSize+2);
//			fills(upSize-1,leftSize-1);
			break;
		case 3:
			fills(upSize+1,leftSize+1);
//			fills(upSize+1,leftSize+2);
			break;
		case 4:
//			fills(upSize+2,leftSize+2);
			break;
		}
		
//		fills(downSize,rightSize);
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
