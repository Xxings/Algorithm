package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z14_E01bracket {
	public static void main(String[] args) throws IOException {
		// list ()

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		char[] stack = new char[100];
		int idxTop = -1;

		boolean isok = true;
		char[] input = str.toCharArray();
		for (char data : input) {
			// push
			if (data == '(') {
				stack[++idxTop] = data;
			}

			// pop
//			else if (idxTop != -1) {
//				if (data == ')' && stack[idxTop] == '(') {
//					idxTop -= 1;
//				}
//			}
//
//			if (idxTop == -1 && data == ')') {
//				isok = false;
//				break;
			else if (data == ')') {
				if(idxTop == -1 || stack[idxTop--]!='(') {
					isok = false;
					break;
				}
				
			}
		} // end of for

		System.out.println((isok && (idxTop == -1)) ? true : false);

	}
}
