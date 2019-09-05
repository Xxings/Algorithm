package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_17136 {
	static int[][] map;
	private static final int MAX_N = 10;
	static int ans = 100;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[MAX_N][MAX_N];
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 10; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
//		map = new int[][] { 
//			{ 1, 1, 1, 1, 0 }, 
//			{ 1, 1, 1, 1, 0 }, 
//			{ 1, 1, 1, 1, 0 }, 
//			{ 1, 1, 0, 1, 0 },
//			{ 1, 1, 1, 1, 0 } };
			
		int[] cnt = new int[] { 0, 5, 5, 5, 5, 5 };
		// 완탐은 역시 dfs
		int[][] chkmap = new int[MAX_N][MAX_N];
		dfs(0, 0, cnt, chkmap, 0);

		if(ans == 100)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void dfs(int row, int col, int[] cnt, int[][] chkmap, int result) {
		// TODO Auto-generated method stub
		// 1이라면, 5/4/3/2/1
		if(result >= ans) return;
		if (row == MAX_N) {
//			System.out.println("###정답 : "+result);
//			for (int i = 0; i < chkmap.length; i++) {
//				System.out.println(Arrays.toString(chkmap[i]));
//			}
			if(result < ans) {
				ans = result;	
			}
			return;
		}
		else if (col == MAX_N) {
			dfs(row + 1, 0, cnt, chkmap, result);
		} 
		// 주어진 좌표에서 되는지 확인
		else if (map[row][col] == 1) {
			boolean isOk = false; // 속도 줄이기용
			for (int n = 5; n > 0; n--) { // n은 색종이의 크기 5,4,3,2,1
				if (cnt[n] == 0) { // 이미 다사용됨
					continue;
				} else if (isOk || success(row, col, n, chkmap)) { // 큰거되면 어짜피 다됨.
					isOk = true;
//					System.out.println(n + "됨");
					cnt[n]--;
					chkmap=mapping(row,col,n,chkmap);
					dfs(row, col + n, cnt, chkmap, result+1);

					cnt[n]++;
					chkmap=deleting(row,col,n,chkmap);
				}
			}
		}
		else {
			dfs(row, col + 1, cnt, chkmap, result);
		}
	}

	private static int[][] mapping(int row, int col, int n,int[][] chkmap) {
		// TODO Auto-generated method stub
		for (int x = row; x < row + n; x++) {
			for (int y = col; y < col + n; y++) {
				chkmap[x][y]=n;
			}
		}
		return chkmap;
	}
	private static int[][] deleting(int row, int col, int n,int[][] chkmap) {
		// TODO Auto-generated method stub
		for (int x = row; x < row + n; x++) {
			for (int y = col; y < col + n; y++) {
				chkmap[x][y]=0;
			}
		}
		return chkmap;
	}


	private static boolean success(int row, int col, int n, int[][] chkmap) {
		// TODO Auto-generated method stub
		for (int x = row; x < row + n; x++) {
			for (int y = col; y < col + n; y++) {
				if(x==MAX_N) return false;
				else if(y==MAX_N) return false;
				else if (map[x][y] != 1 || chkmap[x][y] != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
