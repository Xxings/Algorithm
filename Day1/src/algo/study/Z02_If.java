package algo.study;

/**
 * 자바의 흐름제어 : if~else, switch~case, 삼항 연산자( )?  
 * 
 *
 */
public class Z02_If {
	public static void main(String[] args) {
	Long 조건식 = 1L;	
	
		if(조건식==1L) System.out.println(조건식); //조건식은 boolean 타입만
	
	
	int num = 8;
	if(num == 10 | num == 9) 	System.out.println("수");
	else if(num == 8) 			System.out.println("우");
	else if(num == 7) 			System.out.println("미");
	else 						System.out.println("가");
	
	num = -3;
	System.out.println(num>=0? num : -num);		// 삼항연산자
	System.out.println(Math.abs(num));	//Math 클래스 사용

	//	unsigned int a = 1234567890;	//자바는 unsigned가 없음
//	public long unsigned32 (int num) {
//		return a&0xFFFFFFFFL;			//8빗 더해서 long타입으로 시작
//	}
	
	num = 78;
	//90, 80 70  가
	switch(num/10) {	// 조건값 : int범위 이하의 정수 | string 문자열
	case 10 :		//label (분기시에만 의미가 있다.)
	case 9 :		//label (분기시에만 의미가 있다.)
		System.out.println('수');
		break;
	case 8 :		//label (분기시에만 의미가 있다.)
		System.out.println('우');
		break;
	case 7 :		//label (분기시에만 의미가 있다.)
		System.out.println('미');
		break;
	default :		//모든 case 절이 동일한 값이 없을 경우.
		System.out.println('가');
		break;
			}
	
	//문자열 String 클래스로 표현 가능 (참조형 변수)
	String s = " ";		// <- 권장
	String s2 = new String("abc");
	
	switch ("바나나") {
	case "바나나":
		System.out.println("banana");
		break;
	case "사과":
		System.out.println("apple");
		break;
	default:
		System.out.println("그런단어 없음");
		break;
	}
	double a = 7/3;	//int
	System.out.println(a == (int)a); //????????????
	}	// end main
}	// end class
