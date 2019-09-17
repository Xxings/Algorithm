package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Usw_1263_0917 {
	static int[][] map;
	static int[][] memory;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = stoi(br.readLine());
		int T=1;
		StringBuilder sb = new StringBuilder();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = Integer.MAX_VALUE;
			
			int[] arr = 
				{5,0,1,1,0,0,1,0,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0};
			System.out.println(arr.length);
			/////// algo
			N = arr[0];
			queue = new int[N];
			map = new int[N+1][N+1]; //0 공백
			memory = new int[N+1][N+1]; //0 공백
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int idx = (i-1)*5+j;
					map[i][j] = arr[idx];
				}
			}
			
			Tmap(map);
			//input
			visited = new boolean[N+1];	//0 공백
			//초기화
			for (int no = 1; no <= N; no++) {
				Arrays.fill(visited, false);
				visited[no] = true;
				bfs(no, no, 0, new int[1]);	//(시작 노드번호, count;
				if(ans > sumCC(no)) ans = sumCC(no);
			}
			Tmap(memory);
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	private static void Tmap(int[][] map2) {
		// TODO Auto-generated method stub
		System.out.println();
		for (int row = 0; row < map2.length; row++) {
			System.out.println(Arrays.toString(map2[row]));
		}
	}

	private static int sumCC(int i) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int j = 1; j <= N; j++) {
			sum += memory[i][j];
		}
		return sum;
	}

	static int[] queue;
	private static void bfs(int start, int no, int cnt, int[] totalnum) {
		// TODO Auto-generated method stub
		//memozation
		int rear = -1;
		int front = -1;
		for (int go = 1; go <= N; go++) {
			if(totalnum[0] == N) return;	//끝난경우
			if(no == go) continue;	//자기자신 패스
			if(memory[go][no] != 0) {//이미 갔다왔을경우
				queue[++rear] = go;
				totalnum[0]++;
				visited[go] = true;
				memory[no][go] = memory[go][no];
				continue;
			}
			if(visited[go]) continue;	//종료
			if(map[no][go] == 1) {
				queue[++rear] = go;
				visited[go] = true;	//방문했음
				totalnum[0]++;
				memory[start][go] = cnt+1;
				memory[no][go] = 1;
			}
		}
		while(front != rear) {
			int go = queue[++front];
			bfs(start, go, cnt+1, totalnum);
		}
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
