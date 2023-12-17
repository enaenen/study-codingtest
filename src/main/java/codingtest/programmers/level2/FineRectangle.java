package codingtest.programmers.level2;

public class FineRectangle {
//https://school.programmers.co.kr/learn/courses/30/lessons/62048
	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

	private static int gcd(int a, int b){
		int r = a % b;
		while (r != 0){
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static long solution(int w, int h) {
		long answer = 1;

		int gcd = gcd(w, h);
		long total = (long) w * h;

		return total - (w + h - gcd);
	}

}
