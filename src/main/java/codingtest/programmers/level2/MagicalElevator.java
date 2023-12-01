package codingtest.programmers.level2;

public class MagicalElevator {
		public static int solution(int storey) {
			int answer = 0;

			while (storey != 0){
				int tenUnit = storey % 10;
				storey /= 10;
				if (tenUnit > 5){
					answer += 10 - tenUnit;
					storey++;
				}
				else if (tenUnit < 5){
					answer += tenUnit;
				}
				else if (storey % 10 >= 5){
					answer += 5;
					storey++;
				}
				else {
					answer+=5;
				}
			}
			return answer;
		}
		public static void main(String[] args) {
			System.out.println(solution(5457));
		}

}
