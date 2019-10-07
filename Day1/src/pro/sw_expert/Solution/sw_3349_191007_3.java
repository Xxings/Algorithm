
/*
20,788 kb -> 21664kb
메모리
137 ms -> 134ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_3349_191007_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			
			st.nextToken();	//H
			st.nextToken();	//W
			//두개 버림
			int N = stoi(st.nextToken());
			
			//그리디
			st = new StringTokenizer(br.readLine()," ");
			int curR = stoi(st.nextToken());	//x1
			int curC = stoi(st.nextToken());	//y1
			int plus = 0;
			for (int idx = 2; idx <= N; idx++) {	//x2,y2~xN,yN
				st = new StringTokenizer(br.readLine()," ");
				int tR = stoi(st.nextToken());
				int tC = stoi(st.nextToken());
				int dR = curR - tR;
				int dC = curC - tC;
				if(dR < 0) dR = -dR;
				if(dC < 0) dC = -dC;
				if(curR == tR && curC == tC) {	//이미 같은경우 패스
					continue;
				}
				//대각이동
				if(!(curR < tR ^ curC < tC)) {	//두개가 같은방향 (1사분면, 2사분면)
					plus= Math.max(dR,dC);	//대각 d 최대값
					ans+=plus;
					curR=tR;
					curC=tC;
				}
				else {	//상하좌우만 이동
					plus = dR + dC;
					ans +=plus;
					curR = tR;
					curC = tC;
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
