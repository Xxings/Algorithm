package pro.backjoon.Main;
/*
 * 메모리 14512	시간 100 
 * 80ms과의 차이 char -> boolean
 * 90ms과의 차이 StringTokenizer->charAt;
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단순 재귀문제
public class bk_2630_0930 {
	static int N;
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//N <= 14 완탐
		N = stoi(br.readLine());
		map = new boolean[N][N];
		for (int row = 0; row < map.length; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < map.length; col++) {
				map[row][col] = (st.nextToken().charAt(0)=='1')? true:false;
			}
		}
		//end of input
		
		recursive(0,0,N);
		
		
		System.out.println(ans[0]);
		System.out.print(ans[1]);
	}// end of main
	static int data;
	static int[] ans = new int[2];
	private static void recursive(int strow, int stcol, int n) {
		// TODO Auto-generated method stub
		if( (data=isFill(strow,stcol,n))>=0) {	//음수면 잘라야할것
//			System.out.println(" data :"+ data+" / "+strow+" "+stcol+" size : "+n);
			ans[data]++;
		}else {
			recursive(strow, stcol, n/2);	//좌상
			recursive(strow, stcol+n/2, n/2);	//좌하
			recursive(strow+n/2, stcol, n/2);	//우상
			recursive(strow+n/2,stcol+n/2,n/2);	//우하
		}
		
	}
	private static int isFill(int strow, int stcol, int n) {
		// TODO Auto-generated method stub
		boolean stpoint = map[strow][stcol];
		int data = (stpoint)?1:0;
		for (int row = strow; row < strow+n; row++) {
			for (int col = stcol; col < stcol+n; col++) {
				if(map[row][col]^stpoint) return -1;	//같지않으면
			}
		}
		
		return data;	//들어간 값으로 채워짐
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
