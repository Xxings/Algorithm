package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ubk_14890_0827 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int L = stoi(st.nextToken());
		int[][] map = new int[N][N];
		int[] goRows = new int[N];
		int[] goCols = new int[N];
		
		for (int row = 0; row < map.length; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int col = 0; col < map.length; col++) {
				map[row][col] = stoi(st.nextToken());
			}
		}	//end of map
		
		int pre;
		int cur;
		int diff = 0;
		for (int row = 0; row < N; row++) {
			int cnt = L;
			boolean isOk = true;
			boolean edge = false;
			pre = map[row][0];
			diff = 0;
			for (int col = 1; col < N; col++) {
				cur = map[row][col];
				
				if(cur-pre > 1) {
					isOk = false;
					break;
				}
				else if(diff == cur-pre) {	//차이가 전과 같음
					if(edge) {	//경사로 놓았을경우
						cnt--;
						if(cnt==0)
							edge = false;
					}
				}
				else {
					if(cur-pre != 0) {
						isOk = false;
						break;
					}
					else if()
					diff = cur-pre;
				}
			}	//end of 1
			if(isOk) ans++;
		}
		
		System.out.print(ans);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
