class Solution {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new LinkedList<>();
		for (String token : tokens) {
			if (!Character.isDigit(token.charAt(token.length()-1))) {
				int b = stack.removeFirst();
				int a = stack.removeFirst();
				stack.addFirst(calc(a, b, token.charAt(0)));
			} else {
				stack.addFirst(Integer.parseInt(token));
			}
		}
		return stack.removeFirst();
	}
    private int calc(int a, int b, char sign){
        switch (sign){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
        }
        return 0;
    }
}