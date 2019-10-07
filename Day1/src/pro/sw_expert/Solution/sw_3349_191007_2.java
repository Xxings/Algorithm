
/*
20,788 kb
메모리
137 ms
실행시간
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_3349_191007_2 {
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
			boolean flag = true;
			for (int idx = 2; idx <= N; idx++) {	//x2,y2~xN,yN
				st = new StringTokenizer(br.readLine()," ");
				int tR = stoi(st.nextToken());
				int tC = stoi(st.nextToken());
				
				if(curR == tR && curC == tC) {	//이미 같은경우 패스
					continue;
				}
				//대각이동
				flag = curR < tR;
				if(!(curR < tR ^ curC < tC)) {	//두개가 같은방향 (1사분면, 2사분면)
					plus= Math.min( Math.abs(curR-tR), Math.abs(curC-tC) );	//대각 d 최소값
					ans+=plus;
					curR+=(flag)?plus:-plus;
					curC+=(flag)?plus:-plus;
				}
				//상하 이동
				if(curR != tR) {
					flag=curR<tR;
					plus=Math.abs(curR-tR);
					ans+=plus;
					curR+=(flag)?plus:-plus;
				}
				//좌우이동
				if(curC != tC) {
					flag=curC<tC;
					plus=Math.abs(curC-tC);
					ans+=plus;
					curC+=(flag)?plus:-plus;
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
