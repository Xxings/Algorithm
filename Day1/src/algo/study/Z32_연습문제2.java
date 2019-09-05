//아직 이해안됨 16진수 -> 7단위로 잘라 2진수 보내고 10진수로 출력
package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pro.backjoon.Main.main;

public class Z32_연습문제2 {
	public static void main(String[] args) throws IOException {
		//16진수 0x
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input =br.readLine().split(null);
		
		//책 꼭 볼것
		String[] binString = {
				"0000",
				"0001",
				"0010",
				"0011",
				"0100",
				"0101",
				"0110",
				"0111",
				"1000",
				"1001",
				"1010",
				"1011",
				"1100",
				"1101",
				"1110",
				"1111"			
		};	//16개 charat으로 가져와서 
		
		String s = "0F97A3";
		String result = "";	//2진수 결과를 저장할 변수
		for (int i = 0; i < binString.length; i++) {
			char c = s.charAt(i);
			if('0'<=c && c <= '9') {
				result += binString[c-'0'];
			}else {
				result += binString[c - 'A'+10];
			}
		}
		
		System.out.println(result);
		
		int value = 0;
		for (int i = 0; i < result.length(); i++) {
			value = value * 2 + (result.charAt(i)-'0');
			if(i%7 == 6) {
				System.out.println(value + ",");
				value = 0;
			}
			System.out.println(value);
		}
		
		
	}
}
