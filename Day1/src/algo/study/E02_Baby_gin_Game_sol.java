package algo.study;
import java.util.Arrays;
import java.util.Scanner;

/**
 * BruteForce : 완전탐색 : 모든 원소를 빠짐없이 순회하는 작업
 * 		장점 : 반드시!! 해를 구할 수 있다. 
 * 		단점 : 시간이 많이 걸린다.
 *
 *	자격검정평가 등에서 주어진 문제를 풀 때,
 *	우선 완전 검색으로 접근하여 해답을 도출한 후, 
 *	성능 개선을 위해 다른 알고리즘을 사용하고 해답을 확인하는 것이 바람직하다. [따라서 탐색을..]
 */
public class E02_Baby_gin_Game_sol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int NUM = 6;
		int[] input_case = new int[NUM];

		// 입력부
		for (int i = 0; i < NUM; i++) {
			input_case[i] = sc.nextInt();
		}
		
		// 계산부 // 카운팅
		int[] cnt = new int[10];	//0~9
		for(int i : input_case)
			cnt[i]++;
		
		//flag (run/flag)
		int flag = 0;			// if flag == 2 -> Baby_gin
		
		//triple
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i]>=3) {
				cnt[i]-=3;
				flag++;
			}
		}
		
		//run
		for (int i = 0; i < cnt.length-2; i++) {
			//끝나는 조건
			if(cnt[i+1]==0 || cnt[i+2]==0)
				break;
			//되는 조건
//			if(cnt[i+1])
		}
		
	}
}
