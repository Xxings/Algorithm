package algo.study;

public class Z35_Dijkstra_이주복 {
	public static void main(String[] args) {
		int N = 6;
		int result = 0;
		
		int[][] graph = {{0, 3, 5, 0, 0, 0},
				{0, 0, 2, 6, 0, 0},
				{0, 1, 0, 4, 6, 0},
				{0, 0, 0, 0, 2, 3},
				{3, 0, 0, 0, 0, 6},
				{0, 0, 0, 0, 0, 0}};
		
		int[] weights = new int[N];
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.MAX_VALUE;
		}
		
		int now = 0;
		weights[0] = 0;
		
		boolean[] visits = new boolean[N];
		visits[now] = true;
		System.out.println(now);
		
		while (true) {
			boolean finish = true;
			for (int i = 0; i < N; i++) {
				if(!visits[i]) {
					finish = false;
					break;
				}
			}
			
			if (finish) {
				break;
			}
			
			for (int i = 0; i < N; i++) {
				if (!visits[i] && graph[now][i] != 0) {
					if (weights[i] > graph[now][i] + weights[now]) {
						weights[i] = graph[now][i] + weights[now];
					}
				}
			}

			int min = Integer.MAX_VALUE;
			int idx = 0;
			
			for (int i = 0; i < N; i++) {
				if (!visits[i]) {
					if (weights[i] < min) {
						idx = i;
						min = weights[i];
					}
				}
			}
			
			result += min;
			now = idx;
			visits[now] = true;
			System.out.println(now +" :"+min);
		}
		System.out.println(result);
	}
}
