package algo.study;

public class Z31_진수비트연산 {
	public static void main(String[] args) {
		//2진법 정수 표현 방법
		int binary =21; //21저장하기
		
		//2진수 값을 10진수로 출력1
		System.out.println(binary);
		
		// 10진수 -> x진법 변환1 : 각자리수 연산
		int num = 311;
		int x = 2;		//바꾸고싶은 진법
		String s = ""; //2진법 변환한 문자 저장
		
		//비트 하나하나
//		s += ((num >> 1)&1 )? "1" : "0";
		int result = 1;
		while(true) {
			s = (num&2) + s;
			result <<= 1;	//자리수올림 *2와 동일
			break;
		}
		
		System.out.println(s + "("+x+"진수)");	//x진법으로 바꾼 값 출력
		
		//10진수 -> x진법 변환2 : API 활용
		s = "";	//2진법으로 변환한 문자 저장
		s = ((Integer)num).toBinaryString(num);
		
		System.out.println(s + "("+x+"진수");	//x진법으로 바꾼 값 출력
	}
}
