package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_3234_0826 {
	static List<Integer> arr;
	static int[] factorial;
	static int  N;
	static Long ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		factorial = new int[11];
		factorial[0] = 1;
		StringBuilder sb = new StringBuilder();
		for(int Tcase=1; Tcase <= T; Tcase++){
			ans=0L;
			sb.append("#").append(Tcase).append(" ");
			
			fac(10);
			N = stoi(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr = new ArrayList<Integer>(10);
			
			int sum = 0;
			for (int loop = 0; loop < N; loop++) {
				int data = stoi(st.nextToken());
				arr.add(data);
				sum+=data;
			}
			
//			combi(0,sum,0,N);	// 조합 2^n 
			
			perm(0,0,0);
			
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	private static void perm(int cnt, int left, int right) {
		// TODO Auto-generated method stub
		if(cnt == N)
			ans++;
		
		else {
			for (int i = cnt; i < arr.size(); i++) {
			}
		}
	}
	static int cnt = 1;
	private static void combi(int start, int left, int right, int size) {
		// TODO Auto-generated method stub
		System.out.println(cnt++ +"번 호출");
		if(right>left)
			return;
		
		ans += factorial[size]*factorial[N-size];
		
		for (int i = start; i < N; i++) {
			combi(i+1,left-arr.get(i),right+arr.get(i), size-1);
		}
	}
	private static int fac(int i) {
		// TODO Auto-generated method stub
		if(i==0||i==1) return factorial[i]=i;
		return factorial[i] = i*fac(i-1); 
	}
	
	
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
