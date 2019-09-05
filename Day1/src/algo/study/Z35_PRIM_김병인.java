package algo.study;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Z35_PRIM_김병인 {
	static class Node implements Comparable<Node> {
		Node(int num, int value) {
			this.num = num;
			this.value = value;
		}

		int num;
		int value;

		@Override
		public int compareTo(Node target) {
			return this.value > target.value ? 1 : -1;
		}
	}

	static void MST_PRIM(ArrayList<Node>[] G, int r) {
		boolean[] selected = new boolean[7];
		int sum = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		System.out.printf("번호 : %2d 비용 합계 : %2d\n", r, sum);
		selected[r] = true;
		for (int i = 0; i < G[r].size(); ++i) {
			pq.add(G[r].get(i));
		}
		while (!pq.isEmpty()) {
			Node front = pq.poll();
			if (!selected[front.num]) {
				selected[front.num] = true;
				sum += front.value;
				System.out.printf("선택한  번호 : %2d 비용 합계 : %2d\n", front.num, sum);
				for (int i = 0; i < G[front.num].size(); ++i) {
					pq.add(G[front.num].get(i));
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Node>[] graph = new ArrayList[7];

		for (int i = 0; i < 7; ++i) {
			graph[i] = new ArrayList<Node>();
		}

		graph[0].add(new Node(1, 32));
		graph[0].add(new Node(2, 31));
		graph[0].add(new Node(5, 60));
		graph[0].add(new Node(6, 51));
		graph[1].add(new Node(2, 21));
		graph[1].add(new Node(0, 32));
		graph[2].add(new Node(0, 31));
		graph[2].add(new Node(1, 21));
		graph[2].add(new Node(4, 46));
		graph[2].add(new Node(6, 25));
		graph[3].add(new Node(4, 34));
		graph[3].add(new Node(5, 18));
		graph[4].add(new Node(2, 46));
		graph[4].add(new Node(3, 34));
		graph[4].add(new Node(5, 40));
		graph[4].add(new Node(6, 51));
		graph[5].add(new Node(0, 60));
		graph[5].add(new Node(3, 18));
		graph[5].add(new Node(4, 40));
		graph[6].add(new Node(0, 51));
		graph[6].add(new Node(2, 25));
		graph[6].add(new Node(4, 51));

		MST_PRIM(graph, 0);
	}
}
