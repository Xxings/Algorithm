package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Z31_Tree연습1 {
	static int V;
	static List<Node> graph;
	Node HEAD;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		create_Graph(br.readLine());

	}

	private static void create_Graph(String str) {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int p = Integer.parseInt(st.nextToken());
		int c;
		Node HEAD = new Node(p);
		Node P = HEAD;
		graph.add(HEAD);

		while(!st.hasMoreTokens()) {
			c = Integer.parseInt(st.nextToken());
			P.setL(new Node(c));
			st.nextToken();
			c = Integer.parseInt(st.nextToken());
			P.setR(new Node(c));
			
		}
	
	}

	static class Node {
		Node l;
		Node r;
		
		public Node getL() {
			return l;
		}

		public void setL(Node l) {
			this.l = l;
		}

		public Node getR() {
			return r;
		}

		public void setR(Node r) {
			this.r = r;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
			this.l = null;
			this.r = null;
		}

		int data;
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}

	}
}
