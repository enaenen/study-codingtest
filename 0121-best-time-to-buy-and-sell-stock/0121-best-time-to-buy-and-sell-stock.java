class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int cheapestPrice = Integer.MAX_VALUE;
        for (int price : prices){
            int gap = price - cheapestPrice;
            cheapestPrice = Math.min(price, cheapestPrice);
            maxProfit = Math.max(maxProfit, gap);
        }
        return maxProfit;
    }
}