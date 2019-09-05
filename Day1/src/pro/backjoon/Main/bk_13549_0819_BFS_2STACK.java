//TIMEOUT
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bk_13549_0819_BFS_2STACK {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		int ans = 0;
		Stack<Integer> fs = new Stack<>();
		Stack<Integer> ls = new Stack<>();

		if (K < N) {
			ans = N - K;
		}else if(K == N) {
			ans = 0;
		}else {
			fs.add(N);

			end:while (true) {
				while(!fs.isEmpty()) {
					int cur = fs.pop();
					if(cur < 0 ) continue;
					if(cur == K)
						break end;
					else {
						ls.push(cur+1);
						ls.push(cur-1);
						if(cur != 0 && cur<=K ) {
							fs.push(cur<<1);
						}
					}
				}
				ans +=1;
				while(!ls.isEmpty()) {
					int cur = ls.pop();
					if(cur < 0 ) continue;
					if(cur == K)
						break end;
					else {
						fs.push(cur+1);
						fs.push(cur-1);
						if(cur != 0 && cur<=K) {
							ls.push(cur<<1);
						}
					}
				}
				ans +=1;
			}
		}

		System.out.println(ans);
	}

	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}
}
