class Solution {
    
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return calc(nums, dp, nums.length - 1);
    }
    private int calc(int[] nums, int[] dp, int i){
        if ( i < 0) return 0;
        
        if (-1 < dp[i]) return dp[i];

        return dp[i] = Math.max(calc(nums, dp, i - 1), calc(nums, dp, i - 2) + nums[i]);
    }
}