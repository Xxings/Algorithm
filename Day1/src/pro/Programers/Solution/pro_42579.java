package pro.Programers.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro_42579 {
	public static void main(String[] args) {
		Solution test = new Solution();
		String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
		int[] plays = new int[] {500, 600, 150, 800, 2500};
		System.out.println(
				Arrays.toString(test.solution(genres, plays)));
	}
	
	static class Solution {
		//copy
		static int[] Tplays;
	    public int[] solution(String[] genres, int[] plays) {
	    	Tplays = plays;
	        //id : idx
	        //genres : String cmp;	1<=n<=10000
	        //plays : value
	        
	        //totalHashTable
	        Map<String, Pair> hashtable = new HashMap<>();	//List의 0번째는 항상 total
	        Pair pair;
	        for (int idx = 0; idx < genres.length; idx++) {
	        	String key = genres[idx];
				if(hashtable.containsKey(key)) {
					pair = hashtable.get(key);
					pair.add(plays[idx], idx);
				}
				else {	//없는 경우 새로 추가
					hashtable.put(key, new Pair(plays[idx],idx));
				}
			}
	        
	        System.out.println(hashtable);
	        for (Pair val : hashtable.values()) {
				val.sort();
			}	//값정렬
//	        
//
//	        List<Map.Entry<String, Pair>> entries = new ArrayList<>(hashtable.entrySet());
//	        
//	        Collections.sort(entries, new Comparator<Entry<String,Pair>>() {
//				@Override
//				public int compare(Entry<String, Pair> o1, Entry<String, Pair> o2) {
//					// TODO Auto-generated method stub
//					return o2.getValue().totalnum - o1.getValue().totalnum;
//				}
//			});
//	        
//	        Map<String, Pair> sortedMap = new LinkedHashMap<>();
//	        for (Map.Entry<String, Pair> entry: entries) {
//	        	sortedMap.put(entry.getKey(), entry.getValue());
//	        }
	        
	        //정렬완료
//	        System.out.println(Arrays.toString(sortedMap.values().toArray()));
//	        List<Integer> ans = new ArrayList<>();
//	        for (Pair val : sortedMap.values()) {
//				for(int idx = 0; idx < val.idxSet.size(); idx++) {
//					if(idx>1) break;
//					ans.add(val.idxSet.get(idx));
//				}
//			}
//	        answer = new int[ans.size()];
//	        int idx = -1;
//	        for (Integer val : ans) {
//				answer[++idx] = val;
//			}
	        
	        List<Pair> sortedList = new ArrayList<>(hashtable.values());
	        Collections.sort(sortedList);
	        List<Integer> ans = new ArrayList<>();
	        for (int idx = 0; idx < sortedList.size(); idx++) {
	        	pair = sortedList.get(idx);
				for (int i = 0; i < pair.idxSet.size(); i++) {
					if(i==2) break;
					ans.add(pair.idxSet.get(i));
				}
			}
	        int[] answer = new int[ans.size()];
	        for (int i = 0; i < answer.length; i++) {
				answer[i] = ans.get(i);
			}
	        return answer;
	    }
		class Pair implements Comparable<Pair> {
	    	int totalnum;
	    	List<Integer> idxSet;
			protected Pair(int totalnum, int idx) {
				idxSet = new ArrayList<>();
				this.totalnum = totalnum;
				idxSet.add(idx);
			}
			public void add(int value, int idx) {
				this.totalnum += value;
				idxSet.add(idx);
			}
			public void sort() {
				idxSet.sort((a,b)->
				{
					if(Tplays[a]==Tplays[b])
						return a-b;
					else
						return Tplays[b]-Tplays[a];
				}
						);
			}
			@Override
			public String toString() {
				return "Pair [totalnum=" + totalnum + ", idxSet=" + idxSet + "]";
			}
			@Override
			public int compareTo(Pair o) {
				// TODO Auto-generated method stub
				return o.totalnum-this.totalnum;
			}
	    }
	    
	    ///end of copy
	}
}
