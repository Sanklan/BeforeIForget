class Solution {
    public int numSquares(int n) {
        /**
        n*n + t 
        1 ... 2*n
         */
        int k = (int)Math.floor(Math.sqrt(n));
        memo = new HashMap<Integer, Integer>();
        return dp(n);
        
    }

    HashMap<Integer, Integer> memo;

    private int dp(int k) {
        if (k < 4) return k;
        if (memo.containsKey(k)) return memo.get(k);

        int l = (int)Math.floor(Math.sqrt(k));
        if (l*l == k) {
            memo.put(k, 1);
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for( int i = l; i >= 1; i--) {
            min = Math.min(min, 1 + dp( k - i*i));
        }

        memo.put(k, min);
        return min;
    }

    private int runner(int n) {
        Stack<Integer> products = new Stack<Integer>();
        run(n, products);
        return products.size();
    }
    private void run(int n, Stack<Integer> stack) {
        if(n <= 0) return;
        if (n == 1) {
            stack.push(1);
            return;
        }

        int k = (int)Math.floor(Math.sqrt(n));
        stack.push(k*k);
        run(n - k*k, stack);
    }
}