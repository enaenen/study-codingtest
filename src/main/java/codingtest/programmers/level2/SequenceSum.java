package codingtest.programmers.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class SequenceSum {

	public static int[] solution(int[] sequence, int k) {
		int[] answer = new int[]{0, sequence.length - 1};

		int start = 0;
		int end = start;

		int sum = sequence[start];
		while (start < sequence.length && start <= end) {
			if (k == sum){
				if (start - end < answer[1] - answer[0]) {
					answer[0] = start;
					answer[1] = end;
				}
				sum -= sequence[start++];
			}
			else if (sum < k) {
				if (sequence.length <= end)
					break;
				end++;
				sum += sequence[end];
			}
			else if (sum > k){
				sum -= sequence[start];
				start++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		//1,2,3,4,5 // 7
		//2+5
		int[] solution1 = solution(new int[]{1, 2, 3, 4, 5}, 7);
		int[] solution2 = solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 4);
		int[] solution3 = solution(new int[]{2, 2, 2, 2, 2}, 6);

		print(solution1);
		System.out.println();
		print(solution2);
		System.out.println();
		print(solution3);
	}

	private static void print(int[] solution3) {
		for (int i : solution3) {
			System.out.println(i);
		}
	}

}
