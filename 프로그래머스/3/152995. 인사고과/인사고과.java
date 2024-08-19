import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int n = scores.length;
        
        int target1 = scores[0][0];
        int target2 = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        
        int max = scores[0][1];
        
        //완호가 인센티브를 받을 수 있는가?
        for (int i = 1; i < n; i++){
            if (scores[i][1] < max){
                if (scores[i][0] == target1 && scores[i][1] == target2) return -1;
                
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                max = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        answer = 1;
        for (int i = 0 ; i < n; i++){
            if (target1 + target2 < scores[i][0] + scores[i][1]) answer++;
            else break;
        }
        
        return answer;
    }
}