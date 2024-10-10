class Solution {
    public double myPow(double x, int n) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 0) return 1;
        if (x == 0) return x;
        if (n == 1) return x;
        if (n == -1) {
            memo.put( n, 1/x);
            return 1/x;
        }

        double mul = ( n % 2 == 0) ? 1 : x;
        if (n < 0) mul = 1 / mul;
        Double ans = myPow(x, n/2) * myPow(x, n/2) * mul;
        memo.put(n, ans);
        return ans;
    }

    HashMap<Integer, Double> memo = new HashMap<Integer, Double>();
}