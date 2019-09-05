/*
 * 27,284 kb
메모리
105 ms
실행시간
 * 
 */
package pro.sw_expert.Solution;

import java.util.*;
import java.lang.Math;
 
public class sw_3459_0903_sol_tree {
    static Scanner scnr = new Scanner(System.in);
    static double n;
    static boolean even;
    static String winner;
    static String turn;
     
     
    public static String whoseTurn(double n) {
        double ord = Math.floor(Math.log(n)/Math.log(2.0))+1;
        int ordInt = (int) ord;
        if (ord%2 == 0) {
            return "Bob";
        } else {
            return "Alice";
        }
    }
     
    public static String path(double n) {
        String pathToN = "";
         
        int intN = (int) n;
         
        while (intN > 1) {
            if (intN%2 == 0) {
                pathToN = "L" + pathToN;
            } else {
                pathToN = "R" + pathToN;
            }
            intN /= 2;
        }
        return pathToN;
    }
     
    public static String whoIsWinner(String turn, String pathToN) {
        boolean winnerIsA = false;
        boolean winnerIsB = false;
        if (turn == "Alice") {
            for (int i=0; i<pathToN.length(); i+=2) {
                if (pathToN.charAt(i) == 'L') {
                    winnerIsA = true;
                }
            }
            if (winnerIsA) {
                return "Alice";
            } else {
                return "Bob";
            }
        } else {
            for (int i=1; i<pathToN.length(); i+=2) {
                if (pathToN.charAt(i) == 'L') {
                    winnerIsB = true;
                }
            }
            if (winnerIsB) {
                return "Bob";
            } else {
                return "Alice";
            }
        }
    }
    public static void main(String[] args) {
         
        int testCases = scnr.nextInt();
        for (int test=1; test<=testCases; test++) {
            String pathToN;
            n = scnr.nextDouble(); // 양의 정수 n
            turn = whoseTurn(n); // 누구의 차례에 n이 속하는가?
            pathToN = path(n); // n에 이르는 경로는 어떻게 되는가?
            winner = whoIsWinner(turn, pathToN); // 누가 승자인가?
            System.out.println("#"+test+" "+winner);
        }
         
    }
 
}