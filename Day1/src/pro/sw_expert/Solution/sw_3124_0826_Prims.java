/*
 * 125,152 kb -> 126,812 kb
메모리
5,306 ms - >1,780 ms
실행시간

 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw_3124_0826_Prims {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->(o1.C>o2.C)?1:-1);
		for(int Tcase=1; Tcase <= T; Tcase++){
			st = new StringTokenizer(br.readLine(), " ");
			sb.append("#").append(Tcase).append(" ");
			pq.clear();
			int V = stoi(st.nextToken());
			int chk = 1;
			int E = stoi(st.nextToken());
			
			p = new int[V+1];
			for (int loop = 1; loop < V+1; loop++) {
				p[loop] = loop;
			}
			Long ans=0L;
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = stoi(st.nextToken());
				int B = stoi(st.nextToken());
				int C = stoi(st.nextToken());
				pq.add(new Pair(A,B,C));
			}
			
			while(!pq.isEmpty()) {
				Pair temp = pq.poll();
				int pA = search_p(temp.A);
				int pB = search_p(temp.B);
				
				if(pA != pB) {
					p[pB] = pA;
					ans+=temp.C;
					chk++;
				}
				if(chk==V)
					break;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	
	public static int search_p(int x) {
		if(p[x]==x)
			return x;
		return p[x]=search_p(p[x]);
	}
	
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
	
	private static class Pair{
		int A;
		int B;
		int C;
		protected Pair(int x, int y, int weight) {
			super();
			this.A = x;
			this.B = y;
			this.C = weight;
		}
	}
}
