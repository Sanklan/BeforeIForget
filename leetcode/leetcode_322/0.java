class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount <= 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        //for(int c = 0; c < coins.length; c++) Arrays.fill(dp[c], -1);
        for (int i = 0; i <= coins.length; i++) dp[i][0] = 0;
        for (int i = 1; i <= amount; i++) dp[0][i] = Integer.MAX_VALUE;

        for (int a = 1; a <= amount; a++) {
            for (int c = 1; c <= coins.length; c++) {
                if (coins[c - 1] == a) dp[c][a] = 1;
                else {
                     dp[c][a] = Integer.MAX_VALUE;
                    // consider the coin
                    if (dp[c - 1][a] != -1) dp[c][a] = dp[c - 1][a];
                    if (a > coins[c - 1] &&  dp[c][a-coins[c - 1]] != -1)
                        dp[c][a] = Math.min(1 + dp[c][a-coins[c - 1]],  dp[c][a]);

                    if (dp[c][a] == Integer.MAX_VALUE) dp[c][a] = -1;
                }
            }
        }
        //for(int[] d:dp) System.out.println(Arrays.toString(d));
        return dp[coins.length][amount];
    }
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        for(int i = 0; i < coins.length; i++) coins[i] = -1 * coins[i];
        Arrays.sort(coins);
        for(int i = 0; i < coins.length; i++) coins[i] = -1 * coins[i];

        memory.clear();
        for(int coin:coins) memory.put(coin, 1);
        return countCoins(coins, amount);
    }

    HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
    int countCoins(int[] coins, int amount) {
        if (amount < coins[coins.length - 1]) return -1;
        if (memory.containsKey(amount)) return memory.get(amount);
        int coinCount = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount == coin) {
                coinCount = 1;
                break;
            }
            else if (amount > coin) {
                int temp = amount % coin;
                int tmpCoinCount = amount/coin;
                if(temp == 0) coinCount = Math.min(coinCount,tmpCoinCount);
                else
                for( int i = tmpCoinCount; i >= 1; i--)
                {
                    int ans = countCoins(coins, temp + coin * (tmpCoinCount - i));
                    if (ans == -1) continue;
                    else  coinCount = Math.min(coinCount, i + ans);
                    //break;
                }
            }
        }
        if (coinCount == Integer.MAX_VALUE) coinCount = -1;
        memory.put(amount, coinCount);
        return coinCount;
    }
    
}