package codingtest.basic.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj7569 {

	static class Location {

		int x;
		int y;
		int z;

		public Location(int z, int y, int x) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int z = Integer.parseInt(input[2]);

		int[][][] map = new int[z][y][x];
		int[][][] dist = new int[z][y][x];
//		boolean[][][] visited = new boolean[z][y][x];
		int[][] dir = new int[][]{{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0},
				{-1, 0, 0}};
		Queue<Location> que = new LinkedList<>();
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				String[] line = br.readLine().split(" ");
				for (int k = 0; k < line.length; k++) {
					map[i][j][k] = Integer.parseInt(line[k]);
					if (map[i][j][k] == 1) {
						que.offer(new Location(i, j, k));
					}
					if (map[i][j][k] == 0) {
						dist[i][j][k] = -1;
					}
				}
			}
		}
		while (!que.isEmpty()) {
			Location cur = que.poll();
			for (int i = 0; i < 6; i++) {
				int nextZ = cur.z + dir[i][0];
				int nextY = cur.y + dir[i][1];
				int nextX = cur.x + dir[i][2];

				if (nextZ < 0 || nextY < 0 || nextX < 0 ||
						nextZ >= z || nextY >= y || nextX >= x) {
					continue;
				}
				if (map[nextZ][nextY][nextX]== -1 || dist[nextZ][nextY][nextX] >= 0) {
					continue;
				}
				que.offer(new Location(nextZ, nextY, nextX));
				dist[nextZ][nextY][nextX] = dist[cur.z][cur.y][cur.x] + 1;
			}
		}
		int count = -1;
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x; k++) {
					if (dist[i][j][k] == -1) {
						System.out.println(-1);
						return;
					}
					count = Math.max(count, dist[i][j][k]);
				}
			}
		}
		System.out.println(count);
	}
}
