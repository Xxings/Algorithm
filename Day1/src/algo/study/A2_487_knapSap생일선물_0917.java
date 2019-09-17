package algo.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A2_487_knapSap생일선물_0917 {
	public static void main(String[] args) {
		int[][] input = {{5,10},{4,40},{6,30},{3,50}};
		int M = 10;
		Solution test = new Solution();
		System.out.println(Arrays.toString(test.Answer(input, M)));
		
		
	}
	//O(N^2)
	private static class Solution {
		// TODO Auto-generated method stub
		private int[] Answer(int[][] input,int M){
			int[][] Knap = new int[input.length][M+1];	//(1~10)
			
			
			//kanpSack Value
			for (int no = 1; no < Knap.length; no++) {
//			int no = 1;
				int[] item = input[no-1];
				for (int w = 1; w <= M; w++) {
					if(item[0] <= w) {	// [0] 무게 [1] 가치
//						Knap[no][w] = Math.max(Knap[no-1][w],Knap[no-1][w-item[0]] + item[1]);
						Knap[no][w] = Math.max(Knap[no-1][w],Knap[no-1][w-item[0]] + item[1]);
					}
					else {
						Knap[no][w] = Knap[no-1][w]; 
					}
				}
			}
			Tmap(Knap);
			int answer_Value = Knap[input.length-1][M];
			
			int no = input.length-1;
			int weight = M;
			
//			List<Integer> answer = new ArrayList<Integer>();
			int[] answer = new int[input.length];
			int cnt = -1;
			while(true) {
				if(Knap[no][weight]==0)
					break;
				if(Knap[no][weight] == Knap[no-1][weight]) {
					//no의 물건 넣지 않음
					no--;
				}
				else {	//no의 물건을 넣음
					answer[++cnt] = no;
					no--;
					weight -= input[no-1][0];	//무게 줄여주기
				}
			}
			answer[++cnt] = answer_Value;
			
			return answer;
		}

		private void Tmap(int[][] knap) {
			// TODO Auto-generated method stub
			System.out.println();
			for (int row = 0; row < knap.length; row++) {
				System.out.println(Arrays.toString(knap[row]));
			}
			System.out.println();
		}
		
	}
}


