/*
 * 메모리 25MB
 * 시간	588ms
 * 
 */
package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jg_2634_0903 {
	static int[] where = new int[100_000];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		//1_000_000_000만이라서 어짜피 map안되고,
		//넣으면서 바로 계산
		st = new StringTokenizer(br.readLine(), " ");
		int M = stoi(st.nextToken());
		int N = stoi(st.nextToken());
		int L = stoi(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		//사대 넣기
		for (int idx = 0; idx < M; idx++) {
			where[idx] = stoi(st.nextToken());
		}
		//소트해서 시간 줄이기
		Arrays.sort(where,0,M);
		//동물넣기 O(NM)
		int x;
		int y;
		int idx;
		int curL;
		int left;
		int right;
		for (int loop = 0; loop < N; loop++) {
			st = new StringTokenizer(br.readLine()," ");
			x = stoi(st.nextToken());
			y = stoi(st.nextToken());
			//M다돌리기 -> 시간초과 75점
			//TODO: 이진탐색
			curL = L-y;
			if(curL<0)
				continue;
			left = 0;
			right = M-1;
			while(true) {
				if(left>right)
					break;
				idx = (left+right+1)/2;
				if(curL >= (Math.abs(where[idx]-x))) {
					ans++;
					break;
				}else {
					if(x > where[idx] ) {
						left = idx+1;
					}else {
						right = idx-1;
					}
				}
			}
		}
		
		System.out.print(ans);
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
