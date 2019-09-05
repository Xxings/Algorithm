package pro.etc.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class A2_0827_map {
	static List<Node> atomList;
	static Node[][] map;
	static int[][] visited;
	static List<Integer> deleteList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// TC시작
		for (int Tcase = 1; Tcase <= T; Tcase++) {
//			map = new Node[4001][4001];	//0.5초 아웃 두배로 길게 늘림 // 0부터 시작
			visited = new int[4001][4001];
			int ans = 0;
			int N = stoi(br.readLine());

			atomList = new ArrayList<>(N);

			Node atom;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int col = (stoi(st.nextToken()) + 1000) * 2;
				int row = (stoi(st.nextToken()) + 1000) * 2;
				int dir = stoi(st.nextToken());
				int k = stoi(st.nextToken());
				atom = new Node(row, col, dir, k);
				atomList.add(atom);
				visited[row][col] = 1;
			}
			int size = atomList.size();

			int time = 1;
			while (size > 1) {
//				System.out.println("="+time++ +"초");
				for (int no = 0; no < size; no++) {
					atom = atomList.get(no);
					atom.move();
				}
				for (int no =0; no < size; no++) {
					atom = atomList.get(no);
					if (atom.isCollapse()&&!atom.isOut) {
						ans += atom.energe;
						atom.isOut = true;
					}
				}
				for (int no = size - 1; no != 0 ; no--) {
					atom = atomList.get(no);
					if (atom.isOut) {
						atomList.remove(no);
						if(atom.isCollapse)
							visited[atom.row][atom.col]=0;
					}
				}
				size = atomList.size();
			}

			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	static int[] dir_row = { 1, -1, 0, 0 }; // 상하좌우
	static int[] dir_col = { 0, 0, -1, 1 }; // 상하좌우

	public static class Node {
		static int count = 1;
		int no;
		int row;
		int col;
		int dir;
		int energe;
		boolean isOut;
		boolean isCollapse;

		protected Node(int x, int y, int dir, int k) {
			super();
			this.no = count++;
			this.row = x;
			this.col = y;
			this.dir = dir;
			this.energe = k;
			this.isOut = false;
			this.isCollapse = false;
		}

		public void move() {
			if (!isOut) { // 맵 밖으로 안나갔으면
				visited[this.row][this.col]--;

				int goRow = this.row + dir_row[dir];
				int goCol = this.col + dir_col[dir];

				if (goRow < 0 || goRow > 4000 || goCol < 0 || goCol > 4000) {
					isOut = true;
					return;
				}
				else {
					visited[goRow][goCol]++;
				}
				this.row = goRow;
				this.col = goCol;
			}

		}

		public boolean isCollapse() {
			if(visited[row][col] > 1) {
				isCollapse = true;
//				System.out.println(this.no +"폭발");
			}
			return isCollapse;
		}

		@Override
		public String toString() {
			return "Node [no=" + no + ", row=" + row + "]";
		}
	}
}
