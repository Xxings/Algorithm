package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 사용자의 입력을 받는 방법
 * 1. BufferedReader
 * > (버퍼리더로 대체) : 33,960 kb | 메모리 |173 ms | 실행시간
 *   공백을 space로
 * > (split->tokenizer) : 30,600 kb | 메모리 | 154 ms
 *   스플릿을 토큰으로 대체 구분
 * > (toeknizer->charAt() : 
 필요한 부분만 꺼내서 사용!
 * 2. Scanner : 101,648 kb |메모리 355 ms 실행시간(for{nextInt();})
 *  > nextLine(); 엔터를 입력할 때까지 한 줄을 입력받아서, 엔터 전 문자열만 취한다.	//버퍼 조심..
 *  > next기본형타입(); // 앞부분의 whiteSpace(탭, 빈칸, 엔터)를 제거하고 원하는 타입의 데이터를 가져간다.
 *  > next(); // 문자열로 리턴
 *  
 *  
 * 3. JOptionPane swing 에서 사용
 *  > JOptionPane.showInputDialog("이름을 입력하세요"); // 문자열로만 리턴
 */

public class sw_1210_sol1_buffer_sol2 {
	public static void main(String[] args) throws IOException {
		
		int[][] map;
		int result;
		
		//자바초기버전 부터 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//키보드로 부터 입력 받을 객체를 준비
//		String age = br.readLine(); //엔터를 입력할 때까지 한줄을 받아감, 엔터를 소비, 예외처리를 해야한다.(throw / try~catch)	// throws IOException -> throws Exception(상위클래스라 더 빠름)
		
		
//		Scanner sc = new Scanner(System.in);
		for (int loop = 1; loop <= 10; loop++) {
//			int Tcase = sc.nextInt();
			int Tcase = Integer.parseInt(br.readLine());
			result = 0;
			map = new int[100][100];	//맵생성
			for (int row = 0; row < map.length; row++) {
//				String s = br.readLine();	//100개의 숫자 한줄을 입력받음
//				String[] strs = s.split(" ");		//Split도 오래걸림
				
				StringTokenizer st = new StringTokenizer(br.readLine()," ");	//Token으로 나누기
				
				for (int col = 0; col < map[row].length; col++) {
//					map[row][col] = Integer.parseInt(strs[col]);
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			int goal_num = 0;
			for (int col = 0; col < map[map.length-1].length; col++) {
				if(map[map.length-1][col] == 2)
					goal_num = col;		// 도착점 [lenght-1, x]
			}
			
			//0 출발점까지 달리기
			int cur_row = map.length-1;
			int cur_col = goal_num;
			boolean arrow = true;
			while(cur_row!=0) {
				while(cur_col>0 && map[cur_row][cur_col-1]==1) {	//좌로
					cur_col--;
					arrow = true;
				}
				if(!arrow) {
					while(cur_col<map.length-1 && map[cur_row][cur_col+1]==1) {	//우로
						cur_col++;
					}
				}
				cur_row--;
				arrow =false;
			}
			result = cur_col;
			
			System.out.printf("#%d %d \n", Tcase, result);
		}
	} // end of main
	
}
