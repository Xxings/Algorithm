package pro.Programers.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Programers_17677_0906 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		
		test.solution(str1, str2);
	}
	
	static class Solution {
		static List<int[]> lists1 = new ArrayList<int[]>(); 
		static List<int[]> lists2 = new ArrayList<int[]>();
		static String data1;
		static String data2;
		static int len1;
		static int len2;
		static HashSet<String> sum = new HashSet<>();
		public int solution(String str1, String str2) {
			//유사도 검증
			//ans = 교집합 / 합집합 * 65536
			//대소문자 차이 X | 글자만 확인
			//두글자씩 끊어서 다중집합
			int answer = 0;
			data1 = str1.replaceAll("[^a-zA-Z]+","").toUpperCase();
			data2 = str2.replaceAll("[^a-zA-Z]+","").toUpperCase();
			
			if(data1.equals(data2)) {	//가지치기
				answer = 65536;
			}
			len1 = data1.length();
			len2 = data2.length();
			
			combi1(0, 0, new int[2]);
			combi2(0, 0, new int[2]);
			
			double result = (cnt1+cnt2)/(double)sum.size();
			
			System.out.println(result);
			
			return answer;
		}
	
		static int cnt1 = 0;
		static int cnt2 = 0;
		private void combi1(int step,int start, int[] data) {
			// TODO Auto-generated method stub
			if(step == data.length) {
				String temp = "";
				for (int i = 0; i < data.length; i++) {
					temp+=data1.charAt(data[i]);
					sum.add(temp);
				}
				cnt1++;
				return;
			}
			else {
				for (int i = start; i < len1; i++) {
					data[step] = i;
					combi1(step+1, i+1, data);
					data[step] = 0;
				}
			}
		}
		private void combi2(int step,int start, int[] data) {
			// TODO Auto-generated method stub
			if(step == data.length) {
				String temp = "";
				for (int i = 0; i < data.length; i++) {
					temp+=data1.charAt(data[i]);
					sum.add(temp);
				}
				cnt2++;
				return;
			}
			for (int i = start; i < len2; i++) {
				data[step] = i;
				combi2(step+1, i+1, data);
				data[step] = 0;
			}
		}
	}
}
