package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ujg_2543_0930 {
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

//		N = stoi(br.readLine()); //(2^9)
		
//		st = new StringTokenizer(br.readLine(), " ");
//		int r = stoi(st.nextToken());
//		int c = stoi(st.nextToken());
		N = 8;
		int r = 2;
		int c = 3;
		map = new int[N][N];
		map[r][c] = 9;
		// 상하좌우 짝수가 되게 배치만 하면 (3*2) (2*3)모두 배치가능
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
				rightSize--;

			} else {
				// 2번 채워넣음
				for (int[] block : block2) {
					map[r + block[0]][c + block[1]] = 2;
				}
				leftSize--;
			}
			downSize--;
		} else { // 아래 짝수면 위는 무조건 홀수
			if ((rightSize & 1) > 0) { // 우측 홀수
				// 3번 채워넣음
				for (int[] block : block3) {
					map[r + block[0]][c + block[1]] = 3;
				}
				rightSize--;
			} else {
				// 4번 채워넣음
				for (int[] block : block4) {
					map[r + block[0]][c + block[1]] = 4;
				}
				leftSize--;
			}

		}
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
		fillsblock(leftSize,upSize,block4,4);
		fillsblock(N-rightSize-1,N-downSize-1,block1,1);
		fillsblock(leftSize+1,upSize+1,block3,3);
		fillsblock(N-rightSize,N-downSize-1,block2,2);
		
		Tmap(map);
	}

	private static void fillsblock(int i, int j, int[][] blocks, int name) {
		// TODO Auto-generated method stub
		if(name == 4) {
			while(i!=0 && j!=0) {
				for (int[] block : blocks) {
					map[i + block[0]][j + block[1]] = name;
				}
				i--;
				j--;
			}
		}else if(name == 1) {
			while( i+1<N && j+1<N ) {
				for (int[] block : blocks) {
					map[i + block[0]][j + block[1]] = name;
				}
				i++;
				j++;
			}
		}else if(name == 3) {
			while( i!=0 && j+1<N ) {
				for (int[] block : blocks) {
					map[i + block[0]][j + block[1]] = name;
				}
				i--;
				j++;
			}
		}else if(name == 2) {
			while( j!=0 && i+1<N ) {
				for (int[] block : blocks) {
					map[i + block[0]][j + block[1]] = name;
				}
				i++;
				j--;
			}
		}
		
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
