package algo.study;

public class E01_rotate_sol {
	public static void main(String[] args) {
		int[] arr = {3,4,2,0,0,6,0,7,0};
		int maxCnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int cnt = 0; //낙차의 개수
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j])
					cnt++;
			}
			if (maxCnt < cnt) maxCnt = cnt;
		}
		System.out.println("최대 낙차 : "+maxCnt);
	}
}
