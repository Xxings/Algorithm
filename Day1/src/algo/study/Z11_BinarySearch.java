package algo.study;

public class Z11_BinarySearch {
	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6,7,8,9};	//정렬되어있는 상태
		int key = 3;
		
		//1) 반복문 | 이진검색
		int left=0;
		int right=a.length-1;
		int pt = (left+right)/2;	//int mid = (low + high) >>> 1;
		
		boolean is_it = false;
		
		while(true) {
			System.out.print(pt+" ");
			if(left > right)	//못찾았다.
				break;
			
			if(a[pt]==key) {	//키를 찾았다.
				is_it = true;
				break;
			}
			else if (a[pt]<key) {	//우측을 찾아보자
				left = pt+1;
				pt = (left+right)/2;
			}
			else {					//좌측을 찾아보자
				right = pt;
				pt = (left+right)/2;
			}
		}
		
		System.out.printf("\tFOR 탐색결과 : %b",is_it);
		
		System.out.println();
		
		//2) 재귀방법
		binarySearch(a,0,a.length-1,key);
		
	}	//end of main
	private static void binarySearch(int[] arr, int left, int right, int key) {
		int pt = (left+right)/2;
		System.out.printf(pt+" ");
		if(left > right) {	//못찾았다.
			System.out.println("\t재귀 탐색결과 : false");
			return;
		}
		if(arr[pt]==key) {	//키를 찾았다.
			System.out.println("\t재귀 탐색결과 : true");
			return;
		}
		else if (arr[pt]<key) {	//우측을 찾아보기
				left = pt+1;
				binarySearch(arr,left,right,key);
			}
		else {					//좌측을 찾아보자
			right = pt-1;
			binarySearch(arr,left,right,key);
		}
		
	}
}	// end of class
