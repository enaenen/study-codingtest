package codingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.io.*;
import java.util.*;

public class Application {

	static class Location {

		int x;
		int y;
		int z;

		public Location(int y, int x, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int H = Integer.parseInt(input[2]);

		int[][][] board = new int[M][N][H];
		int[][][] dist = new int[M][N][H];
		int[] dirX = new int[]{1, -1, 0, 0, 0, 0};
		int[] dirY = new int[]{0, 0, 1, -1, 0, 0};
		int[] dirZ = new int[]{0, 0, 0, 0, 1, -1};

		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(0, 0, 0));
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < M; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j][k] = line.charAt(j) - '0';
					dist[i][j][k] = -1;
					if (line.charAt(j) == '1') {
						queue.offer(new Location(i, j, k));
						dist[i][j][k] = 0;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Location cur = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nx = cur.x + dirX[i];
				int ny = cur.y + dirY[i];
				int nz = cur.z + dirZ[i];

				if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) {
					continue;
				}
				if (dist[ny][nx][nz] >= 0 || board[ny][nx][nz] != 1) {
					continue;
				}
				dist[ny][nx][nz] = dist[cur.y][cur.x][cur.z] + 1;
				queue.offer(new Location(ny,nx,nz));
			}
		}
		int count = 1;
		for (int i = 0; i < H; i++){
			for (int j = 0; j < M; j++){
				for (int k = 0; k < N; k++){
					if (dist[j][k][i] == -1){
						System.out.println(-1);
						return;
					}
					count = Math.min(count,dist[j][k][i]);
				}
			}
		}
		System.out.println(count);
	}
}