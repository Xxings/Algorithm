package algo.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Z31_연습문제2 {
	public static void main(String[] args) {
		Integer[] arr= {69, 10, 30, 2, 16, 8, 31, 22}; // 10개 0~9	
		List<Integer> ll = new ArrayList<>(Arrays.asList(arr));	//배열의 원소를 리스트 객체로 추가
		
		System.out.println(mergeSort(ll));
		
	}

	private static List<Integer> mergeSort(List<Integer> ll) {
		// TODO Auto-generated method stub
		if(ll.size() <= 1) {	//종료파트
			return ll;
		}
		else {
			int m = ll.size() / 2 ; 	//중간위치
			List<Integer> left = mergeSort(ll.subList(0, m));
			List<Integer> right = mergeSort(ll.subList(m, ll.size()));
			return merge(left,right);	//두 리스트 병합
		}
	}
	/** 두 리스트를 정렬 상태로 병합하는 메서드 */
	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>(left.size() + right.size()); //합쳐서 저장할 리스트 객체
		int lx = 0;
		int rx = 0;
		while(lx < left.size() && rx < right.size()) {
			if(left.get(lx)<right.get(rx)) {
				result.add(left.get(lx++));
			}
			else {
				result.add(right.get(rx++));				
			}
		}
		
		//둘중 하나라도 끝나면, 남은 원소 빼서 뒤에 붙여주기
		while(lx < left.size()) {	//왼쪽만 남아있음
			result.add(left.get(lx++));
		}
		while(rx < right.size()) {	//왼쪽만 남아있음
			result.add(right.get(rx++));
		}
		return result;
	}
}
