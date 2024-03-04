import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			boolean[][] visited = new boolean[n][n];

			Queue<Location> que = new LinkedList<>();
			int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
			int area = 0;

			for(int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++){
					map[i][j] = line.charAt(j) - '0';
				}
			}
			StringBuffer result = new StringBuffer();
			List<Integer> counts = new ArrayList<>();

			for (int i = 0; i < n; i++){
				for (int j = 0; j < n; j++){
					if (map[i][j] != 0 && !visited[i][j]){
						int count = 0;
						que.offer(new Location(i,j));
						visited[i][j]=true;
						area++;
						while (!que.isEmpty()){
							Location cur = que.poll();
							count++;
							for(int k = 0; k < 4; k++){
								int nextY = cur.y + dir[k][0];
								int nextX = cur.x + dir[k][1];
								if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
									continue;
								if (map[nextY][nextX] == 0 || visited[nextY][nextX])
									continue;
								que.offer(new Location(nextY,nextX));
								visited[nextY][nextX] = true;
							}
						}
						counts.add(count);
					}
				}
			}
			result.append(area).append("\n");
			Collections.sort(counts);
			for (Integer count : counts) {
				result.append(count).append("\n");
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
