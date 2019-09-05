/**
 * 47200KB -> 36224KB
 * 288MS -> 192MS
 * 
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_17135_0904 {
	static int N;
	static int M;
	static int D;
	static List<int[]> archers; // 궁수 col 모음
	static int[][] currentMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		D = stoi(st.nextToken());

		int[][] map = new int[N][M];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int col = 0; col < M; col++){
			map[row][col] = stoi(st.nextToken());
			}
		}

		currentMap = new int[N][M];


		archers = new ArrayList<int[]>();
		set_archers(0, 0, new int[3]); // 궁수를 배치.

		int result = 0;
		//////// 한 조합당 게임 시작//////////////
		for (int[] archer : archers) { // archer의 조합
			// _INIT_//

			for (int row = 0; row < N; row++) {
				currentMap[row] = map[row].clone();
			}
			int score = 0;
			// GAME START ////

			for (int gameTurn = 1; gameTurn <= N + 1; gameTurn++) {
				score += Shot(archer); // 궁수 쏜다
				Move(); // 몬스터 이동

			} // end for

			if (result < score) { // 최댓값
				result = score;
			}
		}

		System.out.println(result);
	}
	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}

	// 이동해라 몹아 한칸 밑으로
	private static void Move() {
		// TODO Auto-generated method stub
		for (int row = N - 2; row >= 0; row--) { // 젤 밑에서 한칸 위
			for (int col = 0; col < M; col++) {
				currentMap[row + 1][col] = currentMap[row][col]; // 이동시키고
			}
		}
		Arrays.fill(currentMap[0], 0);
	}

	private static int Shot(int[] archer) {
		int[] chrow = new int[] { 0, -1, 0 }; // 좌 상 우
		int[] chcol = new int[] { -1, 0, 1 }; // 좌 상 우
		Queue<Pair> next;
		int[][] monsters = new int[3][2];
		for (int i = 0; i < monsters.length; i++) {
			Arrays.fill(monsters[i], -1);
		}

		int no = 0; // 아처 번호
		for (int archer_col : archer) { // 아쳐쌈
			next = new LinkedList<>();
			// 궁수 한칸위
			int stRow = N - 1;
			int stCol = archer_col;

			if (currentMap[stRow][stCol]==1) { // 시작점이 바로 몬스터
				monsters[no][0] = stRow;
				monsters[no][1] = stCol;
			
			} else {// BFS
				next.add(new Pair(stRow, stCol));
				boolean[][] visitied = new boolean[N][M];
				visitied[stRow][stCol] = true;	//시작점 방문함

				end: while (!next.isEmpty()) {
					Pair Data = next.poll();

					if(Math.abs(Data.row - N ) + Math.abs(Data.col - archer_col ) +1 > D) {	//범위 벗어남
						break;
					}
					
					for (int dir = 0; dir < 3; dir++) {
						int curRow = Data.row + chrow[dir];
						int curCol = Data.col + chcol[dir];
						// 맵 벗어남
						if (curRow < 0 || curRow > N - 1 || curCol < 0 || curCol > M - 1) {
							continue;
						}
						else if (!visitied[curRow][curCol]) { // 이미 방문했으면 Pass
							if (currentMap[curRow][curCol]==1) { // 몹 찾았다!
								monsters[no][0] = curRow;
								monsters[no][1] = curCol;
								break end;
							}
							visitied[curRow][curCol] = true;
							next.add(new Pair(curRow, curCol));
						}
					} // 3방향 탐색

				} // end of bfs
			}
			no++;
		} // 아처 돌리기
			// 몬스터 곂치는지 확인하고 지우기

		return delete_monster(monsters);
	}



	private static int delete_monster(int[][] monsters) {
		// TODO Auto-generated method stub
		int score = 0;
		for (int i = 0; i < num_Archer; i++) {
			if (monsters[i][0] != -1) { // 값이 없다면 못찾은거니 패스
				int row = monsters[i][0];
				int col = monsters[i][1];
				if (currentMap[row][col]==1) {
					currentMap[row][col]=-1;
					score++; // 있으니까 점수 올리자
				}
			}
		}
		return score;
	}

	private final static int num_Archer = 3;

	private static void set_archers(int size, int start, int[] condi) {
		// TODO Auto-generated method stub
		if (size == num_Archer) { 
			archers.add(condi.clone());
			return;
		}

		for (int loop = start; loop < M; loop++) {
			condi[size] = loop;
			set_archers(size + 1, loop + 1, condi); // 위치 픽
		}
	}
	private static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}

