package codingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int F = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		int G = Integer.parseInt(input[2]);
		int U = Integer.parseInt(input[3]);
		int D = Integer.parseInt(input[4]);

		boolean[] visited = new boolean[F];

		Queue<Integer> que = new LinkedList<>();
		que.offer(S);
		visited[S - 1] = true;
		int count = 0;
		while (!que.isEmpty()) {
			count++;
			int cur = que.poll();
			if (cur == G) {
				System.out.println(count);
				return;
			}
			int next = cur;
			if (cur < G && cur + U <= G && !visited[cur + U - 1]){
				next = cur + G;
			}


			visited[next - 1] = true;
			que.offer(next);
		}
		System.out.println("use the stairs");
	}
}
