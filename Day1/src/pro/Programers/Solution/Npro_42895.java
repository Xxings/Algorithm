package pro.Programers.Solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//예외 (55+5)*(55-5) / 5 / 3600
public class Npro_42895 {
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

			
			answer = bfs(N, number, 1);
			return answer;
		}

		private int bfs(int n, int number, int step) {
			// TODO Auto-generated method stub
			Set<Integer> sets = new HashSet<>();
			Queue<Integer> q = new LinkedList<Integer>();
			Queue<Integer> nextq = new LinkedList<Integer>();
			Queue<Integer> temp;
//			sets.add(n);
//			sets.add(0);
			int size = 0;
			int num;
			end : while (true) {
				q.add(con(n,step-1));
				sets.add(con(n,step-1));
				if (step > 8) {
					step = -1;
					break;
				}
				size = q.size();
				while (size-- > 0) {
					num = q.poll();
					System.out.println("step : " + step + " / num : " + num);
					if (num == number)
						break end;
					

					if (num < number * n && !sets.contains(num + n)) {
						sets.add(num + n);
						nextq.add(num + n);
					}

					if (num-n > 0 && !sets.contains(num - n)) {
						sets.add(num - n);
						nextq.add(num - n);
					}

					if (num < number * n && !sets.contains(num * n)) {
						sets.add(num * n);
						nextq.add(num * n);
					}

					if (!sets.contains(num / n)) {
						sets.add(num / n);
						nextq.add(num / n);
					}
				}
				step++;
				temp = nextq;
				nextq = q;
				q = temp;
			}
			return step;
		}

		private Integer con(int n, int step) {
			// TODO Auto-generated method stub
			int result = n;
			for (int i = 0; i < step; i++) {
				result *= 10;
				result += n;
			}
			return result;
		}
		//end of solution
	}
}
