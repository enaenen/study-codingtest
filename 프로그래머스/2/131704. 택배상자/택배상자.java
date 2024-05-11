import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> stack = new LinkedList<>();
        int[] dist = new int[order.length];
        
        for (int i = 0; i < order.length; i++){
            dist[order[i] - 1] = i;
        }
        
        for (int i = 0; i < order.length; i++){
            if (dist[i] == answer){
                answer++;
            }
            else {
                stack.addFirst(dist[i]);
            }
            while (!stack.isEmpty() && stack.peekFirst() == answer){
                stack.removeFirst();
                answer++;
            }
        }
        return answer;
    }
}