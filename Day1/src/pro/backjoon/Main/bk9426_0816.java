// 54088kb	2940ms <- 고쳐야함
// 최소와 최대의 중앙값 pq
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk9426_0816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = stoi(input[0]);
		int K = stoi(input[1]);
		
		MID mid = new MID();
		long result = 0L;
		
//		Queue<Integer> datalist = new LinkedList<>();
		int[] datalist2 = new int[5001];	//최대 5000개
		int rearidx = -1;
		int topidx = -1;
		//초기 data	K만큼 넣기
		for (int loop = 1; loop <= K; loop++) {
			int data = stoi(br.readLine());
//			int data = 65535;
//			datalist.add(data);
			datalist2[++rearidx] = data;	//push
			mid.input(data);
		}
		result = (long)mid.mid;
//		Tprint(mid);
		
		rearidx = (rearidx==5000? -1 : rearidx);
		
		for (int loop = K+1; loop <= N; loop++) {
			int data = stoi(br.readLine());
//			int data = 65535;
//			datalist.add(data);
			datalist2[++rearidx] = data;	//push
			mid.input(data);

//			mid.remove(datalist.poll());
			mid.remove(datalist2[++topidx]);	//poll
//			Tprint(mid);
			result += (long)mid.mid;
			
			rearidx = (rearidx==5000? -1 : rearidx);
			topidx = (topidx==5000? -1 : topidx);
		}
		System.out.println(result);
	}
	
	private static void Tprint(MID mid) {
		// TODO Auto-generated method stub
		System.out.println(mid.left + "|| " +mid.left.size());
		System.out.println(mid.right + "|| " +mid.right.size());
		System.out.println(mid.mid);
		System.out.println("=============");
	}

	/* 미드값을 리턴해주는 것*/
	private static class MID{
		// TODO Auto-generated method stub
		PriorityQueue<Integer> left;	//최대 힙
		PriorityQueue<Integer> right;	//최소 힙
		int mid;
		public MID() {
			// TODO Auto-generated constructor stub
			left = new PriorityQueue<>((i,j)->i>=j?-1:1);	//최대 힙
			right = new PriorityQueue<>((i,j)->i>=j?1:-1);	//최소 힙
		}
		public void input(int data) {
			if(left.isEmpty()) {	//큐 비어있을경우
				left.add(data);
			}
			else if(mid < data) {	//중간값보다 높을 경우
				right.add(data);
				if(!right.isEmpty() && left.size() < right.size()) {
					left.add(right.poll());
				}
			}
			else {	//mid가 작거나 같음
				left.add(data);
				if(left.size() > right.size()+1 ) {
					right.add(left.poll());
				}
			}
			
			mid = left.peek();	//중간값 갱신
		}

		public void remove(int data) {
			if(!left.isEmpty() && left.contains(data))
				left.remove(data);
			else
				right.remove(data);
			if(left.size() > right.size()+1)
				right.add(left.poll());
			else if(!right.isEmpty() && left.size() < right.size())
				left.add(right.poll());		
			mid = left.peek();
		}
	}

	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}
}
