package pro.sw_expert.Solution;
import java.util.Scanner;

public class sw_3307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int case_no= sc.nextInt();

		for(int loop = 0; loop<case_no; loop++) {
			int case_lenght = sc.nextInt();

			int[] testcase = new int[case_lenght];
			
			for(int i=0; i<case_lenght; i++) {
				testcase[i] = sc.nextInt();
			}
			
			int result = Calc(testcase,0);
			for(int i = 1; i<case_lenght-result+1; i++) {
				int temp=Calc(testcase,i);
				if(result < temp)
					result = temp;
			}
			System.out.println("#"+(loop+1)+" "+result);
		}
	}	//end of main
	public static int Calc(int[] testcase,int n) {
		int pt=0;
		int pre_pt = 0;
		int result = 0;
		int[] Tarray = new int[testcase.length];
		int k = 0;
		for (int i = n; i < testcase.length; i++) {
			if( i == n ) {
				pt = testcase[i];
				result ++;
			}
			
			else if (pt > testcase[i]) {
				if(pre_pt < testcase[i]) {
					pt = testcase[i];
				}
			}
			
			else {
				pre_pt = pt;
				pt = testcase[i];
				Tarray[k++] = pt;
				result ++;
			}
		} // end of for
		
		return result;
	}	//end of Calc
	
} //end of class
