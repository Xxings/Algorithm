package algo.study;
public class Z11_연습문제2 {
	public static void main(String[] args) {
		int[] arr = {-7, -3, -9, 5,8};
//		int[] arr = {-7, 5};
		
		int temp = 0;
		boolean flag = false;
		//부분집합만들기
		
		for (int i = 1; i < (1<<arr.length); i++) {
			temp = 0;
			for (int bit = 0; bit < arr.length; bit++) {	//공집합제외
				if( (i & (1<<bit)) != 0) {
					temp += arr[bit];
					}
			}
			if(temp==0) {
				flag = true;
			}
//			System.out.println();
		}
		
		System.out.println(flag);
	} // end of main
}
