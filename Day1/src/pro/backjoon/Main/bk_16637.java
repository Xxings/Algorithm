/*	Greedy - Fail
 * 
 * 
 */

package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bk_16637 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int N = 19;
//		char[] input = "3-6+1*5".toCharArray();
		
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		char[] num = new char[N + 2];
		int nidx = 0;
		char[] opr = new char[N + 2];
		int oidx = 0;
		// 숫자 n+1 | 연산자 n | N = 2n+1;
		for (char data : input) {
			if (data >= '0' && data <= '9')
				num[nidx++] = data;
			else
				opr[oidx++] = data;
		}

//		System.out.println(Arrays.toString(num));
//		System.out.println(Arrays.toString(opr));

		// num ~~~
		// opr ~~~
		int nnidx = 0;
		int ooidx = 0;
		int result = num[nnidx++] - '0';
		/*
		 * 연산자 확인 (*) -> 다음 + 이면 계속 ㄱㄱ 연산자 확인 (*) -> 다음 * / -는 반영 연산자 확인 (-) -> 진행 연산자
		 * 확인 (+) -> 진행
		 */
		int temp = 0;
		while (true) {
			switch (opr[ooidx]) {
			case '*':
				temp = num[nnidx++] - '0';
				if (result > 0) {
					if (opr[ooidx + 1] == '+') {
						temp += num[nnidx++] - '0';
						ooidx++;
					}
				} else if (result == 0) {
					if (opr[ooidx + 1] == '-') {
						temp += num[nnidx++] - '0';
						ooidx++;
					}
				}
				result *= temp;
				ooidx++;
				break;
			case '+':
				temp = num[nnidx++] - '0';
				 if (opr[ooidx + 1] == '*' && result+temp <= 0) {
						temp *= num[nnidx++] - '0';
						ooidx++;
				}
				result += temp;
				ooidx++;
				break;
			case '-':
				temp = num[nnidx++] - '0';
				if (opr[ooidx + 1] == '-') {
					if ((temp - (num[nnidx] - '0')) <= 0) {
						temp -= num[nnidx++] - '0';
						ooidx++;
					}
				} else if (opr[ooidx + 1] == '*' && (num[nnidx] - '0') == 0) {
					temp *= num[nnidx++] - '0';
					ooidx++;
				}
				result -= temp;
				ooidx++;
				break;
			default:
				break;
			}
			if (nnidx == nidx)
				break;
		}
		System.out.println(result);
	}
}