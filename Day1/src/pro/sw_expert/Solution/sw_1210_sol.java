package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class sw_1210_sol {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
         
        final int N = 100;
         
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
 
            final int[][] arr = new int[N][N];
             
            int startJ = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 2) {
                        startJ = j;
                    }
                }
            }
                     
            int curJ = startJ;
            for (int i = N-1; i >= 0; i--) {
                if(curJ != 0 && arr[i][curJ - 1] == 1) {
                    while(curJ != 0 && arr[i][curJ - 1] == 1) {
                        curJ -= 1;                      
                    }
                }
                else if(curJ != N-1 && arr[i][curJ + 1] == 1) {
                    while(curJ != N-1 && arr[i][curJ + 1] == 1) {
                        curJ += 1;                      
                    }
                }
            }
            sb.append("#" + tc + " " + curJ + "\n");
        }       
        System.out.println(sb.toString());
         
         
    }
 
}