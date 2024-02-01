public class Solution {
    public int solution(int n) {
        int ans = 0;
        int cur = n;
        while (0 < cur){
            ans += cur % 2;
            cur /= 2;
        }
        return ans;
    }
}