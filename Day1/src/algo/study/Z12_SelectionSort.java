package algo.study;
import java.util.Arrays;

/**
 * 정렬 Sort
 * 
 * 카운팅 정렬 O[N]
 * 
 * 퀵 정렬 O[NlogN]	
 * -데이터 양이 많아도 빠르게 정리가됨
 * 머지정렬
 * 힙정렬
 * 이진정렬
 * 
 * 버블정렬 O[N^2]
 * 선택정렬
 * 삽입정렬
 * @author student
 *
 */
public class Z12_SelectionSort {
public static void main(String[] args) {
	int[] a = {3,7,5,9,1,2,6,4,8};
	System.out.println("정렬전 :"+Arrays.toString(a));
	// 범위에서 최소값을 찾아서 범위의 맨 앞 자리와 교환
//	 0~끝 0<->최소
//	 1~끝 1<->최소 
//	끝~끝 <-> 최소
	
	for (int target_idx = 0; target_idx < a.length; target_idx++) {
		int min_idx = target_idx;	//최소값이 들어있는 인덱스를 저장
		for (int cmp_idx = target_idx+1; cmp_idx < a.length; cmp_idx++) {
			if(a[min_idx]>a[cmp_idx])
				min_idx = cmp_idx;
		}
		//swap i <-> 최소
		int temp = a[target_idx];
		a[target_idx] = a[min_idx];
		a[min_idx] = temp;
		
	}
	
	System.out.println("정렬후 :"+Arrays.toString(a));
}	// end of main
} // end of class
