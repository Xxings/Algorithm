//33304kb	504ms
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bk1655_0816 {
	public static void main(String[] args) throws IOException {
		//좌 : 최대힙 + 중간값
		PriorityQueue<Integer> qleft = new PriorityQueue<>((i,j)->i>=j ? -1 : 1 );
		//우 : 최소힙 
		PriorityQueue<Integer> qright = new PriorityQueue<>((i,j)->i>=j ? 1 : -1 );
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = stoi(br.readLine());
		
		int mid = 0;
		for (int loop = 1; loop <= N; loop++) {
			int input = stoi(br.readLine());
			
			if(qleft.isEmpty()) {	//큐 비어있을경우
				qleft.add(input);
			}
			else if(mid < input) {	//중간값보다 높을 경우
				qright.add(input);
				if(!qright.isEmpty() && qleft.size() < qright.size()) {
					qleft.add(qright.poll());
				}
			}
			else {	//mid가 작거나 같음
				qleft.add(input);
				if(qleft.size() > qright.size()+1 ) {
					qright.add(qleft.poll());
				}
			}
			
			mid = qleft.peek();	//중간값 갱신
			sb.append(mid).append("\n");
		}
		System.out.println(sb);
	}

	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}
}
