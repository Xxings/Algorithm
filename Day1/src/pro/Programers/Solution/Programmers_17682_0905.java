package pro.Programers.Solution;

public class Programmers_17682_0905 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String dartResult = "1D2S0T";
		System.out.println(test.solution(dartResult));
	}

	static class Solution {
		public int solution(String dartResult) {
			// 스택 만들기[게임](3개)
			int[] stack = new int[3];
			int topidx = -1;

			// 1S 2D 3T Math.pow(n,1)~(n,3)
			// 뒤에 나온다.
			// *는 스택으로 확인 (x2) | 처음에도 나올경우 비어있는경우 체크
			
			// #도 스택으로 확인
			// 문자열처리 시작
			// 숫자 // 문자 // 특수문자느낌
			StringBuilder sb = new StringBuilder();
			for (char a : dartResult.toCharArray()) {
				// 숫자
				if (a >= '0' && a <= '9') {
					sb.append(a);
				}
				// 문자
				else if(a >= 'A' && a <= 'T') {
					stack[++topidx] = Integer.parseInt(sb.toString());
					sb.setLength(0); //초기화
					int data = stack[topidx];	//peek();
					switch(a) {
					case 'S' :
						break;
					case 'D' :
						stack[topidx] = (int)Math.pow(data, 2);
						break;
					case 'T' :
						stack[topidx] = (int)Math.pow(data, 3);
						break;
					default :
						System.out.println("no");
					}
				} // end of 문자
				// 특수문자
				else {
					if(a == '*') {
						stack[topidx] *= 2;
						if(topidx != 0) {
							stack[topidx-1] *= 2;
						}
					}
					else {	//#
						stack[topidx] = -stack[topidx];
					}
				}
			}

			int answer = 0;
			while(topidx != -1) {	//pop
				answer += stack[topidx--];
			}
			return answer;
		}
	}
}
