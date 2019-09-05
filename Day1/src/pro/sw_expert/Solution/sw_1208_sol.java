package pro.sw_expert.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class sw_1208_sol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dump_cnt = sc.nextInt();
		int[]arr = new int[100];
		for (int T = 1; T <= 100; T++) {
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}

			int target = 1; // target 종료

			// 오!!
			if (sum % 100 == 0) {
				target = 0;
			}

			Arrays.sort(arr);

			for (int i = 0; i < dump_cnt && arr[99] - arr[1] > target; i++) {
				arr[99]--;
				arr[0]++;
				Arrays.sort(arr);
			}
			System.out.println("#" + T + " " + (arr[99] - arr[0]));
		}
		
	}
}
