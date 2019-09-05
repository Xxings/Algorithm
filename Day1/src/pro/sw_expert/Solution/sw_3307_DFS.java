/*
 * 시간초과
 * **/

package pro.sw_expert.Solution;

import java.util.Scanner;

public class sw_3307_DFS {
	static int N;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int result;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			N = sc.nextInt();
			arr = new int[N];
			// 입력부
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			result = DFS(0, 0, 0);
			System.out.println("#" + Tcase + " " + result);

		}
	}
	// 4 2 3 1 5 6

	public static int DFS(int idx, int cnt, int memory) {
		if (idx == N)
			return cnt;
		
		else if (memory > arr[idx])
			return DFS(idx+1,cnt,memory);
		
		else {
			return (Math.max
					(DFS(idx+1,cnt,memory)
					,DFS(idx+1,cnt+1,memory=arr[idx])	//선택한 경우
					));
		}
	}
}
