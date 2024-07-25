class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int n : dp) result = Math.max(result, n);
        return result;
    }
}
