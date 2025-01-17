/*
25,328 kb
메모리
120 ms
실행시간
 * 
 */
package pro.sw_expert.Solution;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class sw_1494_0902_sol3 {
    public static int[][] map;
    public static int sumX;
    public static int sumY;
    public static long min;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            int N = Integer.parseInt(br.readLine()); // 지렁이 수, N(2 ≤ N ≤ 20, N은 짝수)
            map = new int[N][2];
            sumX = 0;
            sumY = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                map[i][0] = Integer.parseInt(st.nextToken()); // -100,000 <= X <= 100,000
                map[i][1] = Integer.parseInt(st.nextToken()); // -100,000 <= Y <= 100,000
                sumX += map[i][0];
                sumY += map[i][1];
            }
            min = Long.MAX_VALUE;
            comb(N-1,N/2-1, map[N-1][0], map[N-1][1]);	//실행 절반으로 구하기
             
            sb.append('#').append(testCase).append(' ').append(min).append('\n');
        } // end of for testCase
        System.out.print(sb);
    } // end of main
    public static void comb(int n, int r, int selX, int selY) {
        if (r == 0) {
            int unselX = sumX - selX;
            int unselY = sumY - selY;
            long vX = (long)selX-unselX;
            long vY = (long)selY-unselY;
            long v = vX * vX + vY * vY;
            if (min > v) min = v;
            return;
        } else if (n < r) {
            return;
        } else {
            comb(n-1, r-1, selX+map[n-1][0], selY+map[n-1][1]);	//선택한 경우
            comb(n-1, r, selX, selY);	//선택하지 않은 경우
        }
    }
} // end of class