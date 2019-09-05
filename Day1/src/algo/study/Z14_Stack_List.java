package algo.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Z14_Stack_List {
	public static void main(String[] args) {		
		ListStack a = new ListStack();
		a.push(1);
		a.push(2);
		a.push(3);
		System.out.println("SIZE : "+a.size());
		a.print();
		System.out.println("POP : "+a.pop());
		a.print();
	}	
}

class ListStack <T>{
	private List<T> Stack;
	private int idxTop = -1;
	ListStack(){
		Stack = new ArrayList<T>();
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(Stack);
	}

	public int size() {
		// TODO Auto-generated method stub
		return Stack.size();
	}

	public void push(T i) {
		// TODO Auto-generated method stub
		Stack.add(i);
		idxTop++;
	}

	public T pop() {
		T data = null;
		if(!isEmpty()) {
			T data1 = Stack.get(idxTop);
			Stack.remove(idxTop);
			idxTop--;
			return data1;
		}
		return data;
	}
	public boolean isFull() {
		return false;
	}
	
	public boolean isEmpty() {
		if(idxTop == -1 ) {
			return true;
		}
		return false;
	}
}


