import java.util.*;
import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		br.readLine();
		int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		int n = towers.length;

		Stack<Tower> stack = new Stack<>();
		stack.push(new Tower(0, 100000001));
		for (int i = 1; i < n + 1; i++) {
			while (stack.peek().height < towers[i - 1]) {
				stack.pop();
			}
			bw.write(stack.peek().index + " ");
			stack.push(new Tower(i, towers[i - 1]));
		}
		bw.flush();
		bw.close();
	}

	static class Tower {

		int index;
		int height;

		public Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
}
