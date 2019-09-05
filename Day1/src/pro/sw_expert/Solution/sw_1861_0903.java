/*
 * 
114,472 kb
메모리
529 ms
실행시간
 * 
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_1861_0903 {
	static int N;
	static int ans1;
	static int ans2;
	static int[][] map = new int[1002][1002];	//상하좌우 0공백하나 더 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int Tcase=1; Tcase <= T; Tcase++){
			ans1=Integer.MAX_VALUE;
			ans2=Integer.MIN_VALUE;
			N = stoi(br.readLine());
			
			for (int row = 1; row <= N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 1; col <= N; col++) {
					map[row][col] = stoi(st.nextToken());
				}
			}
			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= N; col++) {
					bfs(row,col);
				}
			}
			
			
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans1).append(" ").append(ans2).append("\n");
		}
		System.out.print(sb);
		
	}
	static int[] dirR = new int[] {-1,1,0,0};	//상하좌우
	static int[] dirC = new int[] {0,0,-1,1};	//상하좌우
	
	private static void bfs(int row, int col) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<int[]>();
		//초기값 넣고
		q.add(new int[] {row,col});
		int[] pair = q.peek();
		int data = map[pair[0]][pair[1]];
		int start = data;
		int result = 0;
		while(!q.isEmpty()) {
			result++;
			pair = q.poll();
			data = map[pair[0]][pair[1]];
			for (int dir = 0; dir < 4; dir++) {
				int goRow = pair[0] + dirR[dir];
				int goCol = pair[1] + dirC[dir];
				//1,1부터 시작하므로 상관없음
				
				if( data+1 == map[goRow][goCol]) {
					q.add(new int[] {goRow,goCol});
				}
			}
		}
		if(ans2 < result) {	
			ans1 = start;
			ans2 = result;
		}else if(ans2 == result) {
			if(ans1 > start) {
				ans1 = start;
			}
		}
	}
	
	
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
