package algo.study;

public class Z35_PRIM_이주복 {
	public static void main(String[] args) {
		int N = 7;
		
		int[][] graph = {{0, 32, 31, 0, 0, 60, 51},
						{32, 0, 21, 0, 0, 0, 0},
						{31, 21, 0, 0, 46, 0, 25},
						{0, 0, 0, 0, 34, 18, 0},
						{0, 0, 46, 34, 0, 40, 51},
						{60, 0, 0, 18, 40, 0, 0},
						{51, 0, 25, 0, 51, 0, 0}};
		
		
		boolean[] visit = new boolean[N];
		int[] weights = new int[N];
		int[] p = new int[N];
		
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.MAX_VALUE;
			p[i] = i;
		}
		
		
		int now = 0;
		visit[now] = true;
		weights[now] = 0;
		
		while (true) {
			System.out.println(now);
			boolean all = true;
			for (int i = 0 ; i < N; i++) {
				if (!visit[i]) {
					all = false;
					break;
				}
			}
			
			if (all) {
				break;
			}
			
			
			for (int i = 0; i < N; i++) {
				if (!visit[i]) {
					if (graph[now][i]!=0 && graph[now][i] < weights[i]) {
						weights[i] = graph[now][i];
					}
				}
			}
			
			int idx = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				if(!visit[i]) {
					if (weights[i] < min) {
						min = weights[i];
						idx = i;
					}
				}
			}
			
			now = idx;
			visit[now] = true;
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			result += weights[i];
		}
		System.out.println("result: " + result);
		
	}
}
