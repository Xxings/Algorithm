package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class sw_1223_0730 {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        for (int tc = 1; tc <= 10; tc++) {
 
            br.readLine();
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            Stack<Character> list = new Stack<>();
            Stack<Integer> result = new Stack<>();
            
            for (char c : s.toCharArray()) {
 
                switch (c) {
                case '(':
                    stack.add(c);
                    break;
                case '*':
                    while (!stack.isEmpty() && stack.peek() == '*') {
                        list.add(stack.pop());
                    }
                    stack.add(c);
                    break;
                case '+':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        list.add(stack.pop());
                    }
                    stack.add(c);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        list.add(stack.pop());
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
 
                default:
                    list.add(c);
                    break;
                }
            }
 
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
 
            for (char c : list) {
                switch (c) {
                case '+':
                    int a = result.pop();
                    int b = result.pop();
                    result.add(a + b);
                    break;
                case '*':
                    int cc = result.pop();
                    int d = result.pop();
                    result.add(cc * d);
                    break;
                default:
                    result.add(c - '0');
                    break;
                }
            }
            sb.append("#").append(tc).append(" ").append(result.pop()).append("\n");
        }
        System.out.println(sb.toString());
    }
}