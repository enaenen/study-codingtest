package codingtest.inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class DollMachine {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boardLength = Integer.parseInt(br.readLine());
		int[][] board = new int[boardLength + 1][boardLength + 1];
		StringTokenizer st;
		for (int i = 1; i < boardLength + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < boardLength + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tries = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Deque<Integer>[] machine = new ArrayDeque[boardLength + 1];
		for (int i = 1; i < boardLength + 1; i++) {
			machine[i] = new ArrayDeque<>();
			for (int j = 1; j < boardLength + 1; j++) {
				if (board[j][i] == 0) {
					continue;
				}
				machine[i].addFirst(board[j][i]);
			}
		}
		Deque<Integer> stack = new ArrayDeque<>();
		int answer = 0;
		for (int i = 0; i < tries; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (machine[cur].isEmpty()) {
				continue;
			}
			int doll = machine[cur].removeLast();
			if (!stack.isEmpty() && stack.peekFirst() == doll) {
				stack.removeFirst();
				answer++;
			} else {
				stack.addFirst(doll);
			}
		}
		System.out.println(answer * 2);
	}
}