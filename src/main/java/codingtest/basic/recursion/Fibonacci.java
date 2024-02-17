package codingtest.basic.recursion;

public class Fibonacci {

	static int fibo(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibo(n - 1) + fibo(n - 2);
	}

	public static void main(String[] args) {
		System.out.println("fibo(5) = " + fibo(5));
	}
}
