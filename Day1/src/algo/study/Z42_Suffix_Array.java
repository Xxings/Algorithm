/**
 * 특정 문자열의 모든 부분문자열을 정렬한 상태로 알고 싶을때, 내가 원하는 단어의 검색이 빠르다
 * 	특정 문자열의 모든 접미사를 구함 -> 정렬 -> 각 접미사의 모든 접두사를 구함
 * 
 * 	트라이 Trie : 문자열의 집합을 표현하는 트리
 * 	Compressed Trie : 트라이의 압축된 표현
 *  접미어 트리 Suffix Tree : Compressed Trie 를 개선 형태, 문자열 긑에 사용하지 않는 특수문자'$' 를 표시해서 표현
 *  	생성시간 복잡도 O[N^2] => O[nlogn] => O[n]
 *  접미어 배열 Suffix Array : 접미어들을 사전식으로 나열한 배열, 메모리를 1/4로 절약(접미어 트리에 비해서), 접미어 트리보다 간단하다.
 *  	생성 시간 복잡도 O[nlogn]
 *  
 *  LCP 배열 : 최장 공통 접두어, 접미어 배열의 보조적인 도구로 필요함
 *  	두 문자열 사이의 공통 접두어 길이
 */
package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Z42_Suffix_Array {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input = br.readLine();

		String input = "banana";
		List<String> arr = new ArrayList<>();

		for (int i = input.length() - 1; i >= 0; i--) {
			arr.add(input.substring(i));
		}

		System.out.println("정렬전 부분문자열 : " + arr); // [a, na, ana, nana, anana, banana]

		Collections.sort(arr);

		System.out.println("정렬후 부분문자열 : " + arr); // [a, ana, anana, banana, na, nana]

		int[] LCP = new int[arr.size()];

		LCP[0] = 0;
		for (int idx = 1; idx < LCP.length; idx++) {
			LCP[idx] = (arr.get(idx).startsWith(arr.get(idx - 1))) ? arr.get(idx - 1).length() : 0;
		}

		System.out.println("LCP : " + Arrays.toString(LCP)); // [0, 1, 3, 5, 0, 2]

		System.out.println();
		System.out.println();
		solution();
	}

	public static void solution() {
		String input = "banana";
		int[] sa = new int[input.length()];

		for (int i = 0; i < sa.length; i++) {
			sa[i] = i;
		}

		System.out.println(Arrays.toString(sa));

		for (int i = 0; i < sa.length; i++) {
			for (int j = sa[i]; j < sa.length; j++) {
				System.out.print(input.charAt(j));
			}
			System.out.println();
		}

		// s 문자열의 모든 접미사를 정렬(예제 : 선택정렬)
		for (int i = 0; i < sa.length; i++) {
			int minIdx = i;
			for (int j = i; j < sa.length; j++) {
				// 비교할 두 문자열의 앞에서부터 한글자씩 비교하는 반복문을 작성해야한다.
				if (input.substring(sa[minIdx]).compareTo(input.substring(sa[j])) > 0) { // 이렇게 하면 안된다. [ 느려 ]
					// update
					minIdx = j;
				}
			}
			// minIdex <-> i swap
			int temp = sa[minIdx];
			sa[minIdx] = sa[i];
			sa[i] = temp;
		}
		System.out.println(Arrays.toString(sa));

		for (int i = 0; i < sa.length; i++) {
			for (int j = sa[i]; j < sa.length; j++) {
				System.out.print(input.charAt(j));
			}
			System.out.println();
		}

		// s 문자열의 모든 접미사를 정렬 상태의 LCP를 구함
		int[] LCP = new int[input.length()]; // 최장공통접두어를 저장할 배열 : i-1번째 문자열, i 번째 문자열을 비교, 공통접두어가 몇글자인가
		for (int i = 1; i < LCP.length; i++) {
			int len1 = input.length() - sa[i - 1]; // i-1번째의 글자의 길이
			int len2 = input.length() - sa[i]; // i번째의 글자의 길이
			while (len1 > LCP[i] 
					&& len2 > LCP[i] 
							&& input.charAt(sa[i - 1] + LCP[i]) == input.charAt(sa[i] + LCP[i])) {
				LCP[i]++;
			}
		}
		System.out.println(Arrays.toString(LCP));

		// 정렬 한 s 문자열의 모든 접미사의 모든 접두사
		for (int i = 0; i < sa.length; i++) {
			String str = input.substring(sa[i]); // 현재의 접미사(suffix)
			System.out.println("<" + str + ">");

			// 각 접미사로 만들 수 있는 모든 접두사를 출력
			for (int j = LCP[i] + 1; j < str.length(); j++) {
				System.out.println(str.substring(0, j - 1));
			}
			System.out.println(str.length() + " : 접두사의 개수");
			System.out.println(LCP[i] + " : 공통접두사의 개수");
			System.out.println(str.length() - LCP[i] + " : 유효한 부분문자열의 개수"); // 현 i단계에서 유효한 문자열의 개수
		}

		// s 문자열에서 만들 수 있는 모든 부분 문자열에서 사전식 정렬상태의 k번째 문자열을 구하라
		int k = 13;
		System.out.println(" s 문자열에서 만들 수 있는 모든 부분 문자열에서 사전식 정렬형태의 " + k + "번째 문자열");

		for (int i = 0; i < sa.length; i++) {
			String str = input.substring(sa[i]);

			if (k - (str.length() - LCP[i]) > 0) {
				k -= str.length() - LCP[i];
			} else {
				System.out.println(str.substring(0, LCP[i] + k));	// k 번째 접미사
				System.out.println(input.substring(sa[i], LCP[i] + k + sa[i]));	//k번째 접미사
				break;
			}
		}
	}
}
