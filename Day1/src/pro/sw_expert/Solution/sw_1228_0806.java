package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_1228_0806 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int Tcase = 1; Tcase <= 10; Tcase++) {
			int N = Integer.parseInt(br.readLine());
			String src = br.readLine();
			List<String> list = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(src, " ");
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

//		System.out.println(list);
			int command = Integer.parseInt(br.readLine());
			String input = br.readLine();
			st = new StringTokenizer(input, " ");
//		
			List<String> temp;
			while (st.hasMoreTokens()) {
				// 명령어 시작
				if (st.nextToken().equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int numbers = Integer.parseInt(st.nextToken());
					temp = new ArrayList<String>();
					for (int i = 0; i < numbers; i++) {
						temp.add(st.nextToken());
					}
					list.addAll(idx, temp);
				}
			}
			sb.append("#");
			sb.append(Tcase);
			for (int i = 0; i < 10; i++) {
				sb.append(" ");
				sb.append(list.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
