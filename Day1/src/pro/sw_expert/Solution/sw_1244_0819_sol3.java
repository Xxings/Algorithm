//조합풀이
//101,376kb
//메모리
//315ms
//실행시간
package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class sw_1244_0819_sol3 {
     
    static int[] arr = {0, 1, 2, 3, 4, 5};
    static int[] trr = new int[6];
    static boolean[][] check;
     
    static void f(int n, int r, String s, int cnt) {
        if (r == 0) {
            int lI = trr[0];
            String lS = Character.toString(s.charAt(lI));
             
            int rI = trr[1];
            String rS = Character.toString(s.charAt(rI));
             
            String newStr = "";
             
            for (int i = 0; i < s.length(); i++) {
                if (i == lI) {
                    newStr += rS;
                } else if (i == rI) {
                    newStr += lS;
                } else {
                    newStr += Character.toString(s.charAt(i));
                }
            }
            int target = Integer.parseInt(newStr);
            check[cnt+1][target] = true; 
            return;
        } else if (n < r) {
            return;
        }
         
        trr[r-1] = arr[n-1];
        f(n-1, r-1, s, cnt);
        f(n-1, r, s, cnt);
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            String str = br.readLine();
            String num = str.split(" ")[0];
            int cnt = Integer.parseInt(str.split(" ")[1]);
            check = new boolean[cnt+1][1000000];
             
            f(num.length(), 2, num, 0);
            for (int i = 1; i < cnt; i++) {
                for (int j = 1; j < 1000000; j++) {
                    if (check[i][j]) {
                        str = Integer.toString(j);
                        f(str.length(), 2, str, i);
                    }
                }
            }
             
            int target = 0;
            for (int j = 999999; j > 0; j--) {
                if (check[cnt][j]) {
                    target = j;
                    break;
                }
            }
            System.out.printf("#%d %d\n", tc, target);
        }
    }
}