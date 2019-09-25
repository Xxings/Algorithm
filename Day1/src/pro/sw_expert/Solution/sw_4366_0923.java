package pro.sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_4366_0923 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int Tcase = 1; Tcase <= T; Tcase++) {
			long ans = -1;
			sb.append("#").append(Tcase).append(" ");

			String binary = br.readLine();
			String ternary = br.readLine();

			int nBi = binary.length();
			int nTri = ternary.length();

			long iBi = convert(binary,2); // 숫자로
			long iTri = convert(ternary,3); // 숫자로
			long cmpBi;
			long cmpTri;
			end: for (int idxBi = nBi-1; idxBi >= 0; idxBi--) {
				cmpBi = (binary.charAt(idxBi) == '1')? iBi-(long)Math.pow(2, nBi-1 - idxBi):iBi+(long)Math.pow(2, nBi-1 -idxBi);
				// end of convert Binary
				for (int idxTri = nTri-1; idxTri >= 0; idxTri--) {
					switch(ternary.charAt(idxTri)) {
					case '0':
						cmpTri = iTri+(long)Math.pow(3, nTri-1 - idxTri);
						if(cmpTri == cmpBi) {
							ans = cmpTri;
							break end;
						}
						cmpTri = iTri+(long)Math.pow(3, nTri-1 - idxTri)*2;
						if(cmpTri == cmpBi) {
							ans = cmpTri;
							break end;
						}
						break;
					case '1':
						cmpTri = iTri-(long)Math.pow(3, nTri-1 - idxTri);
						if(cmpTri == cmpBi) {
							ans = cmpTri;
							break end;
						}
						cmpTri = iTri+(long)Math.pow(3, nTri-1 - idxTri);
						if(cmpTri == cmpBi) {
							ans = cmpTri;
							break end;
						}
						break;
					case '2':
						cmpTri = iTri-(long)Math.pow(3, nTri-1 - idxTri);
						if(cmpTri == cmpBi) {
							ans = cmpTri;
							break end;
						}
						cmpTri = iTri-(long)Math.pow(3, nTri-1 - idxTri)*2;
						if(cmpTri == cmpBi) {
							ans = cmpTri;
							break end;
						}
						break;
					}
				}
				// end of convert Teranry
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);

	}


	private static long convert(String data, int n) {
		// TODO Auto-generated method stub
		long result = 0L;
		for (int idx = 0; idx < data.length(); idx++) {
			if (data.charAt(idx) == '1') {
				result += 1L;
			} else if (data.charAt(idx) == '2') {
				result += 2L;
			}
			result *= n;
		}
		result /= n;
		return result;
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
