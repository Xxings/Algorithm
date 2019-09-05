package algo.study;

import javax.crypto.CipherInputStream;
import javax.print.DocFlavor.INPUT_STREAM;

public class Z01_Variable {
	public static void main(String[] args) {
		//변수 : 기본형, 참조형
		/** 기본형 : 크기가 약속되어 있는 변수 타입 **/
//		정수형 : byte[1], short[2], (int)[4], long[8]
//		실수형 : float[4], (double)[8]
//		문자형 : char[2]	//C언어는 1byte java는 2byte
//		논리형 : boolean[1]	//bit 처리보다 byte처리가 더 빠름
		
		/** 참조형 : 기본형 타입이 아닌 나머지 모두 참조형 타입 **/
				
		byte a = 3;		// 변수 선언부 / 초기화
		short b = 4;
		int c = 5;		// -2^31 ~ 0 ~ 2^31-1 [21억정도]
		
		long d = 12345678901L;		// 리터럴 접미사(기본값은 int 이기때문에)
		float e = 3.141592F;		// 리터럴 접미사(기본값은 double 이기때문에)
		double f = 3.141592D;		// 리터럴 접미사
		
		System.out.println(e);
		
		char g = '뛇';	//하나의 문자를 표현 (2byte라서) / 빈값 안됨.
		boolean h = true;	//참  true, 거짓 false
//		boolean h;			//변수명은 중복되면 안됨 (Duplicate local)
		
		/*	*	*/
		int x = 3;		//변수에는 하나의 데이터만 저장 가능
		x = 4;			//마지막에 저장된 데이터로 덮어씀
		System.out.println(x);
		
		//Quiz
		int p = 5;
		int q = 7;
		
//		swap
//		int temp = q;
//		q = p;
//		p = temp;
		
//		버퍼없이(비트연산자)
//		p = p^q;
//		q = q^p;
//		p = p^q;
		
		p = p+q;
		q = p-q;
		p = p-q;
		System.out.println(p);
		System.out.println(q);
		
	}	// end of main
}	// end of class
