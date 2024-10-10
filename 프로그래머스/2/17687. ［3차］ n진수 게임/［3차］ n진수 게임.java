class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder arr = new StringBuilder();
        for (int i = 0; arr.length() < t * m; i++){
            arr.append(Integer.toString(i, n));
        }
        

        for (int i = p - 1; answer.length() < t; i += m){
            answer.append(arr.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}