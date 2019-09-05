package pro.sw_expert.Solution;
import java.util.Scanner;

/**
 * 1289. 원재의 메모리 복구하기
 * (https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE)
 * @author student
 *
 */
public class sw_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int case_no= sc.nextInt();

		String[] testcase = new String[case_no];
		for(int i=0; i<case_no; i++) {
			testcase[i] = sc.next();
		}

		for (int i = 0; i < testcase.length; i++) {
			int result = 0;
			char flag = '0';
			String data = testcase[i];

			//case 부
			for (int j = 0; j < data.length(); j++) {
				if(data.charAt(j) != flag) {
					flag = data.charAt(j);
					result += 1;
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
	}
}
