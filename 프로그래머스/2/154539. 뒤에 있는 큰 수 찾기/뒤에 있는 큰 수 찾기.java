import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(answer, -1);
        stack.addFirst(numbers[numbers.length-1]);
        
        for (int i = answer.length - 1; -1 < i; i--){
            while (!stack.isEmpty() && stack.peekFirst() <= numbers[i])
                stack.removeFirst();
            if (!stack.isEmpty())
                answer[i] = stack.peekFirst();
            stack.addFirst(numbers[i]);
        }
        return answer;
    }
}