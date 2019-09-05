//0806 0923am -> 14:39 D조건때문에 디버깅만 2시간 다시짜볼것
//
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class bk_17135 {
	static int N;
	static int M;
	static int D;
	static List<int[]> archers; // 궁수 col 모음
	static String[][] currentMap;
	private static int archer_col;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = 5;
//		M = 5;
//		D = 2;
		String[] array = br.readLine().split(" ");
		N = Integer.parseInt(array[0]);
		M = Integer.parseInt(array[1]);
		D = Integer.parseInt(array[2]);

//		String[][] arrays = { { "1", "0", "0", "0", "0" }, { "0", "0", "0", "0", "0" }, { "0", "0", "0", "0", "0" },
//				{ "0", "0", "0", "0", "0" }, { "1", "1", "1", "1", "1" } };
		String[][] arrays = new String[N][M];
		for (int loop = 0; loop < N; loop++) {
			arrays[loop] = br.readLine().split(" ");
		}

		currentMap = new String[N][M];

		///////// 예제////////////
		archers = new ArrayList<int[]>();
		set_archers(0, 0, new int[3]); // 궁수를 배치합니다.
//		Tmap(archers);
		int result = 0;
		//////// 한 조합당 게임 시작//////////////
		for (int[] archer : archers) { // archer의 조합
			// _INIT_//
			// archer

			for (int row = 0; row < arrays.length; row++) {
				currentMap[row] = arrays[row].clone();
			}
			int score = 0;
			// GAME START ////
			// 몇번 싸울지 -> N-1번 싸우나
//			Tmap(currentMap);

			for (int gameTurn = 1; gameTurn <= N + 1; gameTurn++) {

//				System.out.println("#######T gameTrun : " + gameTurn);
				score += Shot(archer); // 궁수 쏜다

				Move(); // 몬스터 이동
//				Tmap(currentMap);
			} // end for
//			System.out.println("게임 결과값 : " + score);
			if (result < score) { // 최댓값
				result = score;
			}
		}
//		System.out.println("최종 결과값 : " + result);
		System.out.println(result);
	}
//
//	private static void Tmap(List<int[]> archers2) {
//		// TODO Auto-generated method stub
//		for (int loop = 0; loop < archers2.size(); loop++) {
//			System.out.println(Arrays.toString(archers2.get(loop)));
//		}
//	}
//
//	private static void Tmap(String[][] currentMap2) {
//		// TODO Auto-generated method stub
//		for (int loop = 0; loop < currentMap2.length; loop++) {
//			System.out.println(Arrays.toString(currentMap2[loop]));
//		}
//	}
//
//	private static void Tmap(String[] currentMap2) {
//		// TODO Auto-generated method stub
//		System.out.println(Arrays.toString(currentMap2));
//	}
//	private static void Tmap(boolean[][] visitied) {
//		// TODO Auto-generated method stub
//		System.out.println("\n");
//		for (int loop = 0; loop < visitied.length; loop++) {
//			System.out.println(Arrays.toString(visitied[loop]));
//		}
//	}

	// 이동해라 몹아 한칸 밑으로
	private static void Move() {
		// TODO Auto-generated method stub
		for (int row = N - 2; row >= 0; row--) { // 젤 밑에서 한칸 위
			for (int col = 0; col < M; col++) {
				currentMap[row + 1][col] = currentMap[row][col]; // 이동시키고
				currentMap[row][col] = "0"; // 초기화
			}
		}
	}

	// 궁수 col 받아서 쏴라
	private static int Shot(int[] archer) {
		// TODO Auto-generated method stub
		int score = 0;

		int[] chrow = new int[] { 0, -1, 0 }; // 좌 위 우
		int[] chcol = new int[] { -1, 0, 1 }; // 좌 위 우
		Queue<Pair> next;
		String[] monsters = new String[3];

		int no = 0; // 아처 번호
		for (int archer_col : archer) { // 아쳐쌈
			next = new LinkedList<>();
			// 궁수 한칸위
			int stRow = N - 1;
			int stCol = archer_col;

			if (currentMap[stRow][stCol].equals("1")) { // 시작점이 바로 몬스터
				monsters[no] = stRow + "," + stCol;
			
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
							if (currentMap[curRow][curCol].equals("1")) { // 몹 찾았다!
								monsters[no] = curRow + "," + curCol;
								break end;
							}
							visitied[curRow][curCol] = true;
//							Tmap(visitied);
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



	private static int delete_monster(String[] monsters) {
		// TODO Auto-generated method stub
		int score = 0;
		for (int i = 0; i < monsters.length; i++) {
			if (monsters[i] != null) { // ,가 없다면 못찾은거니 패스
				String[] data = monsters[i].split(",");
				int row = Integer.parseInt(data[0]);
				int col = Integer.parseInt(data[1]);
				if (currentMap[row][col].equals("1")) {
					currentMap[row][col] = "-1";
					score++; // 있으니까 점수 올리자
//					System.out.println("\t ###############T : " + row + ", " + col);
				}
			}
		}
//		System.out.println("\t ###############T : "+score);
		return score;
	}

	private final static int num_Archer = 3;

	private static void set_archers(int size, int start, int[] condi) {
		// TODO Auto-generated method stub
		if (size == num_Archer) { // 다 구했어요
			archers.add(condi.clone());
//			System.out.println(Arrays.toString(condi));
			return;
		}

		for (int loop = start; loop < M; loop++) {
			condi[size] = loop;
			set_archers(size + 1, loop + 1, condi); // 위치 픽
		}
//		archers.add(new int[] {0,1,2});
	}
}

class Pair {
	int row;
	int col;

	Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}