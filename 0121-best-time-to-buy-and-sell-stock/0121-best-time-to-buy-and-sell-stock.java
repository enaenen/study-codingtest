class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int cheapestPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++){
            if (cheapestPrice > prices[i]){
                cheapestPrice = prices[i];
                continue;
            }
            maxProfit = Math.max(maxProfit, prices[i] - cheapestPrice);
        }
        return maxProfit;
    }
}