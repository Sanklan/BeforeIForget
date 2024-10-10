class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[amount + 1][coins.length + 1];
        for(int i = 0; i <= coins.length; i++) 
            dp[0][i] = 1;

        for(int amt = 1; amt <= amount; amt++) {
            for(int i = 0; i < coins.length; i++) {
                if (amt - coins[i] < 0) {
                    dp[amt][i + 1] = dp[amt][i];
                } else {
                    dp[amt][i + 1] = dp[amt][i] + dp[amt - coins[i]][i + 1];
                }
            }
        }

        return dp[amount][coins.length];

    }
    public int change1(int amount, int[] coins) {
        Arrays.sort(coins);
        memo = new HashMap<String, Integer>();
        return generate(amount, coins, 0);

    }

    private int generate(int amount, int[] coins, int coin) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (coin >= coins.length) return 0;
        if (amount == coins[coin])
            return 1;

        if (memo.containsKey(key(coin, amount))) 
            return memo.get(key(coin, amount));


        int count = 0;
        int ans = 0;
        while(coins[coin] * count <= amount) {
            ans += generate(amount - coins[coin] * count, coins, coin + 1);
            count++;
        }
        memo.put(key(coin, amount), ans);
        return ans;
    }

    private String key(int coin, int amount) {
        return coin + "_" + amount;
    }

    HashMap<String, Integer> memo;
}