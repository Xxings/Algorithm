package algo.study;
/**
 * Gravity
 * Remodel - 우측 O(n^2)
 * 그리드 알고리즘 문제
 */

import java.util.Arrays;

public class E01_rotate_RE {
	public static void main(String[] args) {
//		int[] arr = {7,4,2,0,0,6,0,7,0};
//		int[] arr = {3,4,2,0,0,6,0,7};
//		int[] arr = {1,1,6,3,7,6,0,0};
		int[] arr = {3,4,2,0,0,6,0,7,0};
		int[] cnt = new int[arr.length+1];
		int[] sub = new int[arr.length+1];
		
		for(int i : arr) {
			for(int loop=1; loop<=i; loop++ ) {
				sub[loop] += 1;
				if (cnt[loop]==0)
					cnt[loop]=1;
			}	
			for(int j=1; j<cnt.length; j++) {	//숫자 자동증감
				if(cnt[j]>0)
					cnt[j]++;
			}
		}
		System.out.println("길이 : " + Arrays.toString(cnt));
		System.out.println("갯수 : " + Arrays.toString(sub));
		int max = Integer.MIN_VALUE;
		for (int loop = 1; loop < arr.length+1; loop++) {
			int calc = cnt[loop]-sub[loop]-1;
			if(max < calc)
				max = calc;
		}
		System.out.println(max);
	}	//end of main
}	//end of class
