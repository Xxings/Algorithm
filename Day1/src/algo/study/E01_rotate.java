package algo.study;
import java.util.Arrays;

public class E01_rotate {
	public static void main(String[] args) {
		
		//가로 / 세로
		int[] arr = {7,4,2,0,0,6,0,7,0};
//		int[] arr = {0,4,2,0,0,6,0,7,0};
		
		int[] cnt = new int[arr.length+1];			//높이 숫자 cnt |1부터 시작 // 들어가는게 가로
		int[] arr_idx = new int[arr.length+1];		//인덱스 카운트 숫자
		
//		Arrays.fill(arr_idx,-1);
		
		for(int i=0; i<arr.length; i++) {
			int data = arr[i];
			
			for(int j = 1; j<=data; j++) {
				cnt[j] += 1;
				
			}
			if(arr_idx[data] == 0 ) {		//최초 idx 넣기 (차별을 두기위해 0대신 +1로)
				arr_idx[data] = i+1; 		//[4, 0, 3, 0, 2, 0, 6, 1, 0, 0] -> 0이 들어간 처음은 4번째(arr[3])
			}
		}
		
		/*
		 * 	[7, 4, 2, 0, 0, 6, 0, 7, 0]
			[0, 5, 5, 4, 4, 3, 3, 2, 0, 0]
			[4, 0, 3, 0, 2, 0, 6, 1, 0, 0]

		 */
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(cnt));
		System.out.println(Arrays.toString(arr_idx));
		
		int max = Integer.MIN_VALUE;
		for(int i = arr.length-1; i>0; i--) {
			if(arr_idx[i]==0)
				continue;
			int calc = arr.length - (arr_idx[i] - 1) - cnt[i]; 	// 전체 - 그 위치의 현재 갯수(저장을 +1로 함) - 인덱스 
			if(calc>max)
				max = calc;
		}
		System.out.println(max);
	}
}
