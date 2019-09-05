package algo.study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Z18_Calculator02 {
	static String src = "6 + 5 * ( 2 - 8 ) / 2 ";
//	static String src = "2 + 3 * 4 / 5";
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		String[] input = sc.nextLine().split(" ");
		char stackOp[] = new char[10]; // 연산자만 저장할 스택
		int idxTop = -1;
//		StringBuilder sb = new StringBuilder();
		
//		int[] isp = { 0, 2, 1, 0 }; // *,/ : 1 | + - : 2
//		int[] icp = { 0, 2, 1, 3 }; // *,/ : 1 | + - : 2
		String temp;
		for (String data : input) {
			if (data.length() > 1) { // 2자리 수 이상
				System.out.print(data + " ");
				sb.append(data+" ");
			} else {
				char c = data.charAt(0); // 한단위
				switch (c) { // 조건이 많을경우 switch가 더 빠름 (hashing)
				case '(': // 넣을때는 3, 무조건 넣음
					stackOp[++idxTop] = c;
					break;
				case '*': // 넣을때 2
				case '/': // 넣을떄 2
					// 스택 꼭대기의 값이 우선순위가 나보다 작으면 쌓아라
					while (idxTop >= 0 && (stackOp[idxTop] == '*' || stackOp[idxTop] == '/')) {
						temp = stackOp[idxTop--]+" ";
						System.out.print(temp);
						sb.append(temp);
					}
					stackOp[++idxTop] = c;
					break;
				case '+': // 넣을때 1
				case '-': // 넣을때 1
					while (idxTop >= 0 && (stackOp[idxTop] != '(' )) {
						temp = stackOp[idxTop--]+" ";
						System.out.print(temp);
						sb.append(temp);
					}
					stackOp[++idxTop] = c;
					break;
				case ')': // '('나올때까지 모두 빼서 출력
						while (idxTop >= 0 && (stackOp[idxTop] != '(' )) {
							temp = stackOp[idxTop--]+" ";
							System.out.print(temp);
							sb.append(temp);
						}
						if(stackOp[idxTop] == '(') {
							idxTop--;
						}
//					System.out.print(data + " ");
					break;
				default: // 피연산자(숫자) : 바로출력
					System.out.print(data + " ");
					break;
				}

			}
		} // end of for
		//스택에 남아있는 연산자가 있으면 출력
		while(idxTop > -1) {
			temp = stackOp[idxTop--]+" ";
			System.out.print(temp);
			sb.append(temp);
		}
	}
	
	public String Data() {
		this.main(null);
		return sb.toString();
	}
}
