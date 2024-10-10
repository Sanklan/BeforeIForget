class Solution {
    public int change(int amount, int[] coins) {
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