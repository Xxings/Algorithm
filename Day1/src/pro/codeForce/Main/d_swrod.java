package pro.codeForce.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class d_swrod {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		String save = br.readLine();
		StringTokenizer st = new StringTokenizer(save," ");
		int origin = 0;
		int pre_min = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int div = -1;
		for (int idx = 0; idx < N; idx++) {
			int data = stoi(st.nextToken());
			if(origin<data) {
				origin = data;
			}
			if(min > data) {
				if(data == 0) continue;
				pre_min = min;
				min = data;				
			}
			else if(pre_min > data) {
				if(data != min)
					pre_min = data;
			}
//			if(pre_min == Integer.MAX_VALUE || min == Integer.MAX_VALUE) continue;
			div = gcd(div,gcd(origin-min,origin-pre_min));
			if(div==-1) continue;
//			div = gcd(origin-min,origin-pre_min);
//			System.out.printf("%d : %d/%d div : %d \n",idx,pre_min, min, div);
		}
		st = new StringTokenizer(save," ");
		long count = 0L;
		for (int idx = 0; idx < N; idx++) {
			int data = stoi(st.nextToken());
			count += (origin-data)/div;
		}
		if(N==2) {
			System.out.print(div+" "+count);
		}
		else {
			System.out.print(count+" "+div);
		}
		
	}
	
	
	private static int gcd(int i, int j) {
		// TODO Auto-generated method stub
		int r = 1;
		//i>j
		if(i<j) {
			r = i;
			i = j;
			j = r;
		}
		
		if(j==-1) return i;
		if(i==0) return -1;
		if(j==0) return i;
		while(r>0) {
			r = i%j;
			i = j;
			j = r;
		}
		return i;
	}
 
 
	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}
}