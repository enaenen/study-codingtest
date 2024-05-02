class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = calc(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private int calc(int[] coins, int amount, int[] dp){
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (dp[amount] != -1){
            return dp[amount];
        }
        int count = Integer.MAX_VALUE;
        for (int c : coins){
            int ret = calc(coins, amount - c, dp);
            if (ret != Integer.MAX_VALUE)
                count = Math.min(ret + 1, count);
        }
        dp[amount] = count;
        return dp[amount];
    }
}