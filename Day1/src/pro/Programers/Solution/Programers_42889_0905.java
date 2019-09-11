package pro.Programers.Solution;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programers_42889_0905 {
	public static void main(String[] args) {
		Solution test = new Solution();
//		int N = 5;
		int N = 6;
//		int[] stages = new int[] { 2,1,2,6,2,4,3,3 };
		int[] stages = new int[] { 2,2,2,2,2 };
		test.solution(N, stages);

	}

	static class Solution {
		public int[] solution(int N, int[] stages) {
			PriorityQueue<Pair> q = new PriorityQueue<>();
			// N : 스테이지 (1~500)
			// stages(사용자) (1~200,000) [] (1~N+1)이하
			// N+1 : 전체 다 클리어
			// 부분합
			// 도달 유저가 없음 -> ans 0
			int len = stages.length; // 스테이지 수
			Arrays.sort(stages); // 오름차순 정렬
			int[] sum = new int[N + 2]; // 0 비어놓기 /N+1 넣기
			int cnt = N + 1;
			// TODO : 끝부터 진행 부분합 만듭니다.
			for (int idx = len - 1; idx >= 0; idx--) {
				int data = stages[idx]; // 층
				// TODO : N보다 크면
				while (data != cnt) {
						sum[cnt - 1] = sum[cnt];
						cnt--;
				}
				sum[cnt]++;
			}	// end of input data
			while(cnt >= 1) {
				sum[cnt - 1] = sum[cnt];
				cnt--;
			}
			
			for (int round = 1; round <= N; round++) {
				
				double temp = (double)(sum[round]-sum[round+1])/sum[round];
				if(sum[round] == 0) temp = 0f;
				q.add(new Pair(round,temp));
			}

			int[] answer = new int[N];
			cnt = -1;
//			System.out.println(Arrays.toString(sum));
//			System.out.println(q);
			while(!q.isEmpty()) {
				answer[++cnt] = q.poll().no;
			}
			
//			System.out.println(Arrays.toString(answer));
			return answer;
		}
	}
	static class Pair implements Comparable<Pair>{
		int no;
		double divied;
		protected Pair(int no, double divied) {
			super();
			this.no = no;
			this.divied = divied;
		}
		@Override
		public int compareTo(Pair o) {
			int result = 0;
			// TODO Auto-generated method stub
			if(divied == o.divied) {
				result = (no>o.no)? 1 : -1;
				}
			else {
				result = (divied<o.divied)?1:-1;
			}
			return result;
		}
		@Override
		public String toString() {
			return "Pair [no=" + no + ", divied=" + divied + "]";
		}
		
	}
}
