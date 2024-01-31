package codingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapSize = br.readLine().split(" ");

		int width = Integer.parseInt(mapSize[0]);
		int height = Integer.parseInt(mapSize[1]);

		int[][] map = new int[height][width];
		int[][] dist = new int[height][width];
		Queue<Location> que = new LinkedList<>();
		for (int i = 0; i < height; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < width; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] == 1) {
					que.offer(new Location(i, j));
				}
				if (map[i][j] == 0) {
					dist[i][j] = -1;
				}
			}
		}
		int[] dx = new int[]{1, -1, 0, 0};
		int[] dy = new int[]{0, 0, 1, -1};
		while (!que.isEmpty()) {
			Location cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.width + dx[i];
				int nextY = cur.height + dy[i];
				if (nextY < 0 || nextX < 0 || nextX >= width || nextY >= height) {
					continue;
				}
				if (dist[nextY][nextX] >= 0) {
					continue;
				}
				dist[nextY][nextX] = dist[cur.height][cur.width] + 1;
				que.offer(new Location(nextY, nextX));
			}
		}
		int max = -1;
		for (int[] h : dist) {
			for (int w : h) {
				if (w == -1) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, w);
			}
		}
		System.out.println(max);
	}

	static class Location {

		int height;
		int width;

		Location(int height, int width) {
			this.height = height;
			this.width = width;
		}

	}
}
