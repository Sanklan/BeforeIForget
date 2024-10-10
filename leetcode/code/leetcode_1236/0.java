class Solution {
    public int tribonacci(int n) {
        return tribonacci(n, new HashMap<Integer, Integer>());
    }

    private int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if (n < 0) return 0;
        if ( n < 2) return n;
        if (memo.containsKey(n)) return memo.get(n);

        int ans = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo.put(n, ans);
        return ans;
    }
}