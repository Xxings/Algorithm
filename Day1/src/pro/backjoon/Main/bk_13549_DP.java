package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bk_13549_DP {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans=0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new HashMap<String, Integer>();
		if(M<N) ans = N-M;
		else if(M==N) ans = 0;
		else {
			dp(N, 0);
		}
		System.out.println(ans);
	}
	
	static Map<String, Integer> visited;
	static int ans;
	private static void dp(int cur, int count) {
		// TODO Auto-generated method stub
		if(cur == M) {
			if(ans > count)
				ans = count;
		}
		String key = cur+","+count;
		if(visited.containsKey(key)) {
			visited.get(key);
		}
//		visited.put(key, count);
		dp(2*cur, count);
		dp(cur+1, count+1);
		dp(cur-1, count+1);
	}
}
