package algo.study;

import java.util.Scanner;

public class Z05_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//키보드로부터 입력을 받아오겠다고 선언
		System.out.println("이름을 입력하세요");
		String name=sc.next();					//문자열을 받아옴
	
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		
		System.out.println(name);		
		System.out.println(age);
	}	// end of main
}	// end of class
