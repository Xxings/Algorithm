/*
54,892 kb
메모리
381 ms
실행시간
780
코드길이
 */
package pro.sw_expert.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class sw_5431 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		//Testcase
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();	//2<=N<=100
			int K = sc.nextInt();	//1<=K<=N
			
			if(K>N) {
				System.out.println("예제값 잘못 들어감");
				break;
			}
			
			Boolean[] arr = new Boolean[N+1];
			Arrays.fill(arr, Boolean.FALSE);
			
			for (int j = 0; j < K; j++) {
				int data = sc.nextInt();
				if(data>N) {
					System.out.println("예제값 잘못 들어감");
					break;
				}
				arr[data]=true;
			}
			System.out.print("#"+i+" ");
			for (int j = 1; j <= N; j++) {
				System.out.print((arr[j])?"":j+" ");
			}
			System.out.println();
		}
		
	}
}