package codingtest.programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12938#
public class BestGroup {

	public static void main(String[] args) {

	}
	public int[] solution(int n, int s) {

		if (s < n)
			return new int[] {-1};

		int[] answer = new int [n];
		int rest = s % n;
		int divide = s / n;
		for (int i = 0; i < answer.length; i++){
			answer[i] = divide;
		}
		if (rest != 0){
			int answerIndex = n - 1;
			while (rest != 0){
				answer[answerIndex]++;
				rest--;
				answerIndex = Math.abs(answerIndex - 1) % n;
			}
		}
		return answer;
	}

}
