package codingtest.datastructure.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 *
 *          1
 *        /   \
 *       2     3
 *      / \   /
 *     3   4 5
 *
 *
 */
public class ArrayBinaryTree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] parent = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			parent[i] = i / 2;
		}

		System.out.println(Arrays.toString(parent));
	}

}
