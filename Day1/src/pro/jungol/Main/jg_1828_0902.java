package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class jg_1828_0902 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Product> lists = new ArrayList<>();

		int N = stoi(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int min = stoi(st.nextToken());
			int max = stoi(st.nextToken());
			lists.add(new Product(min, max));
		}

		int ans = 1;	//최소는 항상 하나
//		lists.sort((a, b) -> ( (a.min > b.min) ? 1 : -1) );	//버전오류
		Collections.sort(lists);
		int save = lists.get(0).max;	//좌측값
		for (Product p : lists) {
			if (save >= p.min) { // 구간 값 사이에있다면
				continue;
			} else {
				ans++;
				save = p.max;
			}
		}
//		System.out.println(lists);

		System.out.println(ans);
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	private static class Product implements Comparable<Product>{
		static int cnt = 0;
		int no;
		int min;
		int max;

		protected Product(int min, int max) {
			super();
			no = ++cnt;
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Product [no=" + no + ", min=" + min + ", max=" + max + "]";
		}

		@Override
		public int compareTo(Product o) {
			// TODO Auto-generated method stub
			
			return ((this.max > o.max) ? 1 : -1);
		}

	}
}
