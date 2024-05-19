class Solution {
    public int maxProfit(int[] prices) {
        int prevPrice = prices[0];
        int total = 0;

        for (int i = 1; i < prices.length; i++){
            int gap = prices[i] - prevPrice;
            if (0 < gap){
                total += gap;
            }
            prevPrice = prices[i];
        }
        return total;
    }
}