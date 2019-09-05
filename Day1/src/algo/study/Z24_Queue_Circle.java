package algo.study;

public class Z24_Queue_Circle {
	public class Node{
		int data;
		Node next = null;
	}
	public class Queue{
		Node front = null;
		Node rear = null;
		
		public void enqueue(int data) {
			Node node = new Node();
			node.data = data;
			
			if(front == null) {
				front = node;
//				rear = node;
//				rear.next = node;
			}
			
			else if(isFull()) {
				System.out.println("가득참");
			}
			else {
				rear.next = node;
				rear = node;
			}
		}

		private boolean isFull() {
			// TODO Auto-generated method stub
			return (front==rear.next);
		}
		
	}
	public static void main(String[] args) {
		
	}
	
}
