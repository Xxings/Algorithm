package algo.study;

/***
 * - 배열 : ㅣ순차적 삽입/삭제가 빠르다, 접근성이 좋다, 비 순차적인 삽입/삭제가 느리다, 크기를 미리 정해야함
 * 
 * - 리스트 순차연결리스트 : ArrayList -> 내부적으로는 1차원 배열 ( 사이즈가 부족하면 새로 만들어준다 ), 배열의 특징을
 * 그대로 지님 (동기화??) (배열의 특징들) -> 순차적 삽입/삭제 빠르다, 접근성이 좋다, 배 순차적인 삽입/삭제가 느리다, 크기를 미리
 * 정해야함 [Vector - 새로만드는 크기는 2배씩 ] [ ArrayList - 새로만드는 크기는 1.5배 ]
 *
 * 단순연결리스트 : LinkedList, 데이터를 저장할 각 노드객체를 사용, 데이터 다음노드의 링크를 저장한다. > 장점 : 비순차적인
 * 삽입/삭제가 빠르다., 객체가 추가될때마다 동적으로 객체 생성(시간이 걸림) ,(메모리가 허용하는 한) 크기에 제한이 없다, 접근성이
 * 떨어진다.
 */
public class Z27_SinglyLinkedList {
	static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		addtoFirst(1); // Head앞에 넣기
		addtoFirst(2);
		addtoFirst(3);
		print();
		add(1, 5); // 해당위치에 데이터 삽입
		print();
		add(1, 6); // 해당위치에 데이터 삽입
		print();
		System.out.println(get(100));		// 해당위치의 데이터를 읽어오기
		addtoLast(8);
		print();
		del(1);
		print();
	}
	/** 해당 노드의 위치 삭제*/
	private static void del(int idx) {
		// TODO Auto-generated method stub
		if (idx == 0) { // idx-1작업을 하기위해서
			head = head.link;
			return;
		}

		Node pre = head;
		
		for (int i = 0; i < idx-1; i++) {
			pre = pre.link;
		}
		Node nxt = pre.link;
		pre.link = nxt.link;
	}

	private static void addtoLast(int item) {
		// TODO Auto-generated method stub
		Node node = head;
		if(node == null) {
			System.out.println("비어있음");
		}
		while(node.link!=null) {
			node = node.link;
		}
		
		Node newNode = new Node(item);
		node.link = newNode;
	}

	private static int get(int idx) {
		// TODO Auto-generated method stub
		Node node = head;
		for(int i = 0; i < idx; i++) {
			if(node.link != null) {
				node = node.link;
			}
			else {
				return -1;	//찾을 수 없음
			}
		}
		return node.data;
	}

	private static void add(int idx, int item) {
		// TODO Auto-generated method stub
		if (idx == 0) { // idx-1작업을 하기위해서
			addtoFirst(item);
			return;
		}

		Node pre = head;
		Node newNode = new Node(item);

		for (int i = 0; i < idx-1; i++) {
			pre = pre.link;
		}
		Node nxt = pre.link;
		pre.link = newNode;
		newNode.link = nxt;

	}

	public static Node head; // 링크드리스트의 첫번째 노드를 기억할 변수

	public static void print() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.link;
		}
		System.out.println();
	}

	/** 첫번째 노드로 삽입 */
	private static void addtoFirst(int item) {
		// TODO Auto-generated method stub
		Node newNode = new Node(item);
		newNode.link = head;
		head = newNode;
	}
}
