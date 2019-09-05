package pro.Programers.Solution;

public class programers_43165_0821 {
	public static void main(String[] args) {
		int[] input = new int[] { 1, 1, 1, 1, 1 };
		System.out.println(solution(input, 3));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		int n = numbers.length;
		for (int bit = 0; bit < (1 << n); bit++) {
			int result = 0;
			for (int chk = 0; chk < n; chk++) {
				if ((bit & (1 << chk)) > 0)
					result -= numbers[chk];
				else
					result += numbers[chk];
			}
			if (result == target)
				answer++;
		}

		return answer;
	}

}
