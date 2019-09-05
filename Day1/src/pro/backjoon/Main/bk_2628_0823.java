/* 19632kb	224ms
 * 
 */
package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bk_2628_0823 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int COL = stoi(st.nextToken());
		int ROW = stoi(st.nextToken());

		int ans = 0;

		int num = stoi(br.readLine());
		List<Integer> arr_COL = new ArrayList<Integer>();
		List<Integer> arr_ROW = new ArrayList<Integer>();

		arr_COL.add(COL);
		arr_ROW.add(ROW);

		for (int slide = 1; slide <= num; slide++) {
			st = new StringTokenizer(br.readLine(), " ");
			int flag = stoi(st.nextToken());
			int data = stoi(st.nextToken());
			if (flag == 0)
				arr_ROW.add(data);
			else
				arr_COL.add(data);
		}
		int Maxrow = 0;
		int pre = 0;
		int Maxcol = 0;

//		Collections.sort(arr_COL);
		arr_ROW.sort((a, b) -> (a > b) ? 1 : -1);
		arr_COL.sort((a, b) -> (a > b) ? 1 : -1);

		for (int row : arr_ROW) {
			int temp = row - pre;
			if (temp > Maxrow)
				Maxrow = temp;
			pre = row;
		}
		pre = 0;
//		for (int col : arr_COL) {
//			int temp = col - pre;
//			if (temp > Maxcol)
//				Maxcol = temp;
//			pre = col;
//		}
		for (int i = 1; i < arr_COL.size(); i++) {
			if(Maxcol > arr_COL.get(i)-arr_COL.get(i-1))
				Maxcol = arr_COL.get(i)-arr_COL.get(i-1);
		}

		ans = Maxrow * Maxcol;
		sb.append(ans).append("\n");
		System.out.println(sb);
	}

	private static int stoi(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}

}
