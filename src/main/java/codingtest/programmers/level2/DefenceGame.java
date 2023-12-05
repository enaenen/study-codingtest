package codingtest.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class DefenceGame {
	//https://school.programmers.co.kr/learn/courses/30/lessons/142085

	public static void main(String[] args) {

	}

	public static int solution(int n, int k, int[] enemy) {
		int totalRounds = 0;
		int hp = n;
		PriorityQueue<Integer> clearWithoutK = new PriorityQueue<>(Collections.reverseOrder());

		for (int enemyAttackPoint : enemy) {
			hp -= enemyAttackPoint;
			clearWithoutK.offer(enemyAttackPoint);

			if (hp < 0) {
				if (k > 0 && !clearWithoutK.isEmpty()) {
					Integer maxValue = clearWithoutK.remove();
					hp += maxValue;
					k--;
				} else {
					break;
				}
			}
			totalRounds++;
		}
		return totalRounds;
	}
}
