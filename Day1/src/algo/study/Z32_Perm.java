package algo.study;

import java.util.Arrays;

public class Z32_Perm {
	public static int[] arr = {6,7,8,9};
	public static void main(String[] args) {
		perm(0);
	}
	static int cnt = 1;
	private static void perm(int k) {	//K는 현재단계
		// TODO Auto-generated method stub
		if(k == arr.length) {//종료파트
			System.out.println(cnt+" | "+Arrays.toString(arr));
			cnt++;
		}else {	// 재귀파트
			for (int i = k; i < arr.length; i++) {
				//k <-> i
				//swap;
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				System.out.println("#"+cnt+" add"+Arrays.toString(arr));
				perm(k+1);
				//k <-> i 원상복귀
				//swap;
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				System.out.println("#"+cnt+" reverse"+Arrays.toString(arr));
			}
		}
	}
}
