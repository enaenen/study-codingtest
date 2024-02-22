package codingtest.basic.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][n];
		char[][] map2 = new char[n][n];
		boolean[][] visited = new boolean[n][n];
		int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
				map2[i][j] = line.charAt(j);
				if (map2[i][j] == 'R') {
					map2[i][j] = 'G';
				}
			}
		}
		Queue<Pair> que = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				count++;
				que.offer(new Pair(i, j));
				while (!que.isEmpty()) {
					Pair cur = que.poll();
					visited[i][j] = true;
					for (int k = 0; k < 4; k++) {
						int nextY = cur.y + dir[k][0];
						int nextX = cur.x + dir[k][1];

						if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
							continue;
						}
						if (visited[nextY][nextX] || map[nextY][nextX] != map[cur.y][cur.x]) {
							continue;
						}
						que.offer(new Pair(nextY, nextX));
						visited[nextY][nextX] = true;
					}
				}
			}
		}
		System.out.print(count + " ");
		count = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					continue;
				}
				count++;
				que.offer(new Pair(i, j));
				while (!que.isEmpty()) {
					Pair cur = que.poll();
					visited[i][j] = true;
					for (int k = 0; k < 4; k++) {
						int nextY = cur.y + dir[k][0];
						int nextX = cur.x + dir[k][1];

						if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
							continue;
						}
						if (visited[nextY][nextX] || map2[cur.y][cur.x] != map2[nextY][nextX]) {
							continue;
						}
						que.offer(new Pair(nextY, nextX));
						visited[nextY][nextX] = true;
					}
				}
			}
		}
		System.out.println(count);
	}

	static class Pair {

		public int y;
		public int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
