package pro.sw_expert.Solution;

public class programers_43162_0821 {
	public static void main(String[] args) {
		int[][] input = new int[][] {
			{1,0,0,1}
			,{0,1,1,1}
			,{0,1,1,0}
			,{1,1,0,1}
			};
		System.out.println(solution(input,input.length));
	}
	//disjoint_sets
	public static int solution(int[][] computers, int n) {
		int answer = 0;
		int[] p = new int[n];
		for(int idx=0; idx<n; idx++) {
			p[idx] = idx;
		}
        for (int from = 1; from < n; from++) {
        	for (int to = 0; to < from; to++) {
            	if(computers[from][to] == 1) {
            		int parent = to;
            		while(parent != p[parent]) {
            			parent = p[parent];
            		}
            		p[parent] = from;
            	}
    		}
		}
        
        for (int idx = 0; idx < n; idx++) {
        	if(idx == p[idx]) answer++;
		}
        return answer;
	}
}
