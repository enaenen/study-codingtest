class Solution {
    public int solution(int storey) {
        int answer = 0;
    
        while (storey != 0){
               int unit = storey % 10;
            
            // 올림할지, 내림할지 판단
            if (unit > 5) {
                answer += 10 - unit;  // 올림하여 10의 자리로 넘김
                storey += 10;
            } else if (unit == 5) {
                // 다음 자리가 5 이상인 경우에는 올림, 그렇지 않으면 그대로 처리
                if ((storey / 10) % 10 >= 5) {
                    storey += 10;
                }
                answer += 5;
            } else {
                answer += unit;  // 5 미만일 경우는 그대로 더함
            }
            storey /= 10;
        }
        return answer;
    }
}