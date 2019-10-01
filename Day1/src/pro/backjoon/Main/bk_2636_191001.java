package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 단순 시뮬
 * 메모리 13316KB	
 * 시간 84MS
 */

public class bk_2636_191001 {
	static int R;
	static int C;
	static int[][] map;
	static int[] answer = new int[2];
	static Queue<int[]> cheese = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		map = new int[R][C];
		Airvisited = new boolean[R][C];
		Cheesevisited = new boolean[R][C];
		for (int row = 0; row < R; row++) {
			String readLine = br.readLine();
			for (int col = 0; col < C; col++) {
				int data = readLine.charAt(2*col)-'0';
				map[row][col] = data;
				if(data == 1) answer[1]++;
			}
		}
		//end of input
		bfsAir(0,0,9);	//외부공기 9채우기
//		Tmap(map);
		while(bfsCheese());
		
		System.out.print(answer[0]+"\n"+answer[1]);
		

	}
	
	private static boolean bfsCheese() {
		int result = answer[1];
		
		int size = cheese.size();
		
		int[] pair;
		for (int cnt = 0; cnt < size; cnt++) {
			//꺼내오고
			pair = cheese.poll();
			map[pair[0]][pair[1]] = 9;	//공기
			result--;	//치즈개수 빼주기

			//옆에 1일때(다음 공기랑 접촉), 추가
			for (int dir = 0; dir < 4; dir++) {
				int goRow = pair[0]+dirR[dir];
				int goCol = pair[1]+dirC[dir];
				//치즈는 항상 1~N-1에 위치하므로 조건 생략
				if(Cheesevisited[goRow][goCol]) continue;
				if(map[goRow][goCol]==1) {
					Cheesevisited[goRow][goCol] = true;
					cheese.add(new int[] {goRow,goCol});
					map[goRow][goCol] = 2;
				}
				else if(map[goRow][goCol] == 0) {
				//옆에 0있을때, 후에 돌리기위해 저장
					bfsAir(goRow, goCol, 8);
				}
			}
		}
		
//		Tmap(map);
		if(result==0) {
			answer[0]++;	//t
			return false;
		}
		else {
			answer[0]++;	//t
			answer[1] = result;
			return true;
		}
	}
	private static void Tmap(int[][] map2) {
		// TODO Auto-generated method stub
		System.out.println("===");
		for (int row = 0; row < map2.length; row++) {
			System.out.println(Arrays.toString(map2[row]));
		}
	}
	static final int[] dirR = new int[] { -1, 1, 0, 0 };
	static final int[] dirC = new int[] { 0, 0, -1, 1 };
	static boolean[][] Airvisited;
	static boolean[][] Cheesevisited;
	private static void bfsAir(int r, int c, int no) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<int[]>();
		map[r][c] = no;
		q.add(new int[] {r,c});
		//연결단면찾기
		int[] pair;
		while(!q.isEmpty()) {
			pair = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int goRow = pair[0] + dirR[dir];
				int goCol = pair[1] + dirC[dir];
				if (goRow < 0 || goRow > R - 1 || goCol < 0 || goCol > C - 1)
					continue;
				if (Airvisited[goRow][goCol]) continue;
				if (map[goRow][goCol]==1) {
					cheese.add(new int[] {goRow,goCol}); //공기 접촉면 넣기
					map[goRow][goCol] = 2;	//치즈 녹을예정
					Cheesevisited[goRow][goCol] = true;
				}
				if (map[goRow][goCol]==0) {
					Airvisited[goRow][goCol] = true;
					map[goRow][goCol] = no;
					q.add(new int[] {goRow,goCol});
				}
			}
		}
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
