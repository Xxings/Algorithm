package pro.backjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class bk_17281_0807 {

	static ArrayList<int[]> looplist; // 선수 조합모음
	static int N;
	static final int _MEMBER = 9;
	static int[][] inning_hit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 이닝 ~50

		inning_hit = new int[N + 1][];

		// 선수데이터 입력
		for (int inn = 1; inn <= N; inn++) {
			String[] str = br.readLine().split(" ");
			int[] hit = new int[10];
			for (int loop = 0; loop < 9; loop++) {
				hit[loop + 1] = Integer.parseInt(str[loop]);
			}
			inning_hit[inn] = hit;
		}
//		Tmap(inning_hit);

		looplist = new ArrayList<>();
		setMake(1, new int[10], new boolean[10]); // 순열 조합 8!

		int ans = 0;
		int result = 0;
		for (int[] members : looplist) {
			result = game(members);
			if(ans<result) {ans = result;}
		}
		System.out.println(ans);
	}

	private static int game(int[] members) {
		// TODO Auto-generated method stub
		int result = 0;
		int no = 1;
		for (int inning = 1; inning <= N; inning++) {
			int out = 3;
			boolean base[] = new boolean[5];
			while (out != 0) {
				int data = inning_hit[inning][members[no]];
				no = (no + 1 == 10) ? 1 : no + 1;

				switch(data) {
				case 0:	//아웃
					out--;
					break;
				case 4:	//홈런
					result+=1;
				case 1:
				case 2:
				case 3:
					for (int base_no = 3; base_no >= 1; base_no--) {	//베이스체크
						if(base[base_no]) {	//베이스 있으면
							if(data+base_no >= 4) {
								base[base_no] = false;
								result+=1;
							}
							else {
								base[data+base_no]= true;
								base[base_no] = false;
							}
						}
					}
					base[data] = true;
						
				}// end of switch

			}

		}
		return result;

	}

	private static void Tmap(int[][] inning_hit2) {
		// TODO Auto-generated method stub
		for (int[] data : inning_hit2) {
			System.out.println(Arrays.toString(data));
		}
	}

	// 순열 만들자 8! = 4만
	private static void setMake(int cnt, int[] list, boolean[] chk) {
		// TODO Auto-generated method stub
		if (cnt == _MEMBER + 1) {
//			System.out.println(Arrays.toString(list));
			looplist.add(list.clone());
		}

		else {
			if (cnt == 4) {
				list[4] = 1;
				chk[1] = true;
				setMake(cnt + 1, list, chk);
			} // 0번은 항상 4번타자
			for (int loop = 2; loop <= _MEMBER; loop++) {
				if (chk[loop]) {
					continue;
				}
				list[cnt] = loop;
				chk[loop] = true;
				setMake(cnt + 1, list, chk);
				chk[loop] = false;
			}
		}

	}

}