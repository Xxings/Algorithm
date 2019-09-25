package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

//B준비
public class Usw_4302_0924 {
	static int N;
	static int W;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			int ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = stoi(st.nextToken());
			W = stoi(st.nextToken());
			K = stoi(st.nextToken());
			
//			Pair[] strs = new Pair[N];
			LinkedList<Pair> strs = new LinkedList<>();
			int x, y, d;
			for (int idx = 0; idx < N; idx++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = stoi(st.nextToken());
				y = stoi(st.nextToken());
				d = stoi(st.nextToken());
				strs.add(new Pair(x,y,d,K));	//
			}
			//길이에 대한 Sort만 해보자
			Collections.sort(strs);
			
			//1. destory 판단되면 distance -10~10에 대해서 반복 (Worst = 100)
			for (int idx = 0; idx < N; idx++) {
				Pair data = strs.poll();
				
				if(data.isout) {
					int curxy = data.distance;
					int curIdx = idx;
					//영향주는 큰쪽 <=10;
					for (int dt = idx; strs[dt].distance < curxy+10; idx++) {
						
					}
					//영향주는 작은쪽 >=10;
					for (int dt = idx; strs[dt].distance > curxy-10; idx--) {
						
					}
				}
			}
			
			
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
	
	private static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int d;
		int distance;

		boolean isout = false;
		protected Pair(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.d = d-k;
			this.distance = x+y;
			if(this.d<=0) this.isout = true;
		}
		public void destroy() {
			
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub //DEQUE
//			return (distance)-(o.distance)-((isout)?2*W:0);
			return distance-o.distance;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", d=" + d + ", isout=" + isout + "]";
		}
		
	}
}
