package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//그리디
public class Fsw_4301_0924 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			int ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			if(N>M) {
				int temp = N;
				N = M;
				M = temp;
			}
			for (int row = 0; row < N; row++) {
				if(row == M)
					break;
				ans++;
				if(row+1 == M)
					break;
				ans++;
			}
			sb.append("#").append(Tcase).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
