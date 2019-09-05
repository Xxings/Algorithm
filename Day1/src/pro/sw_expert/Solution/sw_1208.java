/*
JAVA
25,072 kb
180 ms
773
*/
/* 일반 expert case에 대해서는 Runtime error가 안뜨지만,
 * 주신 테스트케이스에 대해서 Runtime error가 뜹니다.
 * (해당 정답은 나타납니다.) 
 * 
 * 
 */
package pro.sw_expert.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class sw_1208 {
	
	public static void main(String[] args) {
		int width = 100;	//가로길이
		Scanner sc = new Scanner(System.in);
		int[] arr;
		//TESTCASE
		for (int i = 1; i <= 10; i++) {	
			int dump = sc.nextInt();	//dump
			
			arr = new int[width];		//초기화

			//값 입력
			for (int j = 0; j < width; j++) {
				arr[j]=sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			for (int loop = dump; loop > 0; loop--) {
				if(arr[width-1]-arr[0] <= 0)
					break;
				arr[width-1]--;	//최대값 -1
				arr[0]++;		//최소값 +1
				
				if(arr[width-1]<arr[width-2] || arr[0]>arr[1])
					Arrays.sort(arr);
			}
			Arrays.sort(arr);
			System.out.println("#"+i+" "+(arr[width-1]-arr[0]));
		}	
	}
}
