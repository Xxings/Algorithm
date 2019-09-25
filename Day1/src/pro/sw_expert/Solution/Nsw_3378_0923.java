package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 5 4
(Follow.my.style
.........starting.from.round.brackets)
{then.curly.brackets
.....[.and.finally
.......square.brackets.]}
(Thank.you
{for.showing.me
[all
the.secrets]})
 * 
 */

public class Nsw_3378_0923 {
	static int[] calc = new int[3];
	public static void main(String[] args) throws IOException {
		// R(a – b) + C(c – d) + S(e – f)
		// 숫자 점검 ( / { / [

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			sb.append("#").append(Tcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int Aline = stoi(st.nextToken());
			int Bline = stoi(st.nextToken());
			// 0의 개수 / R : 0 / C : 1 / S : 2 / count
			int[] cnt = new int[5];
			calc = new int[3];	//R C S 값 담을 부분
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(b[0]-a[0]));
//			mapping = new HashSet<>();

			for (int row = 0; row < Aline; row++) {
				String inputLine = br.readLine();
				int count = 0;
				boolean inflag = true;
				// 들여쓰기 확인
				for (int idx = 0; idx < inputLine.length(); idx++) {
					char data = inputLine.charAt(idx);
					if (inflag && (data == '.')) {
						count++;
					} else {
						if (inflag) {
							cnt[4] = count;
							cnt[0] = 0;
							for (int i = 1; i <= 3; i++) {
								if(cnt[i] == 0)
									cnt[0]++;
							}
							if(cnt[0] != 3) { 	//0 0 0 인경우 패스
								System.out.println(Arrays.toString(cnt));
								pq.add(cnt.clone()); // R C S = Count [기록]
							}
						}
						inflag = false;
						// 그다음부터 괄호 체크
						switch (data) {
						case '(':
							cnt[1]++;
							break;
						case ')':
							cnt[1]--;
							break;
						case '[':
							cnt[2]++;
							break;
						case ']':
							cnt[2]--;
							break;
						case '{':
							cnt[3]++;
							break;
						case '}':
							cnt[3]--;
							break;
						}
					}
				}
			} // end of ALine
			CalcRCS(pq);	// RCS구하기
			
			
		}//end of TCase
		
		System.out.print(sb);

	}
	
	private static void CalcRCS(PriorityQueue<int[]> pq) {
		// TODO Auto-generated method stub
		
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
