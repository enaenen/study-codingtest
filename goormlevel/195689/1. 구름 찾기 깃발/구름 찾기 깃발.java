import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		int[][] board = new int[n][n];
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Deque<int[]> que = new ArrayDeque();
		// que.addFirst(new int[]{0,0});
		// dist[0][0] = 0;
		int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if (board[i][j] == 1) continue;
				
				for (int l = 0; l < dir.length; l++){
					int nextY = i + dir[l][0];
					int nextX = j + dir[l][1];
					
					if (nextY < 0 || nextX < 0 || nextY > n - 1 || nextX > n - 1) continue;
					
					if (board[nextY][nextX] == 1){
						dist[i][j]++;
					}
				}

			}
		}
		// for (int[] d : dist){
		// 	Arrays.fill(d, -1);
		// }
		// while(!que.isEmpty()){
		// 	int[] cur = que.removeLast();
		// 	for (int i = 0; i < dir.length; i++){
		// 		int nextY = cur[0] + dir[i][0];
		// 		int nextX = cur[1] + dir[i][1];
		// 		if (nextY < 0 || nextX < 0 || nextY > n - 1 || nextX > n - 1) continue;
		// 		if (dist[nextY][nextX] > -1) continue;
		// 		if (board[nextY][nextX] == 1) dist[cur[0]][cur[1]]++;
		// 		dist[nextY][nextX]++;
		// 		que.addFirst(new int[]{nextY, nextX});
		// 	}
		// }
		int answer = 0;

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if (dist[i][j] == k) answer++;
			}
		}
		System.out.println(answer);
	}
}