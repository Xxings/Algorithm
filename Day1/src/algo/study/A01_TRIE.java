package algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A01_TRIE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			answer += (trie.search(br.readLine()))?1:0;
		}
		
		System.out.print(answer);
	}
	
	/*
	 * 영문자 26진 트리
	 * 
	 */
	public static class Trie {
		private final static int ALPABET = 26;
		Trie[] next;
		
		protected Trie() {
			next= new Trie[ALPABET];
		}
		protected void add(String str) {
			if(str.length()==0)
				return;
			int data = str.charAt(0)-'a';
			if(next[data]==null) {
				next[data]=new Trie();
			}
			next[data].add(str.substring(1));
		}
		
		protected boolean search(String str) {
			if(str.length()==0)
				return true;
			int data = str.charAt(0)-'a';
			if(next[data] == null) {
				return false;
			}else{
				return next[data].search(str.substring(1));
			}
		}
	}
}
