package pro.Programers.Solution;

public class Programers_17681_0905 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 5;
		int[] arr1 = new int[] {9, 20, 28, 18, 11};
		int[] arr2 = new int[] {30, 1, 21, 17, 28};
		test.solution(n, arr1, arr2);
	}

	static class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];
			StringBuilder sb = new StringBuilder();
			int cmp1;
			int cmp2;
			int temp;
			for (int row = 0; row < n; row++) {
				cmp1 = arr1[row];
				cmp2 = arr2[row];
				for (int i = n - 1; i >= 0; i--) { // 비트연산
					temp = (1<<i);
					if(	(temp & cmp1) >0
							||	(temp & cmp2) >0
							) {
						sb.append('#');
						System.out.print('#');
					}
					else {
						sb.append(' ');
						System.out.print(' ');
					}
				}
				answer[row] = sb.toString();
				sb.setLength(0);//초기화
				System.out.println();
			}
			return answer;
		}
	}
}
