package pro.Programers.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Npro_42895_2 {
	public static void main(String[] args) {
		Solution test = new Solution();
		int N = 5;
		int number = 3600;

		System.out.println(test.solution(N, number));
	}

	private static class Solution {
		// COPY
		public int solution(int N, int number) {
			int step = 1;
			int answer = 0;
			int value = N;
			Set<Integer> sets = new HashSet<>();
			List<List> dp = new ArrayList<List>();
			List<Integer> lists = new ArrayList<>();
			List<Integer> temp;
			while(true) {
				//end 조건
				if(step > 8) {
					answer =-1;
					break;
				}
				else if(value == number) {
					answer = step;
					break;
				}
				//algo
				lists.add(extend(N,step));
				for (int i = 1; i < step; i++) {
					
				}
				step++;
			}
			
			return answer;
		}

		private Integer extend(int n, int step) {
			// TODO Auto-generated method stub
			int result = n;
			for (int i = 1; i < step; i++) {
				result=result*10+n;
			}
			return result;
		}
		
		
		//end of copy
	}
}
