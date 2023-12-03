package codingtest.programmers.level2;

public class QueueEqualizing {

	public static void main(String[] args) {
		System.out.printf("expect: 2, actual: %d",
				solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
		System.out.printf("expect: 7, actual: %d",
				solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
		System.out.printf("expect: -1, actual: %d",
				solution(new int[]{1, 1}, new int[]{1, 5}));
	}

	public static int solution(int[] queue1, int[] queue2) {
		int answer = -2;
		return answer;
	}

}
