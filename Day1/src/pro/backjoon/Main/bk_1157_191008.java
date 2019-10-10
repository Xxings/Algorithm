package pro.backjoon.Main;
/*
 * 25884kb	200ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_1157_191008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toUpperCase();
		int[] count = new int[28];
		
		
		for (int i = 0; i < input.length(); i++) {
			count[input.charAt(i)-'A']++;
		}
		
		int maxIdx = 0;
		int maxValue = count[0];
		int cnt = 1;
		for (int idx = 1; idx < count.length; idx++) {
			if(count[idx]==maxValue) {
				cnt++;
			}
			if(count[idx]>maxValue) {
				maxIdx = idx;
				maxValue = count[idx];
				cnt=1;
			}
		}
		
		System.out.print((cnt>1)?'?':(char)(maxIdx+'A'));
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
