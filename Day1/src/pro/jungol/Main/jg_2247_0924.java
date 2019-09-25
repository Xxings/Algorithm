/* 끝 기준
 * 메모리 11MB	시간 217ms
 * 
 * 시작 기준으로 정렬하면?
 * 메모리 11MB	시간 226ms
 * 
 * : 회의실 배정과 다른 문제 
 *  -> 회의실 배정은 시작기준으로 정렬시 overlap이 안되면서 작은 것들을 모아야하기 때문에 (끝 정렬 / 시작 정렬)을 했었으나
 *   도서관 문제는
 *  -> overlap에 대해서 계속 합쳐나가는 방식이기때문에 시작/종료 정렬만 하면 됨
 */
package pro.jungol.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class jg_2247_0924 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] answer = new int[2];	//가장 긴 시간 0 / 1
		int N = stoi(br.readLine());
		
		//Sort를 위한 값 입력받기
		List<Pair> lists = new ArrayList<Pair>(N); 
		
		int stTime, edTime;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stTime = stoi(st.nextToken());
			edTime = stoi(st.nextToken());
			lists.add(new Pair(stTime,edTime));
		}
		Collections.sort(lists);
//		System.out.println(lists);	//끝 기준 내림차순
		
		/////// 첫번째 기준
		int curTime=-1;
		Pair person = lists.get(0);
		int plusSt=person.stTime;
		int curEnd=person.edTime;
		
		/////// 두번째 기준
		int sideTime = -1;
		
		for (int idx = 1; idx < N; idx++) {
			person = lists.get(idx);

			if(person.edTime >= plusSt ) {
//				System.out.println("1:"+plusSt + " ~ "+ curEnd);
				//시작 낮은값으로 갱신
				if(plusSt > person.stTime) {
					plusSt = person.stTime;
				}
			}
			else {
				//조건 : 새로시작할때
				curTime = curEnd - plusSt;
				if(answer[0]<curTime) {
//					System.out.println(plusSt + " ~ "+ curEnd);
					answer[0]=curTime;
				}
				sideTime = plusSt - person.edTime;
				if(answer[1]<sideTime) {
					answer[1]=sideTime;
				}
				//다시시작
				plusSt = person.stTime;
				curEnd = person.edTime;
			}
			
			if(idx == N-1) {
				curTime = curEnd - plusSt;
				if(answer[0]<curTime) {
					answer[0]=curTime;
				}
			}
		}
		
		System.out.print(answer[0]+" "+answer[1]);
	}
	public static int stoi(String str){	 
		return Integer.parseInt(str);
	}
	
	private static class Pair implements Comparable<Pair>{
		int stTime;
		int edTime;
		protected Pair(int st, int ed) {
			super();
			this.stTime = st;
			this.edTime = ed;
		}
		@Override
		public String toString() {
			return "Pair [st=" + stTime + ", ed=" + edTime + "]";
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.edTime-this.edTime;
		}
		
	}
}
