package algo.study;

/**
 * 1차원 배열 : 같은 타입 변수들의 묶음
 * 2차원 배열 : 1차원 배열들의 묶음
 *
 */
public class Z04_Array {
	public static void main(String[] args) {
		int a = 3;
		
		int [] arr; //배열 변수 선언 (참조형)
		arr = new int[3];
		arr[0] = 6;
		arr[1] = 7;
		arr[2] = 8;
		System.out.println(arr[2]);
		
		int[] brr = new int[3];
		int[] crr = {6,7,'1'};			//배열에서 객체 생성을 쉽게
//		System.out.println(crr[2]);		//result : 49
		int[] drr = new int[] {6,7,8}; 	//익명 배열 사용시
		
		int[][] err = {
				{1,2,3},
				{4,5,6}
				};
		
		int[][] frr = new int[2][3];
		System.out.println(err.length); //result : 2
		System.out.println(err[0].length); //result : 2
	}	// end of main
}	// end of class

