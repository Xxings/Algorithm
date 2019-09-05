package algo.study;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Z29_202Revisit연습문제 {
	//24명 원으로 0~23
	//술래 2뽑기 출력
	// 0번 제거 // 오른차순으로 제거
	//2칸뛰고 1명 제거
	//0,3,6,9
	public static void main(String[] args) {
		List<Integer> member = new LinkedList<>();
		int N=24;
		for (int no = 0; no < N; no++) {
			member.add(no);
		}
		
		int idx = 0;
		while(member.size()!=2) {
			member.remove(idx);
			idx+=2;
			if(idx>=member.size())
				idx%=member.size();
		}
		System.out.println(member.get(0)+" "+member.get(1));
	}
}
