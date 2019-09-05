package pro.backjoon.Main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class bk_1655_0813 {
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) {
//		pq = new PriorityQueue<>();
		pq = new PriorityQueue<>((x,y)->x>=y? 1:-1);
		
		pq.add(3);
		pq.add(3);
		pq.add(2);
		pq.add(4);
		pq.add(1);
		
		for(int data : pq) {
			System.out.println(data);
		}
	}
}
