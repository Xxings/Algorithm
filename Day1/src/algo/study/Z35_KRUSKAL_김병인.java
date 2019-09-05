package algo.study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Z35_KRUSKAL_김병인 {
	static int p[] = new int[7];

	static class Node implements Comparable<Node> {
		Node(int num, int value, int s) {
			this.num = num;
			this.value = value;
			this.s = s;
		}

		int s;
		int num;
		int value;

		@Override
		public int compareTo(Node target) {
			return this.value > target.value ? 1 : -1;
		}
	}

	static void MST_KRUSKAL(ArrayList<Node>[] G, int w) {
		String s = "";
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < G.length; ++i) {
			for (int j = 0; j < G[i].size(); ++j) {
				makeSet(G[i].get(j).num);
				pq.add(G[i].get(j));
			}
		}
		int count = 0;
		while (count != G.length - 1) {
			Node front = pq.poll();
			if (findSet(front.num) != findSet(front.s)) {
				union(front.num, front.s);
				s += front.s + "-" + front.num + " " + front.value + "\n";
				++count;
			}
		}
		System.out.println(s);
	}

	public static void main(String[] args) {
		ArrayList<Node>[] graph = new ArrayList[7];

		for (int i = 0; i < 7; ++i) {
			graph[i] = new ArrayList<Node>();
		}

		graph[0].add(new Node(1, 32, 0));
		graph[0].add(new Node(2, 31, 0));
		graph[0].add(new Node(5, 60, 0));
		graph[0].add(new Node(6, 51, 0));
		graph[1].add(new Node(2, 21, 1));
		graph[1].add(new Node(0, 32, 1));
		graph[2].add(new Node(0, 31, 2));
		graph[2].add(new Node(1, 21, 2));
		graph[2].add(new Node(4, 46, 2));
		graph[2].add(new Node(6, 25, 2));
		graph[3].add(new Node(4, 34, 3));
		graph[3].add(new Node(5, 18, 3));
		graph[4].add(new Node(2, 46, 4));
		graph[4].add(new Node(3, 34, 4));
		graph[4].add(new Node(5, 40, 4));
		graph[4].add(new Node(6, 51, 4));
		graph[5].add(new Node(0, 60, 5));
		graph[5].add(new Node(3, 18, 5));
		graph[5].add(new Node(4, 40, 5));
		graph[6].add(new Node(0, 51, 6));
		graph[6].add(new Node(2, 25, 6));
		graph[6].add(new Node(4, 51, 6));

		MST_KRUSKAL(graph, 0);
	}

	/** 멤버 x를 포함하는 새로운 집합을 생성하는 메서드 */
	public static void makeSet(int x) {
		p[x] = x; // 부모를 표시, 대표자인 경우 -1 or 자신의 index 표기 가능
	}

	/** 일반 멤버 x, y를 포함하는 두 집합을 통합 */
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) {
			return;
		} else {
			p[py] = px;
		}
	}

	/** 일반 멤버 x를 포함하는 집합의 대표자를 찾아서 리턴 */
	public static int findSet(int x) {
		if (p[x] == x) {
			return x;
		} else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
}
