package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_3499_0809 {
	static int N;
	static ArrayList<String> deck;
	static List<String> left_deck;
	static List<String> right_deck;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		StringTokenizer st;
		
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			
			sb.append("#");
			sb.append(Tcase);
			sb.append(" ");
			
			deck = new ArrayList<>();
			left_deck = new ArrayList<>();
			right_deck = new ArrayList<>();
			
			N = Integer.valueOf(br.readLine());
			
			String input = br.readLine();
			st = new StringTokenizer(input);
			while(st.hasMoreTokens()) {
				deck.add(st.nextToken());
			}
			
			if(N%2 == 1) {
				left_deck = deck.subList(0, N/2+1);
				right_deck = deck.subList(N/2+1, N);
				for (int i = 0; i < N/2; i++) {
					sb.append(left_deck.get(i));
					sb.append(" ");
					sb.append(right_deck.get(i));
					sb.append(" ");
				}
				sb.append(left_deck.get(N/2));
				sb.append(" ");
				
			}
			else{
				left_deck = deck.subList(0, N/2);
				right_deck = deck.subList(N/2, N);

				for (int i = 0; i < N/2; i++) {
					sb.append(left_deck.get(i));
					sb.append(" ");
					sb.append(right_deck.get(i));
					sb.append(" ");
				}
			}
			
			
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
