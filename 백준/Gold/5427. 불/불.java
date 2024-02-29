import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			char[][] map = new char[y][x];
			int[][] fireDist = new int[y][x];
			int[][] dist = new int[y][x];

			Queue<Location> fireQue = new LinkedList<>();
			Queue<Location> que = new LinkedList<>();

			for (int i = 0; i < y; i++) {
				String line = br.readLine();
				Arrays.fill(dist[i], -1);
				Arrays.fill(fireDist[i], Integer.MAX_VALUE);
				for (int j = 0; j < x; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '@') {
						que.offer(new Location(i, j));
						dist[i][j] = 0;
					}
					if (map[i][j] == '*') {
						fireQue.offer(new Location(i, j));
						fireDist[i][j] = 0;
					}
				}
			}
			int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			while (!fireQue.isEmpty()) {
				Location cur = fireQue.poll();
				for (int i = 0; i < 4; i++) {
					int nextY = cur.y + dir[i][0];
					int nextX = cur.x + dir[i][1];
					if (nextY < 0 || nextX < 0 || nextX >= x || nextY >= y) {
						continue;
					}
					if (map[nextY][nextX] == '#' || fireDist[nextY][nextX] != Integer.MAX_VALUE) {
						continue;
					}
					fireQue.offer(new Location(nextY, nextX));
					fireDist[nextY][nextX] = fireDist[cur.y][cur.x] + 1;
				}
			}
			boolean isPossible = false;
			while (!que.isEmpty()) {
				Location cur = que.poll();
				for (int i = 0; i < 4; i++) {
					int nextY = cur.y + dir[i][0];
					int nextX = cur.x + dir[i][1];
					if (nextY < 0 || nextX < 0 || nextX >= x || nextY >= y) {
						isPossible = true;
						System.out.println(dist[cur.y][cur.x] + 1);
						break;
					}
					if (map[nextY][nextX] != '.' || dist[nextY][nextX] != -1
							|| fireDist[nextY][nextX] <= dist[cur.y][cur.x] + 1) {
						continue;
					}
					que.offer(new Location(nextY, nextX));
					dist[nextY][nextX] = dist[cur.y][cur.x] + 1;
				}
				if (isPossible) {
					break;
				}
			}
			if (!isPossible)
				System.out.println("IMPOSSIBLE");
		}
	}

	static class Location {

		public int x;
		public int y;

		public Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
