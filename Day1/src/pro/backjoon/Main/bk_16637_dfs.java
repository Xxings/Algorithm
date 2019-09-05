//DFS : SUCCEUS 72ms
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bk_16637_dfs {
	static int end;
	static char[] num ;
	static char[] opr ;
	static int ans = Integer.MIN_VALUE;
	static int[] save;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int N = 7;
//		char[] input = "3-6+1*5".toCharArray();
		
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		num = new char[N/2+1];
		save = new int[N/2+1];
		end = N/2+1;
		opr = new char[N/2];
		int nidx = 0;
		int oidx = 0;
		// 숫자 n+1 | 연산자 n | N = 2n+1;
		for (char data : input) {
			if (data >= '0' && data <= '9')
				num[nidx++] = data;
			else
				opr[oidx++] = data;
		}

//		System.out.println(Arrays.toString(num));
//		System.out.println(Arrays.toString(opr));
		
		//재귀
		bk(num[0]-'0', 1, 0, false);
		System.out.println(ans);

	}
	private static void bk(int result, int nidx, int oidx, boolean isflag) {
		// TODO Auto-generated method stub
		save[nidx-1]=result;
		int temp = 0;
		int temp2 = 0;
		if(end == nidx) {
			 if(ans<result)
				 ans=result;
			 return;
		}
		else if(!isflag)	//T 나 F나 아무거나 (전에F)
		{
			//F인 경우
			temp = cal(result, opr[oidx], num[nidx]-'0');
			bk(temp, nidx+1,oidx+1,false);
			//T인 경우			
			if(oidx != 0) {
				temp = cal(num[nidx-1]-'0', opr[oidx], num[nidx]-'0');
				temp2 = cal(save[nidx-2], opr[oidx-1], temp);
				bk(temp2, nidx+1,oidx+1,true);
			}
		}
		else {	//F만
			temp = cal(result, opr[oidx], num[nidx]-'0');
			bk(temp, nidx+1,oidx+1,false);
		}
	}
	private static int cal(int result, char c, int d) {
		// TODO Auto-generated method stub
		switch(c) {
		case '+':
			result += d;
			break;
		case '*':
			result *= d;
			break;
		case '-':
			result -= d;
			break;
		}
		return result;
	}
}
