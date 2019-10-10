package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//단어가 곂칠경우 생각못함
public class Nsw_7396_191008 {
	static char[][] arr;
	static boolean[][] visited;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Pair> q = new LinkedList<Pair>();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			sb.append("#").append(Tcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			arr = new char[N][M];
			visited = new boolean[N][M];
			for (int row = 0; row < N; row++) {
				arr[row] = br.readLine().toCharArray();
			}


			// 사전순이므로, 항상 최선을 향해 달려가기
			int curR = 0;
			int curC = 0;
			Pair best_pair;
			Pair pair;
			int size;
			boolean flag = true;
			// 시작
			sb.append(arr[curR][curC]);
			while (!(curR == N - 1 && curC == M - 1)) {
				// 한쪽만 갈수 있는경우
				if (curR + 1 == N) {
					curC+=1;
					sb.append(arr[curR][curC]);
				}
				else if (curC + 1 == M) {
					curR+=1;
					sb.append(arr[curR][curC]);
				}

				// 같은경우
				else if (arr[curR + 1][curC] == arr[curR][curC + 1]) {
					// init
					q.add(new Pair(curR + 1, curC));
					q.add(new Pair(curR, curC + 1));
					best_pair = null;
					// start
					flag = true;
					// bfs 같을떄까지 돌리기
					while (flag) {
//						System.out.println(q);
						size = q.size();
						pair = q.poll();
						best_pair = pair;
						if(pair.isright()) q.add(pair.rightPair());
						if(pair.isdown()) q.add(pair.downPair());
						// step
						for (int idx = 1; idx < size; idx++) {
							pair = q.poll();
							if (pair == null)
								continue;
							// 같을경우
							if (best_pair.data == pair.data) {
								if(pair.isdown()) q.add(pair.downPair());
								if(pair.isright()) q.add(pair.rightPair());
							}
							// 다를경우 (작은거 pre_*로)
							else if (best_pair.data > pair.data) {
								q.clear();
								flag = false;
								best_pair = pair;
							}
						}
						sb.append(best_pair.data);
						curR = best_pair.r;
						curC = best_pair.c;
						if(q.size()==0) break;
					} // end of true
					curR = best_pair.r;
					curC = best_pair.c;
				}

				// 다른경우
				else {
					if(arr[curR + 1][curC] < arr[curR][curC + 1]) {
						curR+=1;
					}else {
						curC+=1;
					}
					sb.append(arr[curR][curC]);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	private static class Pair {
		int r;
		int c;
		char data;

		protected Pair(int r, int c) {
			this.r = r;
			this.c = c;
			this.data = arr[r][c];
			visited[r][c] = true;
		}

		protected Pair downPair() {
			return new Pair(r + 1, c);
		}

		protected boolean isright() {
			return (c + 1 != M) && (!visited[r][c + 1]);
		}
		protected boolean isdown() {
			return (r + 1 != N) && (!visited[r + 1][c]);
		}


		protected Pair rightPair() {
			return new Pair(r, c + 1);
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + ", data=" + data + "]";
		}

	}
}
