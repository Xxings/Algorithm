/* 16,972 kb 메모리
114 ms 실행시간 
 * 
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class sw_1240_0814 {
	
	static Map<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);
		int T = stoi(br.readLine());
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			sb.append("#").append(Tcase).append(" ");
			int result = 0;
			String[] input = br.readLine().split(" ");
			int N = stoi(input[0]);
			int M = stoi(input[1]);
			
			String readed ="";
			for (int line = 1; line <= N; line++) {
				readed = br.readLine();
				if(readed.contains("1")) {
					for (int i = line+1; i <= N; i++) {
						br.readLine();	//버리기
					}
					break;
				}
			}
			
			///readed
			int endIdx = readed.lastIndexOf("1");
			int sum = 0;
			for (int num = 8; num >= 1; num--) {
				String data = readed;
				if(num%2 == 0) {
					result+=map.get(data.substring(endIdx-6, endIdx+1));
					sum+=map.get(data.substring(endIdx-6, endIdx+1));
				}
				else {
					result+=map.get(data.substring(endIdx-6, endIdx+1));
					sum+=map.get(data.substring(endIdx-6, endIdx+1))*3;
				}
				endIdx -= 7;
			}
			sb.append((sum%10==0)?result:0).append("\n");
		}
		System.out.println(sb);
		
	}
	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}
}
