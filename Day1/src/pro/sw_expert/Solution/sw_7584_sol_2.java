/*
 * 알고리즘 : 규칙 찾기
 * 
 */

package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_7584_sol_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int k = 1;
			int turn=0;
			while(k < N) {
				k=k<<1;
				turn++;
				if(k==N) {
					turn = 1;
					break;
				}
			}
			System.out.println(turn);
			result = (turn%2 == 0) ?1:0;
			System.out.printf("#%d %d \n", Tcase, result);
		}
	}

}
