package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 메세지 큐 -> 최소힙을 이용한 연달아 넣기 -> 방식 잘못접근 -> NEXT로 변경
 * 타임오버 -> |  A(최소시간)  |sol2에 분할정복으로 해결
 */
public class sw_3074_0930 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			long ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = stoi(st.nextToken()); // 테이블 수
			int M = stoi(st.nextToken());

			long[] tester = new long[N];
			for (int idx = 0; idx < tester.length; idx++) {
				tester[idx] = stol(br.readLine());
			}

			Arrays.sort(tester);
			// 메세지 큐 (최소힙)
			// 몇번 검색대까지 사용할것인가
			int useIdx = -1;
			PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
				if (a[2] == b[2]) {
					return (int) (a[1] - b[1]);
				} else {
					return (int) (a[2] - b[2]);
				}
			}
			);
			// int[0] -> 시간 / int[1] -> 검열대 시간 / next 시간
			long[] cur;
			for (int people = 0; people < M; people++) {
				if (useIdx == -1) {
					// 초기
					useIdx++;
					pq.add(new long[] { tester[useIdx], useIdx, tester[useIdx]+tester[useIdx] });
//					System.out.printf("사람%d : Idx %d | time %d \n", people, useIdx, tester[useIdx]);
					continue;
				}
				/// 초기의 peek
				cur = pq.peek();
//				System.out.println("");
				if (useIdx + 1 < N && cur[2] > tester[useIdx + 1]) {
					// 새로운 검열대 추가
					useIdx++;
					pq.add(new long[] { tester[useIdx], useIdx, tester[useIdx]+tester[useIdx] });
//					System.out.printf("사람%d : Idx %d | time %d \n", people, useIdx, tester[useIdx]);
				} else { // 아닌경우 가장 최소에다가 +해서 넣기
					cur = pq.poll();
					pq.add(new long[] { cur[0] + tester[(int) cur[1]], cur[1], cur[0] + tester[(int) cur[1]] + tester[(int) cur[1]]});
//					System.out.printf("사람 %d : Idx %d | time %d \n", people, cur[1], cur[0] + tester[(int) cur[1]]);
					if (people == M - 1) { // 정답
						ans = cur[0] + tester[(int) cur[1]];
					}
				}

			}
			// 답은 M번째 넣은 pq값

			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	private static long stol(String readLine) {
		// TODO Auto-generated method stub
		return Long.parseLong(readLine);
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
