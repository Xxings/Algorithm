package algo.study;

public class Z22_P_Backtracking {
	/*
	 * Backtracking 가지치기 유망하지 않은 경우 가지치기하여 실행속도를 개선
	 */
	static int[] arr = { 1, 3, 5 }; // 부분집합을 구하고자 하는 원래 배열

	public static void main(String[] args) {
		// arr 배열의 모든 부분 집합을 출력 powerset
//			boolean[] chkarr = new boolean[arr.length];	//arr 배열의 원소를 사용할지 여부를 지정, 0번째도 사용함

		int[] chkarr = new int[arr.length]; // 순열을 구하고자하는 원래 배열

		backtrack(chkarr, 0, 2);	//마지막 파라미터는 순열의 만들 원소의 개수

	} // end of main

	/**
	 * 재귀 함수
	 * 
	 * @param chkarr : arr 배열의 원소를 사용할지 여부 지정
	 * @param i
	 * @param length
	 */
	private static void backtrack(int[] chkarr, int i, int length) {
		// TODO Auto-generated method stub
		if (i == length) { // 종료 파트 (isSolution)
			process_solution(chkarr, i);
//				for (int j = 0; j < chkarr.length; j++) {	//
//					if(chkarr[j])
//						System.out.print(arr[j] + " ");
//				}
//				System.out.println();
			return;
		} else { // 재귀파트, 후보군을 지정해서, 각각 재귀호출
			int[] c = new int[chkarr.length]; // 순열에서 사용하지 않는 index를 저장
			int ncands = make_candidates(chkarr, i, length, c); // 후보군 만들어오기

			for (int loop = 0; loop < ncands; loop++) {
				chkarr[i] = c[loop];
				backtrack(chkarr, i + 1, length);
			}
//				backtrack(chkarr,i+1,length);
//				chkarr[i] = true;
//				backtrack(chkarr,i+1,length);
//				chkarr[i] = false;
		}
	} // end of backtrack

	private static void process_solution(int[] chkarr, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < i; j++) { //
//			if(chkarr[j])
				System.out.print(arr[chkarr[j]] + " ");
		}
		System.out.println();
	}

	private static int make_candidates(int[] chkarr, int i, int length, int[] c) {
		// TODO Auto-generated method stub
		boolean[] in_perm = new boolean[chkarr.length];
		int ncands = 0;
		for (int j = 0; j < i; j++) { // 현재 단계 이전까지 사용한 숫자를 체크
			in_perm[chkarr[i]] = true; // 사용한 값을 체크
		}
		// 플래그 변수를 보고, 사용하지 않은 인덱스를 후보군에 넣기
		for (int j = 0; j < in_perm.length; j++) {
			if (!in_perm[j]) {
				c[ncands++] = j;
			}
		}
		return ncands; // 후보군의 개수
	}

}
