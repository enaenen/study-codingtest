class Solution {
    public int longestIdealString(String s, int k) {
        int [] memo = new int[27];
        int max = Integer.MIN_VALUE;
        for (int i = s.length()-1; i > -1; i--){
            char c = s.charAt(i);
            int index = c - 'a';

            int left = Math.max(0, (index - k));
            int right = Math.min(26, (index + k));

            for (int j = left; j <= right; j++){
                max = Math.max(max, memo[j]);
            }
            memo[index] = max + 1;
            max = Integer.MIN_VALUE;
        }
        for(int n  : memo){
            max = Math.max(max, n);
        }
        return max;
    }
}

