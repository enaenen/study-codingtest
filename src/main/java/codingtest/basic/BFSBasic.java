package codingtest.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSBasic {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int[][] board = new int[][]{
				{1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		boolean[][] visited = new boolean[board.length][board[0].length];

		int[] dx = new int[]{-1, 1, 0, 0};
		int[] dy = new int[]{0, 0, 1, -1};
		//동 서 남 북

		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(0, 0));

		while (!queue.isEmpty()) {
			Position cur = queue.poll();
			System.out.println(cur);
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				if (nextX < 0 || nextY < 0 || nextX > board.length || nextY > board[0].length) {
					continue;
				}
				if (visited[nextY][nextX] || board[nextY][nextX] != 1) {
					continue;
				}
				visited[nextY][nextX] = true;
				queue.offer(new Position(nextY, nextX));
			}
		}

	}

	static class Position {

		public int x;
		public int y;

		public Position(int y, int x) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Position{" + "x=" + x + ", y=" + y + '}';
		}
	}

}
