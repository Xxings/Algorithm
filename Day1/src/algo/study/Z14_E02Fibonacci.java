package algo.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 재귀함수		:코드는 간단, 엄청난 중복호출이 발생
 * 2. 재귀함수+메모이제이션 : 중복호출이 약간 줄어들었지만, 계산했었는지 체크하려고 한번씩 들림
 * 3. DP :
 * @author student
 *
 */

public class Z14_E02Fibonacci {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println(Fibo_DP(N));
		System.out.println(Fibo_DP2(N));
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;
		System.out.println(Fibo_memo(N));
		
		System.out.println(Fibo(N));
	} // end of main

	// 재귀함수
	private static long Fibo(int n) {
		// TODO Auto-generated method stub
		if (n < 0)
			return 0L;
		else if (n == 1 || n == 2) {
			return 1L;
		}

		return (Fibo(n - 1) + Fibo(n - 2));
	}

	static long[] memo = new long[100];
	
	// 재귀함수
	private static long Fibo_memo(int n) {
		// TODO Auto-generated method stub
		if(n>=2 && memo[n] == 0L) {	//계산 할 필요있음
			return (Fibo(n - 1) + Fibo(n - 2));			
		}
		return memo[n];
	}

	static long[] arr = new long[100];

	// DP (배열 이용)
	private static long Fibo_DP(int n) {
		int result = 0;
		arr[0] = 0;
		arr[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
	// DP2 (swap 이용) / 메모이제이션 X
	private static long Fibo_DP2(int n) {
		long a = 0;
		long b = 1;
		for (int i = 2; i<=n; i++) {
			long temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}
}
