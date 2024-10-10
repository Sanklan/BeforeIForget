class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            int right = prices[i];
            if (right < left)
            {
                left = right;
                continue;
            }
            if (prices[i] - left > profit) 
            {
                profit = prices[i] - left;                
            }
        }
        
        return profit;
    }
}