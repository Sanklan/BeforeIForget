class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if (left > prices[i])
                left = prices[i];
            else 
                profit = Math.max(profit, prices[i] - left);
        }
        
        return profit;
    }
}