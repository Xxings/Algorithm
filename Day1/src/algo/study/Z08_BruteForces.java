package algo.study;
import java.util.Arrays;

/**
 * BruteForce : 완전탐색 : 모든 원소를 빠짐없이 순회하는 작업
 * 		장점 : 반드시!! 해를 구할 수 있다. 
 * 		단점 : 시간이 많이 걸린다.
 *
 *	자격검정평가 등에서 주어진 문제를 풀 때,
 *	우선 완전 검색으로 접근하여 해답을 도출한 후, 
 *	성능 개선을 위해 다른 알고리즘을 사용하고 해답을 확인하는 것이 바람직하다. [따라서 탐색을..]
 */
public class Z08_BruteForces {
	public static void main(String[] args) {
		/* 순열 모든 원소 순열 출력 */
		int[] a = {1,2,3};
		
		for(int i = 0; i < 3; i++){	//첫번째 나올 숫자
			for(int j = 0; j < 3; j++){	//두번째 나올 숫자
				if(i==j) continue;
				for(int k = 0; k < 3; k++) {	//3번째 나올 숫자
					if(k==i || k==j) continue;
					System.out.println(a[i]+" "+a[j]+" "+a[k]);
				}
			}
		}	// p개 뽑아서 조합 / O(n^P)
			//따라서, 재귀함수의 필요성 : 하나의 코드로 여러 원소 개수의 순열/조합을 출력 할 수 있다.
		
		//버블정렬
		int[] buble = {55, 7, 78, 12, 42};
		/* 0~4		0~i
		 * 	0-1		j~j+1
		 * 	1-2
		 * 	2-3
		 * 	3-4
		 * 0~3		0~i-1
		 * 	0-1
		 * 	1-2
		 * 	2-3
		 * 0~2		0~i-2
		 * 	0-1
		 * 	1-2
		 * 0~1		0~i-3
		 * 	0~1
		 */
		for (int i = buble.length-1; i > 0 ; i--) {	//미 정렬된 범위의 끝 숫자
			for (int j = 0; j < i; j++) {			//j는 비교할 원소
				if(buble[j+1]>buble[j]) {			//작은 것은 앞 / 큰것은 뒤 (SWAP)
					int temp = buble[j+1];
					buble[j+1] = buble[j];
					buble[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(buble));
		
		int[] c = {55,7,78,12,42}; 	//0~4
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		
		//	buble sort[O(n^2)] "VS[< 빠름]" Arrays.sort(Quick Sort) [O(nLogn)]
	}
}
