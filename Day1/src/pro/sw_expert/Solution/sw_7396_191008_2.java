/*
105,740 kb
메모리
316 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_7396_191008_2 {
	private static class Pair{
		int r;
		int c;
		protected Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + "]";
		}
		
	}
	static int[] dR = new int[] {0,1};
	static int[] dC = new int[] {1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> tempq = new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			q.clear();
			tempq.clear();
			//_Init
			
			sb.append("#").append(Tcase).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			char[][] arr = new char[N][M];
			boolean[][] visited = new boolean[N][M];
			for (int row = 0; row < N; row++) {
				arr[row] = br.readLine().toCharArray();
			}
			//end of input
			
			Pair cur = new Pair(0, 0);
			q.add(cur);
			sb.append(arr[0][0]);
			visited[0][0] = true;
			for (int step = 0; step < N-1 + M-1; step++) {
				char data = 'z'+1;
				//같은 값을 가지고있는것들이 들어옴
//				System.out.println(q);
				while(!q.isEmpty()) {
					cur = q.poll();
					for (int dir = 0; dir < 2; dir++) {
						int goR = cur.r + dR[dir];
						int goC = cur.c + dC[dir];
						if(goR<0 || goR>N-1 || goC<0 || goC>M-1) continue;
						if(visited[goR][goC]) continue;
						visited[goR][goC]=true;
						
						if(data > arr[goR][goC]) {
							data = arr[goR][goC];
							tempq.clear();
							tempq.add(new Pair(goR,goC));
						}
						
						else if(data==arr[goR][goC]) {
							tempq.add(new Pair(goR,goC));
						}
					}
				}
				sb.append(data);
				//같은것들 추가하기
				while(!tempq.isEmpty()) {
					q.add(tempq.poll());
				}
			}
			sb.append("\n");
		}// end of TC
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
