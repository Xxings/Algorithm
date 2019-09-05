package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_1697 {
	static int N;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		bfs(0, 0);
		System.out.println(result);
	}
	static boolean isok = false;
	static int result = 0;
	private static void bfs(int timer,int x) {
		// TODO Auto-generated method stub
		if(N==K) {
			isok = true;
			result = timer;
		}
		//1. 좌로
		if(x>0 && !isok)
			bfs(timer+1,x-1);
		//2. 우로
		if(x<100_000 && !isok)
			bfs(timer+1,x+1);
		//3. 점프
		if(x>0 && 2*x < 100_000 && !isok)
			bfs(timer+1, x*2);
		
	}
}
