class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        while(n > 2) {
            if (n % 2 == 1) return false;
            n /= 2;
        }
        // if (n == 0) return 1;
        // if (n == 1) return 2;
        // if (!memo.containsKey(n)) 
        //     memo.put(n, isPowerOfTwo(n - 1) * isPowerOfTwo(n - 1));
        // return memo.get(n);
        return true;
    }

    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
}