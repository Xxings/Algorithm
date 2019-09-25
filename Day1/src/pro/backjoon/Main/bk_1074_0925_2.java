/*
 * 	12936kb	76ms
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_1074_0925_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int ans=0;
		int n = stoi(st.nextToken());
		int r = stoi(st.nextToken());
		int c = stoi(st.nextToken());
		int[][] map = new int[][] {{0,1},{2,3}};
		int cnt = 0;
		while(!(r<=0 && c<=0)) {
			ans += (map[(r&1)][(c&1)])*(1<<cnt);
			r=r>>1;
			c=c>>1;
			cnt+=2;
		}
		System.out.println(ans);
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
