package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ubk_1074_0924 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int r = stoi(st.nextToken());
		int c = stoi(st.nextToken());
		
		int rowPlus = (int) Math.pow(2,2*N-1);  
		System.out.println(rowPlus+" "+(2*N-1)+" "+Math.pow(2, N));
		int ans=0;
		
		if((c&1)>0) {	//홀수면
			ans+=1;	//항상 한칸 옆은 1
			c-=1;
		}
		//비트연산으로 채우기
		while( c >= 4) {	//비트만큼 돌아라
			ans+=rowPlus;
			c=c>>2;
		}
		while( c != 0) {	//비트만큼 돌아라
			ans+=N<<1;
			c=c>>1;
		}
		
		if((r&1)>0) {	//홀수면
			ans+=N;	///항상 한칸 아래는 2
			r-=1;
		}
		while( r >= 4) {	//비트만큼 돌아라
			ans+=rowPlus;
			r=r>>2;
		}
		//row에 대해서 파악 (2줄당 *2^n)
		while( r != 0) {
			ans+=(rowPlus>>1);
			r=r>>1;
		}
		
		System.out.print(ans);
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
