package algo.study;
import java.util.Stack;

import javax.swing.plaf.synth.SynthSplitPaneUI;

/**
 * 스택 stack LIFO : 후입 선출구조
 * 
 * @author student
 *
 */
public class Z14_Stack {
	public static void main(String[] args) {
		
		
		Stack s = new Stack();
		s.push(3);  // s.push(new Integer(3)); // BOXING
		s.push(7);
		s.push("hi");
		System.out.println(s.size()); //3
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
//		System.out.println(s.pop());	// EmptyStackException
		System.out.println(s.isEmpty());
		
		//데이터는 통합되야 더 빠르다.
		Stack<Integer> ss = new Stack<>();
		
		//알고리즘에서 너무 상속 많이 받아져있는경우, 호출보다 그냥 만드는게 더 좋다.
		
		
		push(5);
		push(9);
		push(1);
		System.out.println(pop());
		
		//빠르게 스택 만들기
		int[] x = new int[5];
		int t = -1;
		x[++t] = 3;	//PUSH
		x[++t] = 5;
		if(t != -1) {
			System.out.println(x[t--]);	//POP
		}
		System.out.println(x[t--]);
		
		
		
	}	// end of main
	
	
	private static int[] arr = new int[5000];	//크기는 부족하지 않도록
	private static int idxTop = -1;
	
	private static boolean isFull() {
		if(idxTop >= arr.length -1 ) {
			return true;
		}
		return false;
	}
	private static boolean isEmpty() {
		if(idxTop == -1 ) {
			return true;
		}
		return false;
	}
	public static int pop() {
		if(isEmpty()) {
			System.out.println("스택이 비었음");
			return -1;	//Err Exception
		}
		return arr[idxTop--];
	}
	
	public static void push(int data) {
		if(isFull()) {
			System.out.println("스택이 가득 참");
			return;
		}
		arr[++idxTop] = data;
	}
	
}
