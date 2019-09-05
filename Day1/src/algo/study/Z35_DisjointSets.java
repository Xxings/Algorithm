/**
 *  서로소 집합 ( = 상호배타집합)
 *  두 원소가 서로 같은 그룹인지 다른 그룹인지를 빠르게 판단 할 수 있는 방법
 * 
 */
package algo.study;

import java.util.Arrays;

public class Z35_DisjointSets {
	public static int[] p = new int[10];

	// 성능개선 : +add : rank
	public static int[] rank = new int[10];

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			makeSet(i);
		};

		print_set(p);

		union(0, 1);
		print_set(p);
		union(2, 3);
		print_set(p);
		union(0, 3);
		print_set(p);
	}

	/** 일반멤버의 포함하는 집합의 대표자를 찾아서 리턴 */
	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if (p[x] == x) {
			return x;
		} else {
			//rank 값 수정
			return p[x] = findSet(p[x]);	//Path Compression
		}
	}

	/** 일반멤버 x, y를 포함하는 두 집합을 통합 */
	private static void union(int x, int y) {
		// TODO Auto-generated method stub
		int px = findSet(x);
		int py = findSet(y);

		if (px == py) { // 같은 집합일때도 돌리면 StackOverflowError발생할 수 있음.
			return;
		} else { // 다른 집합인 경우 병합
			link(px, py);

		}
	}
	
	/** x의 대표자의 집합과 y의 대표자의 집합을 rank 값 기준으로 합침*/
	private static void link(int px, int py) {
		// TODO Auto-generated method stub
		if (rank[px] == rank[py]) {
			p[px] = p[py];
			rank[py]++; // 깊이가 1개 증가함
		} else if (rank[px] > rank[py]) {
			p[py] = px;
		} else { // 작을경우
			p[px] = py;
		}
	}


	/** ㅌdml 대표자의 집합과 y의 대표자의 집합을 rank값을 기준으로 합침 */

	private static void print_set(int[] p2) {
		// TODO Auto-generated method stub
		System.out.print(" index \t: ");
		for (int i = 0; i < p2.length; i++) {
			System.out.printf("%2d", i);
		}
		System.out.println();

		System.out.print(" parent\t: ");
		for (int i = 0; i < p2.length; i++) {
			System.out.printf("%2d", p[i]);
		}
		System.out.println();
		
		System.out.print(" rank \t: ");
		for (int i = 0; i < p2.length; i++) {
			System.out.printf("%2d", rank[i]);
		}
		System.out.println();
		System.out.println();
		
	}

	/** 멤버 x를 포함하는 새로운 집합을 생성하는 메서드 */
	private static void makeSet(int x) {
		// TODO Auto-generated method stub
		p[x] = x; // 부모를 표시, 대표자인 경우 -1 or 자기자신의 idx로 표시 가능
	}
}
