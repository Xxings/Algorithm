package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bk1967_0816 {
	static Map<Integer, Node> nodeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nodeList = new HashMap<Integer, Node>();
		int N = stoi(br.readLine());
		StringTokenizer st;
		int node_no;
		int next_no;
		int weight;
		Node p;
		Node c;
		Node Head;
		//트리생성
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			node_no = stoi(st.nextToken());
			next_no = stoi(st.nextToken());
			weight = stoi(st.nextToken());
			
			if(!nodeList.containsKey(node_no)) {	//부모가 첫 호출
				p = new Node(node_no);
				c = new Node(next_no);
				p.setChild(c, weight);
				nodeList.put(node_no, p);
				nodeList.put(next_no, c);
			}else {	//첫 호출 아닐때,
				p = nodeList.get(node_no);
				c = new Node(next_no);
				p.setChild(c, weight);
				nodeList.put(next_no, c);
			}
		}
		
		int ans = 0;
		//bfs left /rigth 탐색
		for (int idx:nodeList.keySet()) {
			Head = nodeList.get(idx);
			int result = go(Head.left, Head.left_weight) + go(Head.right, Head.right_weight);
			if(ans < result) ans = result;
		}
		
		System.out.println(ans);
		
	}
	
	private static int go(Node node, int result) {
		// TODO Auto-generated method stub
		if(node == null) {
			return result;
		}
		else {
			return Math.max(go(node.left,result+node.left_weight), go(node.right,result+node.right_weight));
		}
	}

	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}

	static class Node{
		int no;
		Node left;
		Node right;
		int left_weight;
		int right_weight;
		boolean isleft;
		
		protected Node(int no) {
			super();
			this.no = no;
			this.isleft = false;
		}
		
		public Node getLeft() {
			return left;
		}
		public void setChild(Node c, int weight) {
			if(!isleft) setLeft(c,weight);
			else setRight(c,weight);
		}
		public void setLeft(Node left, int weight) {
			this.left = left;
			this.left_weight = weight;
			this.isleft = true;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right, int weight) {
			this.right = right;
			this.right_weight = weight;
		}
		
	}
}
