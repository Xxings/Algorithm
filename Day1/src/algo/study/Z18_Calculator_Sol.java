package algo.study;
import java.util.Scanner;

public class Z18_Calculator_Sol {
	static String src = "31 + 4 * 2 + 7 * 2";
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		
		String s = sc.nextLine();
		String[] str = s.split(" ");
		
		int[] stack = new int[10];	//덧셈할 피연산자만 저장
		int top = -1;
		
		stack[++top] = Integer.parseInt(str[0]);	//첫번째 수식 숫자
		for(int i = 1; i < str.length; i+=2) {	//한번에 연산자, 피연산자
			char oper = str[i].charAt(0); //연산자
			int num = Integer.parseInt(str[i+1]);
			
			
			if(oper == '*') {	//*, stack 에 최근에 넣은 값을 꺼내서 * 연산 후 결과를 다시 스택에 넣기
				stack[top] *= num;
			}
			else if(oper == '+') { // Stack에 피연산자 보관
				stack[++top] = num;
			}
		}// end of for
		
		int result = 0;
		while(top != -1) {
			result += stack[top--];
		}
		
		System.out.println(result);
	}
}
