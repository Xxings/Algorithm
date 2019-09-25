/*
96,856 kb
메모리
716 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.IOException;
import java.util.Scanner;

public class sw_4796_0924 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
//		int T = stoi(br.readLine());
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			int ans=0;
			sb.append("#").append(Tcase).append(" ");
			//오름차순 //내림차순
			int N = sc.nextInt();
			int[] dataSet = new int[N];
			for (int count = 0; count < N; count++) {
				dataSet[count] = sc.nextInt();
			}
			
			//시작상태 0 //오름차순 1// 내림차순 2
			int swit = 0;
			int leftIdx = 0;
			int rightIdx = 0;
			int midIdx = 0;
			int preData = dataSet[0];
			int hi;
			for (int idx = 1; idx < dataSet.length; idx++) {
				hi = dataSet[idx];
				if(preData < hi) { //오름차순 1
					if(swit == 2) {
						rightIdx = idx-1;
						ans += (midIdx-leftIdx)*(rightIdx-midIdx);
						leftIdx = idx-1;
					}
					swit = 1;
					
				}
				//같은경우 고려 안함
				else {//내림차순 2
					if(swit == 1) midIdx = idx-1;
					
					swit = 2;
					if(idx == dataSet.length-1){
						rightIdx = idx;
						ans += (midIdx-leftIdx)*(rightIdx-midIdx);
					}
				}
				preData = hi;
			}
			
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
