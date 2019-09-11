package pro.Programers.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Programmers_42892_0905 {
	public static void main(String[] args) {
		Solution test = new Solution();

		int[][] nodeinfo = new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 },
				{ 7, 2 }, { 2, 2 } };
		test.solution(nodeinfo);
	}

	static class Solution {
		public int[][] solution(int[][] nodeinfo) {
			int[][] answer = new int[2][nodeinfo.length]; // 전위순회 / 후위순회

			int nNode = nodeinfo.length;	//9
			Integer[] Nodes = new Integer[nNode];
			for (int no = 0; no < nNode; no++) {
				Nodes[no] = no;
			}	//최종에서 no+1
			System.out.println(Arrays.toString(Nodes));
			//y 내림차순 x 오름차순
			
			Arrays.sort(Nodes, (a, b) -> {
				if (nodeinfo[a][1] == nodeinfo[b][1]) {	//y
					return nodeinfo[b][0] - nodeinfo[a][0];	//x
				} else {
					return nodeinfo[b][1] - nodeinfo[a][1];
				}
			});
			System.out.println(Arrays.toString(Nodes));
			
			
//			System.out.println(Arrays.toString(Nodes)); //[6, 1, 3, 2, 0, 5, 7, 8, 4]
			List<TreeNode> lists = new LinkedList<TreeNode>(); 
			// TODO : 높이 구하기
			
			for (int i = 0; i < nNode; i++) {
				TreeNode data = new TreeNode(Nodes[i]+1,nodeinfo[Nodes[i]][0]);
				lists.add(data);
			}
			
			TreeNode root=null;
			// TODO : 트리만들기
			for (TreeNode data : lists) {
				root = add(root,data);
			}
			
			idx = 0;
			preorder(root, answer[0]);
			idx = 0;
			postorder(root, answer[1]);
			
//			System.out.println(Arrays.toString(answer[0]));
//			System.out.println(Arrays.toString(answer[1]));
			return answer;
		} // end of solution
		
		//Tree 추가
		private TreeNode add(TreeNode node, TreeNode data) {
			// TODO Auto-generated method stub
			if(node == null) {
				return data;
			}
			if(node.x > data.x) {
				node.left = add(node.left, data);
			}else {
				node.right = add(node.right, data);
			}
			return node;
		}
		static int idx = 0;
		//preorder
		private void preorder(TreeNode node, int[] list) {
		    // middle->left -> right
		    if (node == null) return;
		    list[idx++] = node.no;
		    preorder(node.left, list);
		    preorder(node.right, list);
		}
		//postorder
		private void postorder(TreeNode node, int[] list) {
		    // left -> right -> middle
		    if (node == null) return;
		    postorder(node.left, list);
		    postorder(node.right, list);
		    list[idx++] = node.no;
		}
		
		static class TreeNode{
			int no;
			int x;
			TreeNode left;
			TreeNode right;
			protected TreeNode(int no, int val) {
				super();
				this.no = no;
				this.x = val;
				this.left = null;
				this.right = null;
			}
			public TreeNode getLeft() {
				return left;
			}
			public void setLeft(TreeNode left) {
				this.left = left;
			}
			public TreeNode getRight() {
				return right;
			}
			public void setRight(TreeNode right) {
				this.right = right;
			}
			
		} // end of class
	}
}
