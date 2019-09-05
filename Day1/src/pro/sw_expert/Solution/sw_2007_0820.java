package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_2007_0820 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for(int Tcase=1; Tcase <= T; Tcase++){
			int ans = 0;
			char[] input = br.readLine().toCharArray();
			int len = 1;
			end:for (; len <10; len++) {
				int target = len;
				boolean isflag = true;
				while(target<29) {
					if(input[29] != input[29-target]) {
						isflag = false;
						break;
					}
					target+=len;
				}
				
				if(isflag) {
					boolean isok = true;
					for (int idx = 0; idx < len; idx++) {
						if(input[idx] != input[idx+len]) {
							isok = false;
							break;
						}
					}
					
					if(isok) {
						ans = len;
						break end;
					}
				}
			}
			
			sb.append("#").append(Tcase).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	private static int stoi(String readLine){
		return Integer.parseInt(readLine);
	}
}
