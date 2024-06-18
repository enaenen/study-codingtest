class Solution {
    public int twoEggDrop(int n) {
        int answer = 0;
        while (0 < n){
            n -= ++answer;
        }
        return answer;
    }
}