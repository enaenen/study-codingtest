package codingtest.basic.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj2583 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int y = Integer.parseInt(input[0]);
		int x = Integer.parseInt(input[1]);
		int square = Integer.parseInt(input[2]);
		boolean[][] map = new boolean[y][x];

		while (square-- > 0) {
			String[] line = br.readLine().split(" ");
			int bottomX = Integer.parseInt(line[0]);
			int bottomY = Integer.parseInt(line[1]);
			int topX = Integer.parseInt(line[2]);
			int topY = Integer.parseInt(line[3]);

			for (int i = bottomY; i < topY; i++) {
				for (int j = bottomX; j < topX; j++) {
					map[i][j] = true;
				}
			}
		}
		Queue<Location> que = new LinkedList<>();
		List<Integer> areaList = new ArrayList<>();
		int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int count = 0;
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				int area = 0;
				if (!map[i][j]) {
					que.offer(new Location(i, j));
					map[i][j] = true;
					while (!que.isEmpty()) {
						area++;
						Location cur = que.poll();
						for (int k = 0; k < 4; k++) {
							int nextY = cur.y + dir[k][0];
							int nextX = cur.x + dir[k][1];
							if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) {
								continue;
							}
							if (map[nextY][nextX]) {
								continue;
							}
							map[nextY][nextX] = true;
							que.offer(new Location(nextY, nextX));
						}
					}
					count++;
					areaList.add(area);
				}
			}
		}
		Collections.sort(areaList);
		result.append(count).append("\n");
		for (Integer i : areaList) {
			result.append(i).append(" ");
		}
		System.out.println(result);
	}

	static class Location {

		int y;
		int x;

		public Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
