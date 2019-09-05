package algo.study;

import java.util.Arrays;

public class Z33_Comb {
	public static int[] arr = { 6, 7, 8, 9 };
	public static int[] trr; // 임시배열

	public static void main(String[] args) {

		int n = arr.length;
		int r = 3;
		trr = new int[r];
		Comb(n, r);

	} // end of main

	private static void Comb(int n, int r) {
		// TODO Auto-generated method stub
		if (r == 0) {
			System.out.println(Arrays.toString(trr));
			return;
		} else if (n < r) {
			return;
		} else {
//			for (int i = cnt-3; i < arr.length; i++) {
//				trr[cnt] = arr[i];
//				Comb(dx,cnt-1);
//			}
			trr[r - 1] = arr[n - 1];
			Comb(n - 1, r - 1);
			Comb(n - 1, r);

		}
	}
}
