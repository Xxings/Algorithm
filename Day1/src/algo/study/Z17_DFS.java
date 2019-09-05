package algo.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/** <연습문제3 - p195>
 * 깊이우선탐색(DFS) : 마지막 갈림길을 구해올 수 있도록, Stack 자료구조가 필요하다.
 * @author student
 *
 */
public class Z17_DFS {
	public static void main(String[] args) {
		int[][] G = {	//정점에 연결된 정보를 저장
				{},	//정점 0에 인접한 정점
				{2, 3},	//정점 1에 인접한 정점
				{1, 4, 5},	//정점 2에 인접한 정점
				{1, 7},	//정점 3에 인접한 정점
				{2, 6},	//정점 4에 인접한 정점
				{2, 6},	//정점 5에 인접한 정점
				{4, 5, 7},	//정점 6에 인접한 정점
				{3, 6}	//정점 7에 인접한 정점
		};
		
		Integer [] test = new Integer[] {1,2,3,4,5,6,7};
		//Integer / int
		Arrays.sort(test,Collections.reverseOrder());
		System.out.println(Arrays.toString(test));
//		ArrayList<Integer> arrs = new ArrayList<>();
//		
//		for (int i = 0; i < G.length; i++) {
//			
//		}	
//		Collections.sort(arrs,Collections.reverseOrder());
		
		int[] stack = new int[20];
		int idxTop = -1;	// 스택에 마지막으로 저장된 데이터를 가리킬 index
		boolean[] visited = new boolean[8];	//0번째 정점은 안씀
		
		// 시작정점을 하나 지정, 시작정점을 방문, 스택에 넣고 반복을 시작
		int v = 1;	//시작정점
		stack[++idxTop] = v;	// 마지막갈림길을 확인하기 위해 지나가는 정점을 저장
		visited[v] = true;		// 방문여부
		
		// 방문해서 할일(정점 출력)
		System.out.print(v+" ");

		//반복시작 : 스택에서 값을 꺼내, 인접한 정점을 방문  
		while(idxTop > -1) {	//스택이 비워질때까지
			int w = -1;	//다음 갈 정점 저장/ 플래그 변수 역할도 겸함
			for (int i = G[v].length-1; i >=0; i--) {	// v 정점에 인접한 정점 중에서, 
				if(!visited[G[v][i]]) {	//방문하지 않았으면, 방문하기
					w = G[v][i];	//다음 갈 정점을 저장
					stack[++idxTop] = w;
					visited[w] = true;
					System.out.print(w+" ");
					v=w;
					break;
				}
			}
			if( w == -1) {	//인접한 정점중에 방문 안한 정점이 없다면
				v = stack[idxTop--];	//스택에서 마지막 갈림길을 꺼내서 가라
			}
		}
		
	}//end of main
}
