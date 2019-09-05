package pro.sw_expert.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class temp {
	public static void main(String[] args) {
		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 10, 40 });
		q.offer(new int[] { 15, 25 });
		q.offer(new int[] { 42, 50 });
		q.offer(new int[] { 5, 50 });
		int ans = 0;
		boolean[] visited = new boolean[100];

		while (!q.isEmpty()) {

			for (int loop = 0; loop < q.size(); loop++) {
				int[] cur = q.poll();
				boolean flag = false;

				for (int idx = cur[0]; idx <= cur[1]; idx++) {
					if (visited[idx]) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					for (int idx = cur[0]; idx <= cur[1]; idx++) {
						visited[idx] = true;
					}
				}
				else {
					q.add(cur);
				}
			}//end of 1times
			ans+=1;
		}

	}
}
