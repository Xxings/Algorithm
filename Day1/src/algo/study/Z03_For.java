package algo.study;

/**
 * 자바의 반복문 : for while do~while
 * 
 * python for : (generator 생성가능)
 */
public class Z03_For {
	public static void main(String[] args) {
//		for (초기식 ; 조건식 ; 증감식) {
//		}
		
		String s = 3 + 7 + "hi" + 3 + 7;	//문자열과 비문자열 -> 문자열
		for (int i = 0; i < 3; i++) {
			System.out.println(s);
		}
		
		for (int i = 2; i < 10; i+=2) {
			System.out.print(i);
		}
		System.out.println();
		for (int i = 5; i > 0 ; i--) {
			System.out.print(i);
		}
		System.out.println();
		
		//숫자 합 구하기
		int sum = 0;
		for (int i = 1; i<=10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//		int st=1, dt=10, jump = 2;
//		
//		//숫자합구하기 2
//		System.out.println(
//					(st+dt)*(dt)/2
//				);
		
		int max = 0;
		int a = 3;
		int b = 7;
		int c = 6;
		
		max=(a>b)?
		 (a>c?a:c)
		:(b>c?b:c);
		
//		if(max<a) max = a;
//		if(max<b) max = b;
//		if(max<c) max = c;
		System.out.println(max);
		
//		while(조건식) {
//			반복할 실행문;
//			증감식
//		}
		int loop = 1;
		while(loop<=5) {System.out.println(loop); loop+=1;}
		int f =1;
		do {
			System.out.print(f+" ");
		} while (f<=5);
		
		// break : 가장 가까운 switch~case | 반복문 빠져나옴
		// Continue : 가장 가까운  반복문 계속
		// Label : 분기시에 분기할 지점 
		
		System.out.println("--------------------");
x:		for(int i = 0; i<3;i++) {
			for(int j = 0; j<3;j++) {
				if(i==2)
					break x;
				System.out.println(i+" "+j);
			}
		}
	}	// end of main
}	// end of class
