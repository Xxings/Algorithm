package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_3184_0806 {
	static int ROW;
	static int COL;
	static char map[][];
	static char[][] chkMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		ROW = Integer.parseInt(str[0]);
		COL = Integer.parseInt(str[1]);

		map = new char[ROW][COL];
		chkMap = new char[ROW][COL];
//		String src = "...#..\r\n" + ".##v#.\r\n" + "#v.#.#\r\n" + "#.o#.#\r\n" + ".###.#\r\n" + "...###";
		
//		StringTokenizer st = new StringTokenizer(src);
		for (int i = 0; i < ROW; i++) {
//			map[i] = (st.nextToken().toCharArray()).clone();
			map[i] = br.readLine().toCharArray().clone();
		}

//		Tmap(map);
//		Tmap(chkMap);
		bfs(0, 0, new Pair());

	}

	static int dir_row[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dir_col[] = { 0, 0, -1, 1 }; // 상하좌우

	// 양 o / 늑대 v
	private static void bfs(int row, int col, Pair pair) {
		// TODO Auto-generated method stub
		if (row == ROW) {
			System.out.println(pair.save_sheep+" "+pair.save_wolf);
			return;
		} else if (col == COL) {
			bfs(row + 1, 0, pair);
		} else {
			char data = map[row][col];
			if (chkMap[row][col] == '#' || map[row][col] == '#') {
				bfs(row, col+1, pair); // 옆으로 이동
			} else {
				Queue<String> q = new LinkedList<String>();
				
				if(data == 'v') pair.iamWolf();
				else if(data == 'o') pair.iamSheep();
				q.add(row+","+col);
				chkMap[row][col] = '#';
				
				while(q.size()!=0) {
					String[] temp = q.poll().split(",");
					for (int dir = 0; dir < 4; dir++) {
						int goRow = Integer.parseInt(temp[0]) + dir_row[dir];
						int goCol = Integer.parseInt(temp[1]) + dir_col[dir];
						if(goRow<0|| goRow > ROW-1 ||goCol < 0 || goCol >COL-1) continue;
						else if(chkMap[goRow][goCol] == '#') continue;
						else if(map[goRow][goCol] == '#') continue;
						else if(map[goRow][goCol] == 'v') pair.iamWolf();
						else if(map[goRow][goCol] == 'o') pair.iamSheep();
						q.add(goRow+","+goCol);
						chkMap[goRow][goCol] = '#';
					}
				}
				pair.save();
//				Tmap(map);
//				Tmap(chkMap);
				bfs(row, col+1, pair);
			}
		}
	}

	private static void Tmap(char[][] map2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map2.length; i++) {
			System.out.println(Arrays.toString(map2[i]));
		}
	}

	static class Pair {
		int wolf;
		int save_wolf;
		int sheep;
		int save_sheep;

		Pair() {
			this.wolf = 0;
			this.save_wolf = 0;
			this.sheep = 0;
			this.save_sheep =0;
		}
		public void iamWolf(){
			this.wolf++;
		}
		public void iamSheep(){
			this.sheep++;
		}
		
		public void save() {
			if(combat()) {
				save_sheep += sheep;
			}
			else {
				save_wolf += wolf;
			}
			
			this.sheep = 0;
			this.wolf = 0;
		}
		private boolean combat() {
			// TODO Auto-generated method stub
			return (this.sheep > this.wolf);
		}
	}
}
