/*
46,064 kb
메모리
1,014 ms
실행시간
 *
 * 1. set과 list
 * 2. 트라이
 * 3. List안에 Set
 * 4. Sorted Sort
 */
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class sw_7701_191008 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		HashSet<String> sets = new HashSet<>();
		for(int Tcase=1; Tcase <= T; Tcase++){
			//일단 그냥 정렬로 해볼까
			list.clear();
			sets.clear();
			int N = stoi(br.readLine());
			String data;
			for (int i = 0; i < N; i++) {
				data = br.readLine();
				if(sets.contains(data))
					continue;
				sets.add(data);
				list.add(data);
			}	// end of input
			
			Collections.sort(list);
			Collections.sort(list, (a,b)->{
				if(a.length()==b.length()) {
					return a.compareTo(b);
				}
				return a.length()-b.length();
			});
			sb.append("#").append(Tcase).append("\n");
			for (String value : list) {
				sb.append(value).append("\n");
			}
		} // end of TC
		System.out.print(sb);
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
