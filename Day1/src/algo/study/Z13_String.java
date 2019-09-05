package algo.study;
import java.io.InputStreamReader;

public class Z13_String {
//	private final char value[];	//String class (~8)
//	private final byte value[];	//String class (10^)
	
	public static void main(String[] args) {
		String str = "abcDefGhiJ";
		// String의 주요 메서드
		p("글자 길이 :" + str.length());
		p("해당 인덱스의 글자 :" + str.charAt(2));
		p("글자의 앞뒤 공백 제거 : "+str.trim());
		p("해당 문자 있는지 확인"+str.contains("def"));	// 대소문자 구분
		p("대문자로 변환" + str.toLowerCase());
		p("소문자로 변환" + str.toUpperCase());
		p("reference가 동일한지 " + (str == "abcDefGhiJ") );
		p("문자가 동일한지"+str.equals("abcdefghij"));	// 대소문자 구분
		p("대소문자 무시 동일여부" + str.equalsIgnoreCase("abcdefghij"));
		p("글자 변경"+str.replace("Def", "XXX"));
		p("시작되는 인덱스" + str.indexOf("Def"));	//앞부터 찾음
		p("시작되는 인덱스" + str.lastIndexOf("Def"));	//뒤부터 찾음
		p("문자열 추출" + str.substring(3, 6));
		p("문자열 추출" + str.substring(3));
		p(str);	//str은 참조 주소 sysout(str) <=> sysout(str.toString);
		p("char[] 배열화 " + (str.toCharArray() instanceof char[]));	// 내부에 저장된 문자열 배열 가져오기
		// 너무 길 경우 문제풀이시 메모리에 대해서 오류 날 확률 있음
		
//		str.intern();
		
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		p("두개 같니"+(s1==s2));	// 힙에 "abc"문자객체가 생성되고 그대로 가져오기때문에
		p("두개 같니"+(s3==s4));	// 힙에 각자의 문자객체가 생성
		p("두개 같니"+(s3.intern()==s1));	// 힙에 각자의 문자객체가 생성
		
//		p("대소문자 무시 여부 "+str.compareToIgnoreCase("ced")); //대소문자 무시 ?
		str = "abc";
		String str2 = "abcb";
		p("비교 :" + str.compareTo(str2));	//오름차순으로 a,b,c~~~ 확인	// abc > abcd
		//Long Jump   / Short Jump <- 두번연산하니까, 배열에 담아서 // 그런데 자바에서는 차이가 없거나 더 걸릴수도; 
		str = "a" + "a";
		str = "a".concat("a");
		
		//StringBuffer / StringBuilder
		for (int i = 0; i < 100; i++) {
			str += "a";	//문자열 작업이 너무 오래걸림
		}
		
		
//		 * 출력시간 줄이기
//		StringBuffer : 멀티 쓰레드용 (Synchronized 처리가 되어있다), Builder에 비해 느림
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < 100; i++) {
//			sb.append("a");
//		}
		
		//StringBuilder : 싱글 쓰레드용, 더 빠름
		//알고리즘 용
		StringBuilder sb = new StringBuilder();
		//String 클래스의 메세드는 실행후 원래 문자열에 변경이 일어나지 않는다 (Final char[])
		str = str.substring(3,7);
		str=str.concat("c").concat("abc");
		
		//String Builder와 StringBuffer는 메서드 실행시 원래 문자열이 변경됨
		
		// case 1 str 뒤집기
		String ss = "123abc";
		char[] arr = ss.toCharArray();
		for (int i = 0; i < ss.length()/2; i++) {
			char temp = arr[i]; 
			
		}
		StringBuilder sbb = new StringBuilder(ss);
		sbb.reverse();	//글자열 뒤집기!
		System.out.println(sbb);
		System.out.println(new StringBuilder(ss).reverse());
		
		
		
	} // end of main
	public static void p (String str) {
		System.out.println(str);
	}
}

