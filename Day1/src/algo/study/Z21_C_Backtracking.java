package algo.study;
/*
 * Backtracking 가지치기
 * 	유망하지 않은 경우 가지치기하여 실행속도를 개선
 */
public class Z21_C_Backtracking {
	static int[] arr = {1, 3, 5};	//부분집합을 구하고자 하는 원래 배열
	public static void main(String[] args) {
		//arr 배열의 모든 부분 집합을 출력 powerset
		boolean[] chkarr = new boolean[arr.length];	//arr 배열의 원소를 사용할지 여부를 지정, 0번째도 사용함
		
		backtrack(chkarr, 0, chkarr.length);
		
		
	}	//end of main
	
	/**
	 * 재귀 함수
	 * @param chkarr : arr 배열의 원소를 사용할지 여부 지정
	 * @param i
	 * @param length
	 */
	private static void backtrack(boolean[] chkarr, int i, int length) {
		// TODO Auto-generated method stub
		if(i == length) {		//종료 파트 (isSolution)
			process_solution(chkarr,i);
//			for (int j = 0; j < chkarr.length; j++) {	//
//				if(chkarr[j])
//					System.out.print(arr[j] + " ");
//			}
//			System.out.println();
			return;
		}
		else {	//재귀파트, 후보군을 지정해서, 각각 재귀호출
			boolean[] c = new boolean[chkarr.length];
			int ncands = make_candidates(chkarr,i,length,c);	//후보군 만들어오기

			for(int loop = 0; loop < ncands; loop++) {
				chkarr[i] = c[loop];
				backtrack(chkarr, i+1, length);
			}
//			backtrack(chkarr,i+1,length);
//			chkarr[i] = true;
//			backtrack(chkarr,i+1,length);
//			chkarr[i] = false;
		}
	} // end of backtrack

	private static void process_solution(boolean[] chkarr, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < chkarr.length; j++) {	//
			if(chkarr[j])
				System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	private static int make_candidates(boolean[] chkarr, int i, int length, boolean[] c) {
		// TODO Auto-generated method stub
		c[0] = true;
		c[1] = false;
		return 2;	//후보군의 개수
	}
	
	
	
}
