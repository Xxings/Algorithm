package pro.sw_expert.Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class sw_8016 {
	static ArrayList<Long> memory = new ArrayList<>();
//	static int[] memory = new int[1000000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		
//		int T = sc.nextInt();
//		int L_result, R_result;
//		int N;
//		for (int i = 1; i <= T; i++) {
//			N = sc.nextInt();	//줄 입력
//			if(N==1)	
//				System.out.println("#"+i+" "+1+" "+1);
//			else {
//				L_result = predict(N);
//				R_result = predict(N+1)-2;
//				System.out.println("#"+i+" "+L_result+" "+R_result);
//			}
//		}
		while(true) {
		int N = sc.nextInt();	//줄 입력
		System.out.println(predict(N));
		}
	} // end of main
	
	// 런타임 에러
	public static long predict(int N) {
		long result;
		if(N==1) {
			memory.add((long) 1);
		}
//		else if(memory.get(N-1) == null)
			memory.add(predict(N-1)+4*N-6L);
		 	
		result = memory.get(N-1);
		return result;
	}
		
//	public static int predict(int N) {
//		if(N==1)
//			return 1;
//		else
//		//N>=2
//			return 3+2*(N-3)*(N-2);
//	}
}
