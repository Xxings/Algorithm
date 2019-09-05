//190812
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_17406 {
	static int ROW;
	static int COL;
	static int K;
	static List<int[]> perms;
	static int[][] map;
	static int[][] tempMap;
	static Queue<int []> q;
	static int ans;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ans = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[ROW][COL];
		tempMap = new int[ROW][COL];
		
		for (int row = 0; row < ROW; row++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int col = 0; col < COL; col++) {
				map[row][col]=Integer.parseInt(st.nextToken());
			}
		}
		
//		Tmap(map);
		perms = new ArrayList<int[]>();
		create_perm(0,new int[K],new boolean[K]);
		
		List<int[]> Nroate = new ArrayList<>();
		
		int r;
		int c;
		int s;
		for (int loop = 0; loop < K; loop++) {
			st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			Nroate.add(new int[] {r,c,s});
		}
		q = new LinkedList<>();
		for(int[] condi: perms) {
			init_map();
			for(int data : condi) {
				q.add(Nroate.get(data));
			}
			//큐 다 만들었다
			while(!q.isEmpty()) {
				rotate(q.poll());
			}
			chkresult();
		}
		
		System.out.println(ans);
	}
	
	

	private static void init_map() {
		// TODO Auto-generated method stub
		for (int row = 0; row < map.length; row++) {
			tempMap[row] = map[row].clone();
		}
	}



	private static void chkresult() {
		// TODO Auto-generated method stub
		int result;
		for (int row = 0; row < ROW; row++) {
			result = 0;
			for (int col = 0; col < COL; col++) {
				result += tempMap[row][col]; 
			}
			if(ans>result) {
				ans = result;
			}
		}
	}


	static int[] dir_row = {0,1,0,-1}; //우하좌상 
	static int[] dir_col = {1,0,-1,0}; //우하좌상
	
	private static void rotate(int[] data) {
		// TODO Auto-generated method stub
		int row = data[0]-1;
		int col = data[1]-1;
		int space = data[2];
		
		int save1;
		int save2;
		int goRow;
		int goCol;
		
		for (int len = 1; len <= space; len++) {
			goRow = row-len;
			goCol = col-len;
			save1 = tempMap[goRow][goCol];
			for (int dir = 0; dir < 4; dir++) {
				for(int cnt = len*2; cnt>0; cnt--) {
					int nextRow = goRow+dir_row[dir]; 
					int nextCol = goCol+dir_col[dir];
					save2 = tempMap[nextRow][nextCol];
					tempMap[nextRow][nextCol] = save1;
					save1 = save2;
					goRow = nextRow;
					goCol = nextCol;
				}
			}
//			Tmap(tempMap);
		}
		
	}



	private static void create_perm(int start, int[] add, boolean[] chk) {
		// TODO Auto-generated method stub
		if(start == K) {
			perms.add(add.clone());
		}
		
		else {
			for (int A = 0; A < K; A++) {
				if(chk[A]) continue;
				chk[A] = true;
				add[start] = A;
				create_perm(start+1, add, chk);
				chk[A] = false;
			}
		}
		
	}


	private static void Tmap(int[] add) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(add));
	}


	private static void Tmap(int[][] map2) {
		// TODO Auto-generated method stub
		for (int row = 0; row < map2.length; row++) {
			System.out.println(Arrays.toString(map2[row]));
		}
		System.out.println();
	}


	class Pair {
		int row;
		int col;
		public Pair() {
			// TODO Auto-generated constructor stub
		}
	}
}


