import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] priority = new int[order.length];
        
        for (int i = 0; i < order.length; i++){
            priority[order[i] - 1] = i;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0 ; i < priority.length; i++){
            if (priority[i] == answer){
                answer++;
            }
            else {
                stack.addFirst(priority[i]);
            }
            while (!stack.isEmpty() && stack.peekFirst() == answer){
                answer++;
                stack.removeFirst();
            }
        }
        return answer;
    }
}