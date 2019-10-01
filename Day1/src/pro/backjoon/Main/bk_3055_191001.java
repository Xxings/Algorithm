package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 단순 시뮬문제
 * bfs
 * 메모리13268kb 시간84ms
 */
public class bk_3055_191001 {
	static int R;
	static int C;

	static char[][] map;
	static boolean[][] pvisited;
	static Queue<Fire> fireQ = new LinkedList<Fire>();
	static Queue<Human> personQ = new LinkedList<Human>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		R = stoi(st.nextToken()); // 50
		C = stoi(st.nextToken()); // 50
		map = new char[R][C];
		for (int row = 0; row < R; row++) {
			map[row] = br.readLine().toCharArray();
		}
		// end of input;
		pvisited = new boolean[R][C];

		int dR = -1;
		int dC = -1;

		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				char data = map[row][col];
				if (data == '*') {
					fireQ.add(new Fire(row, col));
					pvisited[row][col] = true;
				} else if (data == 'S') {
					personQ.add(new Human(row, col));
					pvisited[row][col] = true;
				} else if (data == 'D') {
					dR = row;
					dC = col;
				} else if (data == 'X') {
					pvisited[row][col] = true;
				}
			}
		}

		int ans = -1;
		boolean ansflag = false;
		int size;
		end: while (!personQ.isEmpty()) {

			ans++;
			// 일단 불부터 붙이기
			size = fireQ.size();
			for (int cnt = 0; cnt < size; cnt++) {
				Fire data = fireQ.poll();
				data.burning();
			}

			// 이동 진행
			size = personQ.size();
			for (int cnt = 0; cnt < size; cnt++) {
				Human cur = personQ.poll();
				if (cur.row == dR && cur.col == dC) {
					ansflag = true;
					break end;
				}
				map[cur.row][cur.col] = '.';
				cur.Move();
			}

//			System.out.println("====");
//			for (int row = 0; row < R; row++) {
//				System.out.println(Arrays.toString(map[row]));
//			}
		}

		if (ansflag)
			System.out.print(ans);
		else
			System.out.print("KAKTUS");
	}

	static final int[] dirR = new int[] { -1, 1, 0, 0 };
	static final int[] dirC = new int[] { 0, 0, -1, 1 };

	private static class Human {
		int row;
		int col;

		protected Human(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public void Move() {
			for (int dir = 0; dir < 4; dir++) {
				int goRow = this.row + dirR[dir];
				int goCol = this.col + dirC[dir];
				if (goRow < 0 || goRow > R - 1 || goCol < 0 || goCol > C - 1)
					continue;
				if (pvisited[goRow][goCol])
					continue;
				if (map[goRow][goCol] == '.' || map[goRow][goCol] == 'D') {
					pvisited[goRow][goCol] = true;
					map[goRow][goCol] = 'S';
					personQ.add(new Human(goRow, goCol));
				}
			}
		}
	}

	private static class Fire {
		int row;
		int col;

		protected Fire(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public void burning() {
			for (int dir = 0; dir < 4; dir++) {
				int goRow = this.row + dirR[dir];
				int goCol = this.col + dirC[dir];
				if (goRow < 0 || goRow > R - 1 || goCol < 0 || goCol > C - 1)
					continue;
				if (map[goRow][goCol] != '.')
					continue;
				map[goRow][goCol] = '*';
				fireQ.add(new Fire(goRow, goCol));
			}

		}
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
