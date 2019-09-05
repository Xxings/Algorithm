package algo.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Z28_InsertSort {
	public static void main(String[] args) {
		int[] arr = new int [3_000];
		Random ran = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		
		long time = System.currentTimeMillis();
//		//배열 swap으로 200_000개 정렬 (12824ms)
//		for(int i = 1; i< arr.length; i++) {
//			for (int j = i-1; j >= 0 && arr[j] > data; j--) {
//				int temp = arr[j];
//				arr[j] = arr[j+1];
//				arr[j+1] = temp;
//			}
//		}
		
		
		//선택 정렬 
		///배열 swap안하고, 끝 원소를 저장했다가 넣기 (8763ms)
//		for(int i = 1; i<arr.length; i++) {
//			int data =arr[i];
//			int j;
//			for (j = i-1; j >= 0 && arr[j] > data; j--) {	//0~i-1 범위의 뒤쪽부터 큰값이면 바꾸기
//				 arr[j+1] = arr[j];
//			}
//			arr[j+1] = data;
//		}
		
		/// 배열 swap 안하고, 배열 옮길거 통쨰로 이동 (5408ms)
//		for(int i=1; i < arr.length; i++) {
//			int data = arr[i];	//삽입할 대상 저장해두기
//			int j;
//			for (j = i-1; j >= 0 && arr[j] > data; j--) {	//0~i-1 범위의 뒤쪽부터 큰값이면 바꾸기
//			}
//			System.arraycopy(arr, j+1, arr, j+2, i-1-j);			
//		}
		
		////////////LinkedList와 ArrayList
//		LinkedList<Integer> ll = new LinkedList<>(); //	(2188ms)	접근성이 너무 취약하다
		ArrayList<Integer> ll = new ArrayList<>();	//(12ms)	비순차적 검색이지만 접근성에 좋다.
		
		for(int i = 0; i<arr.length; i++) {
			int j = 0;
			for(; j<i && arr[i]<ll.get(j); j++) {				
			}
			ll.add(j, arr[i]);
		}
		
		
		
		long end = System.currentTimeMillis();
		System.out.println(end-time+"ms");
	}
		
		
		
	}

