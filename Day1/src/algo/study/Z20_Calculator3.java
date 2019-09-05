package algo.study;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Z20_Calculator3 {
	static String src = "2 3 4 5 / * +";

	public static void main(String[] args) {

		Scanner sc = new Scanner(src);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

		int[] stackNum = new int[100];
		int idxTop = -1;
		int num1, num2;
		while (st.hasMoreTokens()) {
			String input = st.nextToken();
			char c = input.charAt(0);
			switch (c) {
			case '*':
				num1 = stackNum[idxTop--];
				num2 = stackNum[idxTop--];
				stackNum[++idxTop] = num2 * num1;
				break;
			case '/':
				num1 = stackNum[idxTop--];
				num2 = stackNum[idxTop--];
				stackNum[++idxTop] = num2 / num1;
				break;
			case '+':
				num1 = stackNum[idxTop--];
				num2 = stackNum[idxTop--];
				stackNum[++idxTop] = num2 + num1;
				break;
			case '-':
				num1 = stackNum[idxTop--];
				num2 = stackNum[idxTop--];
				stackNum[++idxTop] = num2 - num1;
				break;
			default: // 숫자
				stackNum[++idxTop] = Integer.parseInt(input);
				break;
			}
		} // end of while
			// 작업 후 스택에는 1개의 숫자가 남아있음
		System.out.println(stackNum[idxTop--]);

	}// end of main
}
