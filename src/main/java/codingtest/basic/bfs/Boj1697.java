package codingtest.basic.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		Queue<Integer> que = new LinkedList<>();
		que.offer(N);
		int[] dist = new int[100001];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = -1;
		}
		dist[N] = 0;
		while (dist[K] == -1) {
			int cur = que.poll();

			int jump = cur * 2;
			int go = cur + 1;
			int back = cur - 1;

			if (back > -1 && dist[back] == -1) {
				dist[back] = dist[cur] + 1;
				que.offer(back);
			}
			if (go < 100001 && dist[go] == -1) {
				dist[go] = dist[cur] + 1;
				que.offer(go);
			}
			if (jump < 100001 && dist[jump] == -1) {
				dist[jump] = dist[cur] + 1;
				que.offer(jump);
			}
		}
		System.out.println(dist[K]);
	}

}
