package pro.Programers.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programers_42840 {

	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(Arrays.toString(test.solution(new int[] { 1, 3, 2, 4, 2 })));

	}

	static class Solution {
		public int[] solution(int[] answers) {
			int[] cnt = new int[4];
			int[] no1 = { 1, 2, 3, 4, 5 };
			int[] no2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
			int[] no3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
			for (int idx = 0; idx < answers.length; idx++) {
				if (no1[idx % no1.length] == answers[idx])
					cnt[1]++;
				if (no2[idx % no2.length] == answers[idx])
					cnt[2]++;
				if (no3[idx % no3.length] == answers[idx])
					cnt[3]++;
			}

			int max = 0;
			int count = 0;
//			 int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
			for (int i = 1; i <= 3; i++) {
				if (max == cnt[i])
					count++;
				else if (cnt[i] > max) {
					max = cnt[i];
					count = 1;
				}
			}
			int[] answer = new int[count];
			for (int i = 1, idx = -1; i <= 3; i++) {
				if(cnt[i] == max)
					answer[++idx] = i; 
			}
			//return list.stream().mapToInt(i->i.intValue()).toArray();
			return answer;
		}
	}
}
