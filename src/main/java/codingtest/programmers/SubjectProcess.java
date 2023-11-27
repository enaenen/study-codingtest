package codingtest.programmers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class SubjectProcess {

	static class Subject {

		String name;
		int remainTime;

		public Subject(String name, int remainTime) {
			this.name = name;
			this.remainTime = remainTime;
		}
	}

	public static void main(String[] args) {
		String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"},
				{"math", "12:30", "40"}};
		String[][] plans2 = {{"science", "12:40", "50"}, {"music", "12:20", "40"},
				{"history", "14:00", "30"}, {"computer", "12:30", "100"}};
		String[] solution = solution(plans2);
		for (String s : solution) {
			System.out.println(s);
		}
	}

	public static String[] solution(String[][] plans) {
		String[] answer = {};
		ArrayList<String> result = new ArrayList<>();

		//beforeSubjectStartingTime = plans[0][1];
		Arrays.sort(plans, Comparator.comparing(plan -> plan[1]));

		//printing
//		for (int i = 1; i < plans.length; i++) {
//			for (int j = 0; j < plans[i].length; j++) {
//				System.out.println(plans[i][j]);
//			}
//		}

		//sort plans plans[N][1] 기준 오름차순

		//이전시간 =  plans[0][1];
		Deque<Subject> stack = new LinkedList<>();
		LocalTime beforeWorkTime = LocalTime.parse(plans[0][1],
				DateTimeFormatter.ofPattern("HH:mm"));

		for (int i = 1; i < plans.length; i++) {
			//이전시간 = 현재시간;

			// 현재시간 = plans[i][1]
			LocalTime currentTime = LocalTime.parse(plans[i][1],
					DateTimeFormatter.ofPattern("HH:mm"));
			// 작업시간 = 현재시간 - 이전시간
			int timeDifference = (int) java.time.Duration.between(beforeWorkTime, currentTime)
					.toMinutes();
			beforeWorkTime = currentTime;


			//작업시간 == 0
			if (timeDifference == 0) {
				result.add(plans[i-1][0]);
			}
			//작업시간 < plans[i][2]
			else if (timeDifference < Integer.parseInt(plans[i-1][2])) {
				// 스택에 추가(작업이름, 남은시간(plans[i][2] - 작업시간))
				Subject subject = new Subject(plans[i-1][0],
						Integer.parseInt(plans[i-1][2]) - timeDifference);
				stack.addLast(subject);
			} else if (timeDifference > Integer.parseInt(plans[i-1][2])) {
				result.add(plans[i-1][0]);
				int remainTime = timeDifference - Integer.parseInt(plans[i-1][2]);
				while (remainTime != 0) {
					// stack.pop 작업 -> 작업시간
					Subject poppedWork = stack.removeLast();
					// 짜투리작업시간 = 남는시간 - stack.pop된 작업의 남은시간
					int remainWorkTime = remainTime - poppedWork.remainTime;
					// 짜투리작업시간 > 0
					if (remainWorkTime > 0) {
						//남는시간 = 짜투리작업시간
						remainTime = remainWorkTime;
						//result.add stack에서 pop된 작업이름
						result.add(poppedWork.name);
					}
					// 짜투리 작업시간 < 0
					else {
						// stack.push(작업이름, 남은시간(부호반전 짜투리작업시간)
						stack.addLast(new Subject(poppedWork.name, -remainWorkTime));
						//break 혹은 남는시간 0
						remainTime = 0;
					}
				}
			} else {
				result.add(plans[i-1][0]);
			}
		}
		result.add(plans[plans.length-1][0]);
		while (!stack.isEmpty()) {
			result.add(stack.removeLast().name);
		}

		//result 를 answer로 변환
		answer = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

}
