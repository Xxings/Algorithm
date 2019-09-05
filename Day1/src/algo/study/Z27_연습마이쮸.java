package algo.study;

import java.util.Scanner;

public class Z27_연습마이쮸 {
	public static void main(String[] args) {

		int product = 20;	//마이쮸
		
		int[] queue = new int[100];
		int front = -1;
		int rear = -1;
		int result = 0;
		
		int[] visited = new int[101];	//방문횟수
		Scanner sc = new Scanner(System.in);
		//1번이 줄을 섬
		for(int cnt = 1; product > 0; cnt++) {
			//선다
			queue[++rear] = cnt;
			System.out.println(cnt+"가 줄을 선다.");
			sc.nextLine();
			
			int no = queue[++front];
			//받는개수
			visited[no]++;
			//받는다.
			product -= visited[no];
			if(product<=0) {
				visited[no]+=product;
			}
			System.out.println(no+"번이 "+visited[no]+"개의 마이쮸를 받는다.");
			sc.nextLine();
			if(product<=0) {
				result = no;
				break;
			}
				//또선다
			queue[++rear] = no;
			System.out.println(no+"번이 다시 선다");
			sc.nextLine();
		}
		System.out.println(result+"번이 마지막으로 마이쭈를 가져갔습니다.");
	}
}
