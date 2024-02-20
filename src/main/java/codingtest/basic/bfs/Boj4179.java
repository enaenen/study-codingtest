package codingtest.basic.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj4179 {

//	static void print(int[][] arr) {
//		for (int[] ints : arr) {
//			for (int anInt : ints) {
//				System.out.print(anInt + "  ");
//			}
//			System.out.println();
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int y = Integer.parseInt(input[0]); // R
		int x = Integer.parseInt(input[1]); // C

		int[][] fireDist = new int[y][x];
		int[][] jDist = new int[y][x];
		char[][] map = new char[y][x];

		Queue<Location> fireQue = new LinkedList<>();
		Queue<Location> jQue = new LinkedList<>();

		int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

		for (int i = 0; i < y; i++) {
			String line = br.readLine();
			for (int j = 0; j < x; j++) {
				fireDist[i][j] = Integer.MAX_VALUE;
				jDist[i][j] = -1;
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'J') {
					jQue.offer(new Location(i, j));
					jDist[i][j] = 1;
				}
				if (map[i][j] == 'F') {
					fireQue.offer(new Location(i, j));
					fireDist[i][j] = 1;
				}
			}
		}

		while (!fireQue.isEmpty()) {
			Location cur = fireQue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = cur.y + dir[i][0];
				int nextX = cur.x + dir[i][1];

				if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) {
					continue;
				}
				if (map[nextY][nextX] == '#' || fireDist[nextY][nextX] != Integer.MAX_VALUE) {
					continue;
				}
				fireQue.offer(new Location(nextY, nextX));
				fireDist[nextY][nextX] = fireDist[cur.y][cur.x] + 1;
			}
		}
		while (!jQue.isEmpty()) {
			Location cur = jQue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = cur.y + dir[i][0];
				int nextX = cur.x + dir[i][1];

				if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) {
					System.out.println(jDist[cur.y][cur.x]);
					return;
				}

				// 재방문 안하도록 조건 확인 안했었음
				if (map[nextY][nextX] != '.' || jDist[nextY][nextX] > 0
						|| jDist[cur.y][cur.x] + 1 >= fireDist[nextY][nextX]) {
					continue;
				}
				jQue.offer(new Location(nextY, nextX));
				jDist[nextY][nextX] = jDist[cur.y][cur.x] + 1;
			}
		}
		System.out.println("IMPOSSIBLE");
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
