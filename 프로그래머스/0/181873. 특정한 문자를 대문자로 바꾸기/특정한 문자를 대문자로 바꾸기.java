class Solution {
    public String solution(String my_string, String alp) {
        String answer = my_string;
        answer = answer.replaceAll(alp, alp.toUpperCase());
        return answer;
    }
}