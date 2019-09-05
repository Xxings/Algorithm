package pro.Programers.Solution;

import java.util.HashMap;
import java.util.Map;

/*
15	1
24	0
41	2
2147483647	1735
 * 
 */
public class UProgramers_1831 {
	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(test.solution(2147483647));

	}

	static class Solution {
		static Map<Integer, Integer> dps = new HashMap<Integer, Integer>();

		public int solution(int n) {
			int answer = 0;
			dps.put(5, 1);
			answer = dp(n);
			return answer;
		}

		private int dp(int n) {
			// TODO Auto-generated method stub
			System.out.println(n);
			if(dps.containsKey(n)) return dps.get(n);
			if(n<5) return 0;
			int ans = 0;
			if(n%3==2) {	//17 *++*++
				System.out.print("2->");
				ans+=2*dp(n/3);
			}
			if(n%3==1) {	//13 **++++
				System.out.print("1->");
				ans+=dp((n-1)/3+1);
			}
			if(n%3==0) {	//15 *+*+++
				System.out.print("0->");
				ans+=dp(n/3);
			}
			dps.put(n, ans);
			return dps.get(n);
		}
	}
}
