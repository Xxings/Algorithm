//ERROR : StackoverFlow

package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_7584_sol {
	static long N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			N = Long.parseLong(br.readLine());
			long p = 1;
			while((1L<<p)<N) {
				p++;
//				System.out.println(p);
			}
//			System.out.println(p);
			
			int result = Check(0,1,1<<p);
			System.out.printf("#%d %d \n", Tcase, result);
		}
	} //end of main

	private static int Check(int k, long left, long right) {
		// TODO Auto-generated method stub
		long mid = (left+right)/2L;
		if(mid == N)
			return k;
		else if(mid > N) {
			right = mid-1;
			return Check(0,left,right);
		}
		else {
			left = mid+1;
			return Check(1,left,right);
		}
	}
}
