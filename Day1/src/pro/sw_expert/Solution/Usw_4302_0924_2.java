package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 방법 1 : linkedList - dist 
 * 
 */
public class Usw_4302_0924_2 {
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
			Pair[] strs = new Pair[N];
			int x, y, d;
			for (int idx = 0; idx < N; idx++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = stoi(st.nextToken());
				y = stoi(st.nextToken());
				d = stoi(st.nextToken());
				strs[idx] = new Pair(x,y,d,K);
			}
			
			Arrays.sort(strs);
			
			System.out.println(Arrays.toString(strs));
			Pair Head = strs[0];
//			while(Head != null) {
//				System.out.print(Head);
//				Head = Head.next;
//			}
			String a;
			a.equals(a);
			a.hashCode();
			while(Head != null) {
				if(Head.out) {
					//터졌으면,
					Pair Next = Head.next;
					Pair Pre = Head.pre;
					while(Next != null) {
						if(Head.distance+10 >= Next.distance) {
							break;
						}
						// 1. 거리 체크
						
						// 2. 터지는지 체크
						
						//터지면 Q담아 처리
						Next = Next.next;
					}//최대 200번
					
					while(Pre != null) {
						if(Head.distance-10 > Pre.distance) {
							break;
						}
						
						Pre = Pre.pre;
					}//최대 200번
					
					
					
				}
				Head.pre.next = Head.next;
				Head.next.pre = Head.pre;
				Head = Head.next;
			}
			
	}
}
	private static int stoi(String nextToken) {
		// TODO Auto-generated method stub
		return Integer.parseInt(nextToken);
	}	
	
	private static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int distance;
		boolean out = false;
		Pair pre = null;
		Pair next = null;
		
		protected Pair(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.distance = d-k;
			if(this.distance<=0)
				out = true;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if(distance-o.distance<0) {
				this.next = o;
				o.pre = this;
			}else {
				this.pre = o;
				o.next= this;
			}
			return distance-o.distance;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", distance=" + distance + ", out=" + out + "]";
		}
		
	}
}
