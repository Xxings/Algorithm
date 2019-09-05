//그리디
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class sw_1244_0814 {
	static char[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			sb.append("#").append(Tcase).append(" ");
			int result = 0;
			isflag = false;
			String[] input = br.readLine().split(" ");
			number = input[0].toCharArray();
			int nchange = stoi(input[1]);

			int cnt = 0;
			while (cnt != nchange) {
				change(cnt);
				System.out.println(Arrays.toString(number));
				cnt++;
			}
			result = toInt();
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int toInt() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < number.length; i++) {
			str += number[i];
		}
		return stoi(str);
	}

	static boolean isflag;
	static Queue<Integer> condi = new LinkedList<>();
	static Queue<char[]> q = new LinkedList<>();

	private static void change(int cnt) {
		// TODO Auto-generated method stub
		if (cnt >= number.length - 1) {
			if (isflag)
				return;
			else {
				swap(number.length - 2, number.length - 1, number);
			}
		} else {
			int max_idx = cnt;
			for (int i = cnt + 1; i <= number.length - 1; i++) {
				if (number[i] > number[max_idx]) {
					max_idx = i;
					condi.clear();
				}
				if (number[i] == number[max_idx]) {
					isflag = true;
					condi.add(i);
				}
			}

			if (cnt == max_idx) {
				change(cnt + 1);
				condi.clear();
			} else {
				while (!condi.isEmpty()) {
					char[] data = q.poll();
					q.add(swap(cnt, condi.poll(),data).clone());
				}
			}
		}

	}

	private static char[] swap(int i, int j, char[] a) {
		// TODO Auto-generated method stub

		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return a;
	}

	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}
}
