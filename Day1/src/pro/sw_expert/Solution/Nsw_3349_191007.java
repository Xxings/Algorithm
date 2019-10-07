package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//비트연산으로 했더니 오류가 너무 많음

public class Nsw_3349_191007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<int[]> list = new ArrayList<int[]>();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			list.clear(); // 초기화
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int W = stoi(st.nextToken());
			int H = stoi(st.nextToken());
			int N = stoi(st.nextToken());

//			int[][]map = new int[H+1][W+1];	//다 0으로	: 10^6 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int r = stoi(st.nextToken());
				int c = stoi(st.nextToken());
				list.add(new int[] { r, c });
			}
			// 현재 위치값 -> x1,y1
			int curR = list.get(0)[0];
			int curC = list.get(0)[1];
			boolean flag = true; // 양의방향 flag
			for (int idx = 1; idx<list.size(); idx++) {
				int[] pair = list.get(idx);
				// pair[0,1] -> [r,c]
				// 그리디 (x+-1,y+-1이 될경우 쓰는게 무조건 빠름)
				flag = curR + 1 < pair[0];
				if (flag) {
					while (curR + 1 <= pair[0] && curC + 1 <= pair[1]) {
						curR++;
						curC++;
						ans++;
					}
				}else {
					while (curR - 1 >= pair[0] && curC - 1 >= pair[1]) {
						curR--;
						curC--;
						ans++;
					}
				}
				// 가로
				flag = curR < pair[0];
				while (!(flag ^ (curR < pair[0]))) {
					if (curR == pair[0])
						break;
					curR += (flag) ? 1 : -1;
					ans++;
				}
				// 세로
				flag = curC < pair[1];
				while (!(flag ^ (curC < pair[1]))) {
					if (curC == pair[1])
						break;
					curC += (flag) ? 1 : -1;
					ans++;
				}
			}
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
