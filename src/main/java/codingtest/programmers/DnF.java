package codingtest.programmers;

import java.util.Arrays;
//https://school.programmers.co.kr/learn/courses/30/lessons/87946

public class DnF {

	public static void main(String[] args) {
		System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));

	}

	/*
		public static int solution(int k , int[][] dungeons){
			int answer = 0;
			//dungeons[0]의 크기로 오름차순 정렬
			Arrays.sort(dungeons, (o1, o2) -> (o1[1]-o1[0]) - (o2[1]-o2[0]));
			for (int[] dungeon : dungeons) {
				if (k == 0)
					break;
				if (dungeon[0] <= k){
					k -= dungeon[1];
					answer++;
				}
			}
			return answer;
		}
	*/
	public static int solution(int k, int[][] dungeons) {
		boolean[] visited = new boolean[dungeons.length];
		dfs(k, dungeons, visited);
		return answer;
	}
	static int answer = 0;
	public static int dfs(int k, int[][] dungeons, boolean[] visited) {
		int clearDungeons = 0;
		for (boolean cleared : visited) {
			if (cleared) {
				clearDungeons++;
			}
		}
		answer = Math.max(answer, clearDungeons);
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i]) {
				if (dungeons[i][0] <= k) {
					visited[i] = true;
					k -= dungeons[i][0];
					dfs(k, dungeons, visited);
					k+= dungeons[i][1];
					visited[i] = false;
				}
			}
		}
		return answer;
	}
}
