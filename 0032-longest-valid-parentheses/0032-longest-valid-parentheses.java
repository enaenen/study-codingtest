class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        stack.addFirst(-1);

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peekFirst()) == '('){
                stack.removeFirst();
                answer = Math.max(answer, i - stack.peekFirst());
            }
            else {
                stack.addFirst(i);
            }
        }
        return answer;
    }
}