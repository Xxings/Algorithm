package algo.study;
/**
 * SubSet : 어떤 집합의 모든 부분집합을 원소로 하는 집합
 * {1,2} 의 subset은
 *  {{}, {1}, {2}, {1,2}}
 */
import java.util.Arrays;
import java.util.Random;

public class Z10_Subset {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = {-7, -3, -2, 5, 8};
//		int[] arr = {-7, -3, -2};
		
		
		//원소 사용여부 | 비트 만들기 <- 갯수만큼 해야하니 좀 그렇다.
//		for (int first_num = 0; first_num < 2; first_num++) {	//첫번째 원소 사용할지 여부
//			for (int second_num = 0; second_num < 2; second_num++) {	//두번째 원소
//				for (int third_num = 0; third_num < 2; third_num++) {	//세번째 원소
////					System.out.println(first_num + "," + second_num +"," + third_num);	// 0, 1, 0 etc
//					System.out.printf(first_num == 1 ? arr[0]+" ": " ");
//					System.out.printf(second_num == 1 ? arr[1]+" ": " ");
//					System.out.printf(third_num == 1 ? arr[2]+" ": " ");
//					System.out.println();
//				}
//			}
//		}	
		
		//바이너리 카운팅 | 2진수를 활용해서 부분 집합을 구한다.
		/*	000~001 
		 * 	010~011
		 */
		/*
		 * i & 001 // 1 << 0 : (1) i & 010 // 1 << 1 : (2) i & 100 // 1 << 2 : (4)
		 */
		for (int loop = 0; loop < (1 << arr.length); loop++) { // 1<<3 == 8 == subset의 원소 개수

			for (int bitmasking = 0; bitmasking < arr.length; bitmasking++) {
				if ((loop & (1 << bitmasking)) != 0) // i 값의 j번째 비트를 가져오기
					System.out.printf(arr[bitmasking] + ",");
			}
			System.out.println();

		}
		
		System.out.println(1234); // 10진수 0~9
		System.out.println(0b10); // 2진수 0~1
		System.out.println(0171); // 8진수 0~7
		System.out.println(0xB1); // 16진수 0~9|A,B,C,D,E,F]
		System.out.println(Integer.toBinaryString(100));	//iny -> binary
		System.out.println(Integer.toString(100,2));	// 변환할 진법을 직접 표기하여 출력해주는 메서드
		
		int n = 0b110101;
		System.out.print(n & 0b1);			//1
		System.out.print(n & 0b10);			//0
		System.out.print(n & 0b100);		//1
		System.out.print(n & 0b1000);		//0
		System.out.println("\n//////////////////////");
		/* 부분집합을 구하는 3가지 방법
		 *  1. 반복문 중첩
		 *  2. 바이너리 카운팅
		 *  3. 재귀함수
		 */ 
		int v = 1;
		for (int i = 1; i <= 4; i++)
			v *= i;
		System.out.println(v);
		// -> 재귀
		System.out.println(factorial(4));
		
		//0 2 4 6 8
		for (int i = 0; i < 9; i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
		c(0);
		
		System.out.println("//// 재귀함수로 부분집합 출력");
//		
		subset(0);
		
	}
	
	public static int[] brr = {-7, -3, -2};
	public static boolean[] bit = new boolean[brr.length];
	
	/** 매개변수 n 번째 인덱스의 배열값을 사용할지 여부를 지정 후 */
	public static void subset(int n) {
		if(n == brr.length) {	//종료파트 : bit 배열의 내용을 보고, brr 배열의 원소를 출력해서 부분집합을 구함
			for (int i = 0; i < bit.length; i++) {
				System.out.print(bit[i] ? brr[i]+ " " : "");
			}
		}else {
			//재귀파트 : bit 배열에 각 원소를 사용할지 여부 넣기
			bit[n] = false;
			subset(n+1);
			bit[n] = true;
			subset(n+1);
		}
	}
	
	public static void c(int n) {
		if(n>=8) {	//종료파트
			System.out.println(n);
			return;
			
		}else {	//재귀파트
			System.out.print(n+" ");
			c(n+2);
		}
	}
	//3.
	public static int factorial(int n) {
		if(n==1) {	//종료파트
			return 1;
		}else {	//재귀파트
//			System.out.println(n*factorial(n-1));
			return n * factorial(n-1);
		}
	}
	
	private void print_subset(int[] result, int idx, int lenght) {
		if(idx==lenght-1)
			System.out.println(Arrays.toString(result));
		
	}
}
