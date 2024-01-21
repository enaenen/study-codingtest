import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Location {

		int x;
		int y;

		public Location(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int y = Integer.parseInt(input[0]);
		int x = Integer.parseInt(input[1]);

		int[][] board = new int[y][x];
		boolean[][] visited = new boolean[y][x];

		int[] dirX = new int[]{-1, 1, 0, 0};
		int[] dirY = new int[]{0, 0, 1, -1};

		for (int i = 0; i < y; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < x; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}

		Queue<Location> queue = new LinkedList<>();
		int paintCount = 0;
		int maxGrid = 0;

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (visited[i][j] || board[i][j] != 1) {
					continue;
				}
				queue.offer(new Location(i, j));
				int grid = 0;
				while (!queue.isEmpty()) {
					grid++;
					Location current = queue.poll();
					visited[current.y][current.x] = true;

					for (int k = 0; k < 4; k++) {
						int nextX = current.x + dirX[k];
						int nextY = current.y + dirY[k];
						if (nextX < 0 || nextX > x - 1 || nextY < 0 || nextY > y - 1) {
							continue;
						}
						if (visited[nextY][nextX] || board[nextY][nextX] != 1) {
							continue;
						}
						queue.offer(new Location(nextY, nextX));
						visited[nextY][nextX] = true;
					}
				}
				paintCount++;
				maxGrid = Math.max(maxGrid, grid);
			}
		}
		System.out.println(paintCount);
		System.out.println(maxGrid);

	}
}
