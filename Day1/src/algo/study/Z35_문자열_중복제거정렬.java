package algo.study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Z35_문자열_중복제거정렬 {
	public static void main(String[] args) {
		// TreeSet
		TreeSet<String> ts = new TreeSet<>(
				new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						//비교를 많이하므로 비교연산자는 가까운 지역변수로
						return 0;
					}
				}
		); 
		ts.add("banana");
		ts.add("banana");
		ts.add("zoo");
		ts.add("banana");
		//삽입 logN
		
		//HASHSET 정렬 ->list
		HashSet<String> hs = new HashSet<>();
		hs.add("banana");
		hs.add("banana");
		hs.add("zoo");
		hs.add("banana");
		LinkedList<String> list = new LinkedList<>(hs);
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				//비교를 많이하므로 비교연산자는 가까운 지역변수로
				return 0;
			}
		});
		
		//HASHSET 정렬 ->list
		LinkedList<String> ll = new LinkedList<>();
				ll.add("banana");
				ll.add("banana");
				ll.add("zoo");
				ll.add("banana2");
				Collections.sort(list,new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						//비교를 많이하므로 비교연산자는 가까운 지역변수로
						return 0;
					}
				});
		TreeSet<String> test = new TreeSet<>(ll);
		System.out.println(test);
		
		String srr[] = new String[3];
		srr[0] = "banana";
		srr[1] = "zoo";
		srr[2] = "apple";
		Arrays.sort(srr);	//오름차순
		
//		Arrays.sort(srr,(a,b)->a.length()==b.length()?a.compareTo(b):a.length()-b.length());
		Arrays.sort(srr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				//비교를 많이하므로 비교연산자는 가까운 지역변수로
				return 0;
			}
		});
	}
}
