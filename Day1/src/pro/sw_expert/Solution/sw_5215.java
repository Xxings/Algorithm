/*
24,232 kb
메모리
229 ms
실행시간
869
코드길이
 * 
 */

package pro.sw_expert.Solution;
import java.util.Scanner;
public class sw_5215{
	static int[] taste;
	static int[] kalori;
	static int N;
	static int L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			//TESTCASE 시작
			N = sc.nextInt();
			L = sc.nextInt();
			
			taste = new int[N];
			kalori = new int[N];
			
			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				kalori[i] = sc.nextInt();
			}
			System.out.println("#"+Tcase+" "+branch(0,0,0));
			
		} 
		
	}
	public static int branch(int T_tasts, int T_kalori, int start) {
		if(T_kalori>L)
			return T_tasts-taste[start-1];
		if(start==N)
			return T_tasts;
		
		return (Math.max(
					branch(T_tasts+taste[start], T_kalori+kalori[start], start+1)
					,branch(T_tasts, T_kalori, start+1)));
	}
}