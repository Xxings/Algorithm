package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bk_2617_0823_bfs {
	static int N;
	static int[][] map;
	static HashSet<Integer>[] hsWeight;
	static HashSet<Integer>[] hsLight;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int ans = 0;

		int[][] map = new int[N + 1][M + 1];
		for (int input = 1; input <= M; input++) {
			st = new StringTokenizer(br.readLine(), " ");
			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
			// 방향성 있는 그래프 row->col 내려감 col->row 올라감
			map[big][small] = 1;
		}

		int mid = (N + 1) / 2; // 탈락기준

		// 1정점 큰 [배열 해쉬셋]
		hsWeight = new HashSet[N + 1];
		hsLight = new HashSet[N + 1];

		// 1정점 작은 [배열 해쉬셋]
		for (int i = 1; i < N; i++) {
			// i 정점보다 큰 정점을 탐색
			// 각 정점에 큰 정점의 개수, 큰 점정의 목록(재활용을 위해서, 중복정점을 체크하기 위해서)
			int nBig = dfsWeight(i).size();

			// 각 정점보다 작은 정점을 탐색
			int nSmall = dfsLight(i).size();

			if(nBig >= mid || nSmall >= mid) {
				ans+=1;
			}
		}
	}

	/** 무거운 구슬을 순회, 목록을 만들어 리턴하는 메서드 */
	private static HashSet<Integer> dfsWeight(int node) {
		// TODO Auto-generated method stub
		if (hsLight[node] == null) {

			/// 와; addAll뭔데;
			hsLight[node] = new HashSet<Integer>();
			for (int row = 0; row < N; row++) {
				if (map[node][row] == 1) {
					hsLight[node].add(row); // 현재 맵에 있는 직접 관계가 있는 정점을 담기
//				dfsWeight(row);
					/////??????????????????????????
					hsLight[node].addAll(dfsWeight(node)); // i 정점보다 더 가벼운 정점 목록을 받아서 추가
				}

			}
		}
		return hsLight[node];
	}

	/** 가벼운 구슬을 순회, 목록을 만들어 리턴하는 메서드 */
	private static HashSet<Integer> dfsLight(int node) {
		// TODO Auto-generated method stub
		if (hsWeight[node] == null) {

			/// 와; addAll뭔데;
			hsWeight[node] = new HashSet<Integer>();
			for (int row = 0; row < N; row++) {
				if (map[row][node] == 1) {
					hsWeight[node].add(row); // 현재 맵에 있는 직접 관계가 있는 정점을 담기
//				dfsWeight(row);
					hsWeight[node].addAll(dfsWeight(node)); // i 정점보다 더 가벼운 정점 목록을 받아서 추가
				}

			}
		}
		return hsWeight[node];
	}
}
