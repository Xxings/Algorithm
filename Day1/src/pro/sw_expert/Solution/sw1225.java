package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 
1
9550 9556 9550 9553 9558 9551 9551 9551 
2
2419 2418 2423 2415 2422 2419 2420 2415 
3
7834 7840 7840 7835 7841 7835 7835 7838 
4
4088 4087 4090 4089 4093 4085 4090 4084 
5
2945 2946 2950 2948 2942 2943 2948 2947 
6
670 667 669 671 670 670 668 671 
7
8869 8869 8873 8875 8870 8872 8871 8873 
8
1709 1707 1712 1712 1714 1710 1706 1712 
9
10239 10248 10242 10240 10242 10242 10245 10235 
10
6580 6579 6574 6580 6583 6580 6577 6581  
 */
public class sw1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int tcase = 1;		
//		String src = "6580 6579 6574 6580 6583 6580 6577 6581";

		for (int loop = 1; loop <= 10; loop++) {

			int tcase = Integer.parseInt(br.readLine());
			String src = br.readLine();

			String[] input = src.split(" ");
			int[] iinput = new int[8];
			int[] ans = new int[8];

			for (int i = 0; i < iinput.length; i++) {
				iinput[i] = Integer.parseInt(input[i]);
			}
			int target = iinput[0];

			int min = Integer.MAX_VALUE;
			for (int data : iinput) {
				if (min > data)
					min = data;
			}

			int mod = ((min / 15) - 1) * 15;

			for (int i = 0; i < iinput.length; i++) {
				iinput[i] -= mod;
			}

//		System.out.println(Arrays.toString(iinput));

			int idx = 0;
			int minus = 1;
			while (true) {
				iinput[idx] -= minus;

				if (iinput[idx] <= 0) {
					iinput[idx] = 0;
					break;
				}

				idx++;
				minus++;
				if (idx == 8) {
					idx %= 8;
				}
				if (minus == 6) {
					minus %= 5;
				}
			}
			for (int i = 0; i < iinput.length; i++) {
				ans[(7 + i - idx) % 8] = iinput[i];
			}

//		System.out.println(tcase+": "+Arrays.toString(ans));
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(tcase);
			for (int i = 0; i < ans.length; i++) {
				sb.append(" ");
				sb.append(ans[i]);
			}
			System.out.println(sb.toString());
		}
	}
}
