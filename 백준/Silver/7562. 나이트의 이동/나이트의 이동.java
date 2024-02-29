import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(br.readLine());
			while (0 < tc--){
				int n = Integer.parseInt(br.readLine());
				int[][] board = new int[n][n];
				String[] start = br.readLine().split(" ");
				String[] goal = br.readLine().split(" ");

				int[][] dir = new int[][] {{1,2}, {-1,2}, {2,1},{2,-1},{-2,-1},{-2,1},{1,-2},{-1,-2}};
				Queue<Location> que = new LinkedList<>();
				que.offer(new Location(Integer.parseInt(start[0]), Integer.parseInt(start[1])));
				board[Integer.parseInt(start[0])][Integer.parseInt(start[1])] = 1;
				while (!que.isEmpty()){
					Location cur = que.poll();
					for (int i = 0; i < dir.length; i++){
						int nextY = dir[i][0] + cur.y;
						int nextX = dir[i][1] + cur.x;
						if (nextY < 0 || nextX < 0 || nextY >=n || nextX >= n)
							continue;
						if (board[nextY][nextX] != 0)
							continue;
						que.offer(new Location(nextY, nextX));
						board[nextY][nextX] = board[cur.y][cur.x] + 1;
					}
				}
				System.out.println(board[Integer.parseInt(goal[0])][Integer.parseInt(goal[1])] - 1);
			}
		}
		static class Location {
			public int x;
			public int y;
			public Location(int y, int x){
				this.y = y;
				this.x = x;
			}
		}
}
