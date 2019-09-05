/*
 * 13MB	349ms
 */
package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jg_1863_0902 {
	static int[] pt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans=0;
		st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		pt = new int[N+1];	//1번부터 시작 // 초기값 0
		
		for (int pair = 1; pair <= M; pair++) {
			st = new StringTokenizer(br.readLine());
			int idx1 = stoi(st.nextToken());	//부모가 될 것
			int idx2 = stoi(st.nextToken());	//자식이 될 것
			
			
			int p1 = find(idx1);
			int p2 = find(idx2);
			if(p1!=p2)
				pt[p2] = p1;
			
//			System.out.println(pair);
//			System.out.println(Arrays.toString(pt));
		}
		
		//결과 - 부모가 0인것
		for (int idx = 1; idx <= N; idx++) {
			if(pt[idx] == 0)
				ans++;
		}
		System.out.println(ans);
		
	}
	private static int find(int idx) {
		// TODO Auto-generated method stub
		if(pt[idx] == 0) {
			return idx;
		}
		else {
			return pt[idx] = find(pt[idx]);
		}
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
