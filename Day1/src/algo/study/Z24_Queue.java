package algo.study;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue : 선입선출 FIFO 1. API 활용 2. 메서드 구현 3. 배열
 */

public class Z24_Queue {
	public static void main(String[] args) {
		// 1. API 활용 : <Interface> Queue
		Queue q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);

		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll()); // null;
//		System.out.println(q.remove()); // exception

		// 2.메서드 구현
		enQueue(1);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());

		// 3. 알고리즘식 직접 배열
		// _CreateQueue init_
		int arr[] = new int [3];	//큐 1차원배열
		int front = -1;
		int rear = -1;

		// _enQueue_
		arr[++rear] = 1;
		arr[++rear] = 2;
		arr[++rear] = 3;

		// _deQueue_
		System.out.print(arr[++front] + " ");
		System.out.print(arr[++front] + " ");
		System.out.print(arr[++front] + " ");

		// _isEmpty_
		if (rear == front)
			System.out.println("empty");

		// isFull
		if (rear == arr.length)
			System.out.println("is Full");

		// peek
		System.out.println(arr[front + 1]);

	} // end of main

	/** 큐에 가장 먼제 들어온 데이터를 꺼내는(삭제하는) 매서드 */
	private static int deQueue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("데이터가 없음");
			return -1; // 예외처리가 더 바람직함
		}
		return q[++front];
	}

	private static boolean isEmpty() {
		// TODO Auto-generated method stub

		return (front == rear);
	}

	/** 큐에 데이터를 삽입하는 메서드 */
	private static void enQueue(int item) {
		// TODO Auto-generated method stub
		if (isFull()) {
			System.out.println("Queue overflow");
			return;
		}
		q[++rear] = item;
	}

	/** 큐가 꽉찼는지 확인하는 메소드 */
	private static boolean isFull() {
		// TODO Auto-generated method stub
		return rear == q.length - 1;
	}

	// 2. 메서드 구현
	public static int[] q = new int[5]; // 부족하지 않은 만큼
	public static int front = -1;
	public static int rear = -1;
}
