package codingtest.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class QueueEqualizing {

	public static void main(String[] args) {
		System.out.printf("expect: 2, actual: %d",
				solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
		System.out.println();
		System.out.printf("expect: 7, actual: %d",
				solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
		System.out.println();
		System.out.printf("expect: -1, actual: %d",
				solution(new int[]{1, 1}, new int[]{1, 5}));
	}

	public static long sumElement(int[] queue) {
		long result = 0L;
		for (long i : queue) {
			result += i;
		}
		return result;
	}

	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long sumQ1 = sumElement(queue1);
		long sumQ2 = sumElement(queue2);

		for (int i = 0; i < queue1.length; i++) {
			q1.offer(queue1[i]);
			q2.offer(queue2[i]);
		}

		int maxRoundings = (queue1.length + queue2.length) * 2;
		while (sumQ1 != sumQ2) {
			if (answer > maxRoundings) {
				return -1;
			}
			if (sumQ1 > sumQ2) {
				Integer dequeuedNumber = q1.remove();
				sumQ1 -= dequeuedNumber;
				sumQ2 += dequeuedNumber;
				q2.offer(dequeuedNumber);
			} else if (sumQ2 > sumQ1) {
				Integer dequeuedNumber = q2.remove();
				sumQ1 += dequeuedNumber;
				sumQ2 -= dequeuedNumber;
				q1.offer(dequeuedNumber);
			} else {
				return answer;
			}
			answer++;
		}

		return answer;
	}

	public static int solution_old(int[] queue1, int[] queue2) {
		int answer = -1;

		Queue<Integer> realQ1 = new LinkedList<>();
		Queue<Integer> realQ2 = new LinkedList<>();
		int total = Arrays.stream(queue1).sum() + Arrays.stream(queue2).sum();
		System.out.println("total = " + total);
		// INIT
		int realQ1Sum = 0;
		int realQ2Sum = 0;
		for (int i : queue1) {
			realQ1.offer(i);
			realQ1Sum += i;
		}
		for (int i : queue2) {
			realQ2.offer(i);
			realQ2Sum += i;
		}

//		printQueue(queue1, realQ1);
//		printQueue(queue2, realQ2);
		int q1MoveCount = 0;
		int q2MoveCount = 0;

		while (true) {
			if (realQ1Sum == total / 2 && realQ2Sum == total / 2) {
				answer = q1MoveCount + q2MoveCount;
			}
			if (q1MoveCount > queue1.length || q2MoveCount > queue2.length) {
				break;
			}
			if (realQ1Sum > total / 2) {
				int polled = realQ1.remove();
				realQ1Sum -= polled;
				q1MoveCount++;

				realQ2.offer(polled);
				realQ2Sum += polled;
			}
			if (realQ2Sum > total / 2) {
				int polled = realQ2.remove();
				realQ2Sum -= polled;
				q2MoveCount++;

				realQ1.offer(polled);
				realQ1Sum += polled;
			}

		}

		return answer;
	}

	private static void printQueue(int[] queue1, Queue<Integer> realQ1) {
		for (int i = 0; i < queue1.length; i++) {
			System.out.println(realQ1.remove());
		}
	}

}
