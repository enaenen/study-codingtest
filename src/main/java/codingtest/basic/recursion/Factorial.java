package codingtest.basic.recursion;

public class Factorial {

	static int notRecursion(int n) {
		int total = 1;
		for (int i = n; i > 0; i--) {
			total *= i;
		}
		return total;
	}

	static long recursion(int n) {
		if (n == 1) {
			return n;
		}
		return recursion(n - 1) * n;
	}

	public static void main(String[] args) {
		System.out.println("notRecursion(5) = " + notRecursion(5));
		System.out.println("recursion(5) = " + recursion(5));

	}

}
