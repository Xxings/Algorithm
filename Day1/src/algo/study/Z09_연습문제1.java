package algo.study;
import java.util.Arrays;
import java.util.Random;

public class Z09_연습문제1 {
	public static void main(String[] args) {
		Random rand = new Random();
		
		int[][] arr = new int[5][5];
		
		//값 입력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rand.nextInt(100);
			}
		}
		
//		for (int j = 0; j < arr.length; j++) {
//			System.out.println(Arrays.toString(arr[j]));
//		}
		int temp=0;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if(row>0)	//상
					temp+=Math.abs(arr[row][col]-arr[row-1][col+0]);
				if(col<arr.length-1)	//우
					temp+=Math.abs(arr[row][col]-arr[row][col+1]);
				if(row<arr.length-1)	//하
					temp+=Math.abs(arr[row][col]-arr[row+1][col]);
				if(col>0)	//좌
					temp+=Math.abs(arr[row][col]-arr[row][col-1]);
			}
		}
		System.out.println(temp);
	}// end of main
}
