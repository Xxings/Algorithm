package algo.study;

public class Z23_Queue_연습1 {
	public static void main(String[] args) {
		
		int arr[] = new int [3];	//큐 1차원배열
		
		//_CreateQueue init_
		int front = -1;
		int rear = -1;
		
		//_enQueue_
		arr[++rear] = 1;
		arr[++rear] = 2;
		arr[++rear] = 3;
		
		//_deQueue_
		System.out.print(arr[++front]+" ");
		System.out.print(arr[++front]+" ");
		System.out.print(arr[++front]+" ");
		
		//_isEmpty_
		if(rear==front)
			System.out.println("empty");
		
		//isFull
		if(rear == arr.length)
			System.out.println("is Full");
		
		//Qpeek
		System.out.println(arr[front+1]);
	}
	
}
