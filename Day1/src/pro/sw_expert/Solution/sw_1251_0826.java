package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class sw_1251_0826 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<Pair> arr = new ArrayList<>();
		
		for(int Tcase=1; Tcase <= T; Tcase++){
			arr.clear();
			double ans=0;
			sb.append("#").append(Tcase).append(" ");
			
			int N = stoi(br.readLine());
			int[] row = new int[N];
			int[] col = new int[N];
			p = new int[N];
			for (int no = 0; no < p.length; no++) {
				p[no] = no;
			}
			
			st = new StringTokenizer(br.readLine()," ");
			for (int loop = 0; loop < N; loop++) {
				row[loop] = stoi(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for (int loop = 0; loop < N; loop++) {
				col[loop] = stoi(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			for (int loop = 0; loop < N; loop++) {
				for (int loopB = loop+1; loopB < N; loopB++) {
					int rowA = row[loop];
					int colA = col[loop];
					int rowB = row[loopB];
					int colB = col[loopB];
					arr.add(new Pair(
							loop
							, loopB
							, Math.abs(rowA-rowB)+Math.abs(colA-colB)
					));
				}
			}
			
			arr.sort((d1,d2)->(d1.C>d2.C)?1:-1);
			
			for (int idx = 0; idx < arr.size(); idx++) {
				Pair A = arr.get(idx);
				int pA = find(A.A);
				int pB = find(A.B);
				if(pA==pB) {	//같은 부모니?
					
				}
			}
			
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
	private static int find(int idx) {
		if(idx == p[idx])
			return idx;
		return p[idx]=find(p[idx]);
		}
	
	private static boolean isUnion(int a, int b) {
		// TODO Auto-generated method stub
		return false;
	}
	public static class Pair {
		int A;
		int B;
		int C;
		protected Pair(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}
		@Override
		public String toString() {
			return "Pair [A=" + Arrays.toString(A) + ", B=" + Arrays.toString(B) + ", C=" + C + "]";
		}
		
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
}
