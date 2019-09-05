package pro.backjoon.Main;
//13000kb	80ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bk_14891 {
	static int T;
	static final int MAX = 8;
	static wheel[] Products;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = 4; // 톱니바퀴수

		Products = new wheel[T+1];
		

		for (int loop = 1; loop <= T; loop++) {
			char[] data = br.readLine().toCharArray();
			Products[loop] = new wheel(data);
		}
		
		int K = Integer.valueOf(br.readLine());
		for (int loop = 0; loop < K; loop++) {
			String[] temp = br.readLine().split(" ");
			int no = Integer.valueOf(temp[0]);
			int rotate = Integer.valueOf(temp[1]);
			int[] movelist = new int[T+1];
			movelist[no] = rotate;
			
			for (int left = no-1; left >= 1; left--) {
				movelist[left]=Products[left+1].LcompareTo(Products[left], movelist[left+1]);
				if(movelist[left]==0)
					break;
			}
			for (int right = no+1; right <= T; right++) {
				movelist[right]=Products[right-1].RcompareTo(Products[right], movelist[right-1]);
				if(movelist[right]==0)
					break;
			}
			
			//회전 끝
//			System.out.println(Arrays.toString(movelist));
			for (int data = 1; data <= T; data++) {
				Products[data].move(movelist[data]);
			}
		}
		int result = 0;
		for (int data = 1; data <= T; data++) {
			result += Products[data].ans();
		}
		System.out.println(result);
		
	}

	static class wheel {
		int ridx;
		int lidx;
		int ans;
		char[] data;
		int no;
		static int cnt = 1;

		wheel(char[] data) {
			this.no = cnt++;
			this.ridx = 2;
			this.lidx = MAX-2;
			this.ans = 0;
			this.data = data.clone();
		}
		
		public int LcompareTo(wheel wheel, int rotate) {
			// TODO Auto-generated method stub
			if(data(this.lidx) == wheel.data(wheel.ridx)) 	//같은극 회전안함
				return 0;
			else 
				return -1*rotate;
			
		}
		public int RcompareTo(wheel wheel, int rotate) {
			// TODO Auto-generated method stub
			if(data(this.ridx) == wheel.data(wheel.lidx))
				return 0;
			else
				return -1*rotate;
		}
		
		public char data(int idx) {
			return data[idx];
		}
		public int ans(){
			
			return (data[ans]=='1')?(1<<(no-1)):0;
		}
		void move(int rotate) {
			switch (rotate) {
			case -1:	//반시계방향
				ridx = ((ridx+1)==MAX)? 0 : ridx+1;
				lidx = ((lidx+1)==MAX)? 0 : lidx+1;
				ans = ((ans+1)==MAX)? 0 : ans+1;
				
				break;
			case 1:	//시계방향
				ridx = (ridx-1 == -1)? MAX-1 : ridx-1;
				lidx = (lidx-1 == -1)? MAX-1 : lidx-1;
				ans = (ans-1 == -1)? MAX-1 : ans-1;
				break;
			case 0:
				break;
			default:
				System.out.println("error");
			}
		}
	}

}
