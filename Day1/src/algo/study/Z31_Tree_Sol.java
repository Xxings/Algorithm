package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 
13
1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
 */

public class Z31_Tree_Sol {
	public static int[] tree = new int[32];	//0번 인덱스 안씀, 넉넉하게 지정 / 2^n-1
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "13\r\n" + 
				"1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		tree[1] = 1;	//루트 노드 지정
		hm.put(1, 1);
		
		
		//잘 안되면 문제가 잘못된거다.
		while(st.hasMoreTokens()) {
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int idx;
			
			// 개선해야함 -> Map을 이용 (Map의 (키: 벨류) =(노드번호, 배열의 몇번째 인덱스에 있는지)
//			for(idx = 0; idx <tree.length; idx++) {
//				if (tree[idx] == p) {
//					break;
//				}
//			}
			//-> Map을 이용 (Map의 (키: 벨류) =(노드번호, 배열의 몇번째 인덱스에 있는지)
			idx = hm.get(p);
			
			//부모의 왼쪽 or 오른쪽 자식으로 저장,
			if(tree[idx*2] == 0) {	//왼쪽 자식이 없으면, 왼쪽 자식으로 등록
				tree[idx*2] = c;
				hm.put(c, idx*2);
			}
			else {	//아니면 오른쪽 자식
				tree[idx*2+1] = c;
				hm.put(c, idx*2+1);
			}
			
		}//end of while
		Tmap(tree);
		
		pre(1);	//전위순회 시작노드를 지정
		System.out.println("\n==============");
		inorder(1);	//중위순회
		System.out.println("\n==============");
		postorder(1);	//후위순회
		
	}
	private static void pre(int idx) {
		// TODO Auto-generated method stub
		if(idx > tree.length-1 || tree[idx] == 0 ) return;
		
		System.out.print(tree[idx] + " ");
		pre(idx * 2);
		pre(idx * 2 + 1);
		
	}
	
	private static void inorder(int idx) {	//중위순회
		// TODO Auto-generated method stub
				if(idx > tree.length-1 || tree[idx] == 0 ) return;				
				inorder(idx * 2);
				System.out.print(tree[idx] + " ");
				inorder(idx * 2 + 1);
	}
	
	private static void postorder(int idx) {
		// TODO Auto-generated method stub
		if(idx > tree.length-1 || tree[idx] == 0 ) return;				
		postorder(idx * 2);
		postorder(idx * 2 + 1);
		System.out.print(tree[idx] + " ");
	}
	
	
	private static void Tmap(int[] tree2) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(tree2));
	}
}
