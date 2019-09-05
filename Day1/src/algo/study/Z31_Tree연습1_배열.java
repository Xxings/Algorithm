package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Z31_Tree연습1_배열 {
	static int V;
	static int[] graph;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		graph = new int[V];
		create_Graph(br.readLine());

	}
}
