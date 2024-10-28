class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey != 0){
            int unit = storey % 10;
            if (unit < 5){
                answer += unit;
            }
            else if (unit == 5){
                int tenUnit = (storey / 10) % 10;
                if (tenUnit >= 5){
                    storey += 10;
                }
                answer += 5;
            }
            else {
                answer += 10 - unit;
                storey += 10;
            }
            storey /= 10;
        }
        return answer;
    }
}