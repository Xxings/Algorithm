package algo.study;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * +/- 계산기
 * @author student
 *
 */
public class Z18_Calculator {
//	static String src = "31 + 4 * 2 + 7 * 2";
	static String src = "2 + 3 * 4 / 5";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(src);
		
		StringTokenizer st = new StringTokenizer(src," ");
		int[] stack = new int[100];
		int idxTop = -1;
		StringBuffer str = new StringBuffer();
		
		char oper;
		String data = st.nextToken();
		boolean isturn = false;
		
		stack[++idxTop] = Integer.parseInt(data);
		str.append(data+" ");
		while(st.hasMoreTokens()) {
			oper = st.nextToken().charAt(0);	//숫자 -> 연산자 -> 숫자 -> 연산자
			if(oper == '*') {
				data = st.nextToken();
				stack[idxTop] *= Integer.parseInt(data);
				str.append(data+" ");
				str.append(oper+" ");
				if(isturn) {
					str.append('+'+" ");
					isturn = false;
				}
			}
			if(oper == '/') {
				data = st.nextToken();
				stack[idxTop] /= Integer.parseInt(data);
				str.append(data+" ");
				str.append(oper+" ");
				if(isturn) {
					str.append('+'+" ");
					isturn = false;
				}
			}
			
			else if(oper == '+') {
				data = st.nextToken();
				stack[++idxTop] = Integer.parseInt(data);
				str.append(data+" ");
				if(isturn) {
					str.append('+'+" ");
					isturn = false;
				}
				else
					isturn = true;
//				str.append(oper+" ");
			}
		}// end of while
		
		int result = 0 ;
		while(idxTop != -1) {
			result += stack[idxTop--];
		}
		System.out.println(result);
		System.out.println(str);
	}
}
