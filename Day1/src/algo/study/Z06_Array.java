package algo.study;

import java.util.Arrays;

/**
 * 1차원 배열
 * @author student
 *
 */
public class Z06_Array {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(arr.length);
		System.out.println(arr[1]);//result 2
		
		// 배열 원소의 합
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		sum = 0;
		for(int i:arr) {
			sum += i;
			System.out.print(i+" ");
		}
		System.out.println(sum);
		
		//Arrays : 배열에 관련된 메서드를 구현한 클라스
		System.out.println(Arrays.toString(arr)); //배열의 원소 전체를 문자열로 표현해주는 매서드
		
		//원소를 역순으로 출력
		for(int i = arr.length-1; i >= 0 ; i--)
			System.out.print(arr[i]);
		
		System.out.println();
		
		// 존재 유무
		int[] num = {2,4,6,1,3,5,7};
		int key = 9;
		boolean isIt = false;
		for(int i : num){
			if(key == i) {
				isIt = true;
				break;
			}
		}
		System.out.println((isIt)?"있다":"없다");
		
		// 최대값
		int[] b = {-10,-3,-5};
		// 1. 이세상에서 존재하는 가장 작은 값으로 초기화
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		// 2. 비교하고자 하는 원소들 중 하나의 값으로 초기화
		for(int i : b)
			if(i > max)
				max = i;
		System.out.println(max);
		
		// 빈도수, 3이 몇개인가 / 카운팅 정렬
		int[] c = {3,3,2,1,3,2,1,1,2,3,3,3,2};
		int[] cnt = new int[4];
		for (int i = 0; i < c.length; i++) {
			cnt[c[i]]++;
		}
		System.out.println(Arrays.toString(cnt));
		
		// 카운팅 정렬 :
		//  장점 : 가장 빠른 정렬 알고리즘, 코드도 간결
		//  단점 : 메모리를 많이 사용/ 최대,최소를 알아야한다. (대체 >> 래딕스 정렬 알고리즘)
		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i]; j++){
			    System.out.print(i+" ");
			}
		}
		System.out.println(" ");
		
		
		// 2차원 배열 각 1차원 원소의 합
		
		int[][] drr = {{1,2,3},{4,5,6},{7,8,9}};
		for (int i = 0; i < drr.length; i++) {
			int Tsum = 0;
			for(int j : drr[i]) {
				Tsum += j;
			}
			System.out.println("#"+i+" "+Tsum);
		}
		
	}	// end of main
} // end of class
