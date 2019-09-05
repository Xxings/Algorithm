package algo.study;

import java.util.PriorityQueue;

public class Z36_F_PRIM {
	static final int N = 7;
	static int[] parent = new int[N];
	static int[] rank = new int[N];
	static int[] size = new int[N];
	static final int INF = Integer.MAX_VALUE;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int start;
	static int[][] cost = new int[][]
			{
					{INF,32,31,INF,INF,60,51}
					,{32,INF,21,INF,INF,INF,INF}
					,{31,21,INF,INF,46,INF,25}
					,{INF,INF,INF,INF,34,18,INF}
					,{INF,INF,46,34,INF,40,51}
					,{60,INF,INF,18,40,INF,INF}
					,{51,INF,25,INF,51,INF,INF}
			};
	
	public static void main(String[] args) {
		for (int idx = 0; idx < N; idx++) {
			MakeSet(idx);
			pq.add(idx);
		}
		start = 0;
		System.out.println(Prim(cost,0,1));
	}
	
	/**
	 * 
	 * @param graph : 그래프 간선 가중치치
	 * @param idx
	 * @param count
	 */
	private static int Prim(int[][] graph, int value, int count) {
		// TODO Auto-generated method stub
		if(count == N) return value;
		
		for (int idx = 0; idx < N; idx++) {
			int to = -1;
			int min = INF;
			for (int i = 0; i < N; i++) {
				if(idx == i ) continue;
				if(min > graph[idx][i] && isNotConnected(idx, i) ) {
					min = graph[idx][i];
					to = i;
				}
			}
			if(to == -1) continue;
			UnionSet(idx, to);
			System.out.println("연결 "+idx+"->"+to+"\t value :"+min);
			value += min;	//최소거리 더하기
			count += 1;
		}
		
		return value;
//		return Prim(graph,value,count);
	}
	private static boolean isNotConnected(int idx, int to) {
		// TODO Auto-generated method stub
		return FindSet(idx)!=FindSet(to);
	}


	private static void UnionSet(int x, int y) {
		// TODO Auto-generated method stub
		int px = FindSet(x);
		int py = FindSet(y);
		
		if(rank[px] < rank[py]) {
			parent[px] = parent[py];
			size[py] += size[px];
		}
		
		else {
			parent[py] = parent[px];
			size[px] += size[py];
			
			if(px==py)
				rank[px]++;
		}
		
		
	}



	private static void Print() {
		// TODO Auto-generated method stub
		System.out.println("=================");
		System.out.print("Node \t:");
		for (int idx = 0; idx < N; idx++) {
			System.out.printf("%2c",'A'+idx);
		}
		System.out.println();
		System.out.print("Parent\t:");
		for (int idx = 0; idx < N; idx++) {
			System.out.printf("%2c",'A'+parent[idx]);
		}
		System.out.println();
		
		System.out.print("RANK\t:");
		for (int idx = 0; idx < N; idx++) {
			System.out.printf("%2d",rank[idx]);
		}
		System.out.println();
		
		System.out.print("SIZE\t:");
		for (int idx = 0; idx < N; idx++) {
			System.out.printf("%2d",size[idx]);
		}
		System.out.println();
		System.out.println("=================");
	}



	private static int FindSet(int x) {
		// TODO Auto-generated method stub
		if( x == parent[x])	
			return x;	//자기자신이 대표자인경우;
		else 
			return FindSet(parent[x]);	//아닌경우 부모찾아감.
	}



	private static void MakeSet(int x) {
		// TODO Auto-generated method stub
		parent[x] = x;		//자기자신을 부모로 갖는 Set 생성
		size[x] = 1;
	}

}


