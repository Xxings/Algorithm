package algo.study;

import java.util.Arrays;

public class Z33_선택정렬_재귀 {
	public static void main(String[] args) {
		int arr[] = { 10, 9, 8, 7, 8, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(arr));

		sort(0, 0, 1, arr);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int start, int idx, int cmp, int[] arr) {
		// TODO Auto-generated method stub
		if (start == arr.length)
			return;

		else if (cmp == arr.length) {
			int temp = arr[start];
			arr[start] = arr[idx];
			arr[idx] = temp;
			sort(start + 1, start + 1, start + 2, arr);
		} else {
			if (arr[idx] > arr[cmp]) {
				idx = cmp;
			}

			sort(start, idx, cmp + 1, arr);

		}
	}
}
