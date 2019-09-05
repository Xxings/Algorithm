package algo.study;

/**
 * 큐 : FIFO 선입선출, 1:1 선형자료구조 선형큐 : 빠름, 메모리 낭비 원형큐 : 논리적으로 원형으로 끝과 처음 이어줌 (mod
 * Size) 연결큐 : 각 데이터를 하나의 노드로 객체를 생성후 연결해 줌, 객체생성하는 시간이 걸린다, 주소를 저장하는 메모리 낭비 (+
 * Object형질을 띄고있어서 연산등 메모리 더 먹음)
 */
public class Z26_연결큐 {
	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);

		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());

	}

	private static Node<?> deQueue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("스택 비어있음");
			return null;
		} else {
			Node<?> data = front;
			front = front.next;
			if (isEmpty()) {
				rear = null;
			} else {
				front = front.next;
				rear.next = front;
			}
			return data;
		}
	}

	/**
	 * 1. enQueue 2. deQueue 3. CreateQueue _init_ 4. isEmpty 5. isFull 6. Qpeek
	 */
	public static Node front; // 가장 첫번째 노드
	public static Node rear; // 가장 마지막 노드

	/** 하나의 데이터를 저장할 변수, 다음 노드의 위치를 함께 저장 */
	private static void enQueue(int item) {
		// TODO Auto-generated method stub
		Node<Integer> newNode = new Node<Integer>(item);

		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else if (isFull()) {
			System.out.println("Full");
		} else {
			rear.next = newNode;
			rear = newNode;
		}

	}

	private static boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isEmpty() {
		// TODO Auto-generated method stub
		return (front == null);
	}
}

class Node<T> {
	T data;
	Node next;

	public Node(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data.toString();
	}
}
