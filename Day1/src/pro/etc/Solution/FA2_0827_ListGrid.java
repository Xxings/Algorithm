package pro.etc.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//좌표 충돌 / N이 무수히 많고 map도 큼
public class FA2_0827_ListGrid {
	static List<Node> upData;
	static List<Node> downData;
	static List<Node> leftData;
	static List<Node> rightData;

	public static class Node {
		int row;
		int col;
		int energe;

		protected Node(int x, int y, int k) {
			super();
			this.row = x;
			this.col = y;
			this.energe = k;
		}

		@Override
		public String toString() {
			return "Node [row=" + row + ", col=" + col + ", energe=" + energe + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
//		Node[][] map = new Node[2001][2001];
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = 0;
			// 상하부터 처리;
			int N = stoi(br.readLine()); // N갯수

			upData = new ArrayList<Node>();
			downData = new ArrayList<Node>();
			leftData = new ArrayList<Node>();
			rightData = new ArrayList<Node>();

			for (int loop = 0; loop < N; loop++) {
				st = new StringTokenizer(br.readLine(), " ");
				int col = stoi(st.nextToken())+1000;
				int row = stoi(st.nextToken())+1000;
				int dir = stoi(st.nextToken());
				int k = stoi(st.nextToken());

				switch (dir) {
				case 0:
					upData.add(new Node(row, col, k));
					break;
				case 1:
					downData.add(new Node(row, col, k));
					break;
				case 2: // 좌
					leftData.add(new Node(row, col, k));
					break;
				case 3:
					rightData.add(new Node(row, col, k));
					break;
				}
			}

			// 정렬 [일단 col가 같아야지 | 상하 ]
			Collections.sort(upData, (o1, o2) -> {
				if (o1.col == o2.col) {
					return (o1.row > o2.row) ? 1 : -1;
				} else {
					return (o1.col > o2.col) ? 1 : -1;
				}
			});
			
			Collections.sort(downData, (o1, o2) -> {
				if (o1.col == o2.col) {
					return (o1.row > o2.row) ? 1 : -1;
				} else {
					return (o1.col > o2.col) ? 1 : -1;
				}
			});
				
			// 정렬 [일단 row가 같아야지 | 좌우 ]
			Collections.sort(leftData, (o1, o2) -> {
				if (o1.row == o2.row) {
					return (o1.col > o2.col) ? 1 : -1;
				} else {
					return (o1.row > o2.row) ? 1 : -1;
				}
			});
			
			Collections.sort(rightData, (o1, o2) -> {
				if (o1.row == o2.row) {
					return (o1.col > o2.col) ? 1 : -1;
				} else {
					return (o1.row > o2.row) ? 1 : -1;
				}
			});

			
			
//			//상하부터 시작
//			int fs = 0;
//			int ed = 0;
//			for (; fs < upData.size(); fs++) {
//				for (; ed < downData.size(); ed++) {
//					Node cmp1 = upData.get(fs);	//상
//					Node cmp2 = downData.get(ed);	//하
//					if(cmp1.col == cmp2.col) {
//						if(cmp1.row < cmp2.col) { //폭발
//							ans += cmp1.energe + cmp2.energe;
//							break;	//양쪽다 +1;
//						}
//						else()
//					}
//					
//				}
//			}
//			
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
