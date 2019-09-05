package algo.study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Z28_BFS {
	public static void main(String[] args) {
		String src = "1,2,1,3,2,4,2,5,4,6,5,6,6,7,3,7";
		String[] input = src.split(",");
		
		int[] size = new int[10];
		int[][] connect = new int[10][10];
		
		for (int i = 0; i < input.length-1; i+=2) {
			int data1 = Integer.valueOf(input[i]);
			int data2 = Integer.valueOf(input[i+1]);
			connect[data1][size[data1]]=data2;
			size[data1]++;
			connect[data2][size[data2]]=data1;
			size[data2]++;
		}
		
		for(int[] data : connect) {
			System.out.println(Arrays.toString(data));
		}
		
		//큐 생성
		int[] q = new int[100];	// 큐 생성
		int front = -1;	// 큐 인덱스를 관리할 변수
		int rear = -1;
		boolean[] visited = new boolean[8];
		
		int v = 1; //시작정점
		q[++rear] = v;
		visited[v] = true;
		
		while(front != rear) {
			v = q[++front];
			System.out.println(v+" 방문");	//방문
//			for (int i = 0; i < size[v]; i++) {	//인접 정점들에 대해
			for (int i = size[v]-1; i>=0;i--) {		//우선순위 변경
				if(!visited[connect[v][i]]) {	//방문 안한 정점이면
					q[++rear] = connect[v][i];	//큐에 넣기
					visited[connect[v][i]]=true;	//방문확인
				}
			}
		}
		
		System.out.print(q[0]);
		for(int i=1; i<=rear; i++) {
			System.out.print("-"+q[i]);
		}
	}
}
