package codingtest.programmers.level2;
//https://school.programmers.co.kr/learn/courses/30/lessons/43105

public class IntegerTriangle {

	public static int solution(int[][] triangle) {
		int h = triangle.length;
		int i = 0;
		if (h == 0) {
			i = 0;
		} else {
			i -= 2;
		}
		while (0 <= i ){
			for (int x = 0; x < triangle[i].length; x++){
				int left = triangle[i+1][x];
				int right = triangle[i+1][x+1];
				triangle[i][x] += Math.max(left, right);
			}
			i--;
		}
		return triangle[0][0];
	}

}
