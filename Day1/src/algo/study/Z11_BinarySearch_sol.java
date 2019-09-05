package algo.study;
import java.util.Arrays;

/*	{퀵}{정렬}
 *  이진 검색 : 정렬이 되어 있는 집합에서 원하는 키를 검색하는 방법
 *  1. 반복문
 *  2. Arrays.binarySearch()
 *  3. 재귀함수
 */
public class Z11_BinarySearch_sol {
	public static int a[] = {1,2,3,4,5,6,7,8,9};
	public static int key = 8;
	public static void main(String[] args) {
		int start = 0;
		int end = a.length-1;
		boolean flag=false;
		while (start <= end) {
			int mid = (start+end)/2;		// int mid = (low + high) >>> 1;
			if (a[mid]==key) {//찾는 값이냐?!
				System.out.println("찾았따 || idx :"+mid);
				flag = true;
				break;
			}else if(a[mid]>key){	//작은 쪽이니
				end = mid - 1;
			}else {		//큰쪽이니?
				start = mid + 1;
			}
		}
		if(!flag)
			System.out.println("못 찾았따 || idx : -1");
		
		
		// Arrays.binarySearch(a, key) :
		System.out.println(Arrays.binarySearch(a, key));
		
		
		int result = BinearySearch(0,a.length-1);
		System.out.println((result>0)?"찾았따 || idx : "+result:"못찾았따 || idx : "+result);
	}
	private static int BinearySearch(int start, int end) {
		// TODO Auto-generated method stub
		int mid = (start+end)/2;
		if(start > end)
			return -1;
		if(a[mid]>key) {
			return BinearySearch(start, a[mid]-1);
		}else if(a[mid]<key) {
			return BinearySearch(a[mid]+1, end);
		}else
			return mid;
	}
}
