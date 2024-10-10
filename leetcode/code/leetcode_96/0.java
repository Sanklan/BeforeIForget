class Solution {
    public int numTrees(int n) {
        return numTrees(1, n, new HashMap<String, Integer>());
    }

    private int numTrees(int i, int j, HashMap<String, Integer> memo) {
        if (i == j || i - j == 1) return 1;
        if (i > j) return 0;
        String key = Solution.key(i,j);
        if (memo.containsKey(key))
            return memo.get(key);
        int sum = 0;
        for(int k = i; k <= j; k++) {
            sum += numTrees(i, k - 1, memo) * numTrees(k + 1, j, memo);
        }
        memo.put(key, sum);
        return sum;
    }

    private static String key(int i, int j) {
        return i + "_" + j;
    }
}