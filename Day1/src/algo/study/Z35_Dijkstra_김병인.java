package algo.study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Z35_Dijkstra_김병인 {
	static int p[] = new int[7];

	static void Dijkstra(int S, int[][] A) {
		List<Integer> list = new ArrayList<>();
		boolean visit[] = new boolean[A[S].length];
		int D[] = new int[A[S].length];
		for (int V = 0; V < A[S].length; ++V) {
			D[V] = A[S][V];
		}
		visit[S] = true;
		D[S] = 0;
		A[S][S] = 0;
		list.add(S);
		System.out.println("리스트 : " + list.toString());
		System.out.println("거리 : " + Arrays.toString(D));
		while (list.size() != D.length) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int V = 0; V < A[S].length; ++V) {
				if (!visit[V] && D[V] < min) {
					min = D[V];
					idx = V;
				}
			}
			list.add(idx);
			visit[idx] = true;
			for (int V = 0; V < A[idx].length; ++V) {
				if (D[idx] != Integer.MAX_VALUE && A[idx][V] != Integer.MAX_VALUE)
					D[V] = Math.min(D[V], D[idx] + A[idx][V]);
			}
			System.out.println("리스트 : " + list.toString());
			System.out.println("거리 : " + Arrays.toString(D));
		}
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		int[][] A = { { Integer.MAX_VALUE, 3, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 6, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 4, 6, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 3 },
				{ 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
						Integer.MAX_VALUE } };
		Dijkstra(0, A);
	}
}
