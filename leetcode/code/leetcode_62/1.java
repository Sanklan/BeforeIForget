class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        memo = new HashMap<String, Integer>();
        int ans = uniquePath(1, 1, m, n);
       // memo.entrySet().stream().
        //forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        //System.out.println(memo.entrySet());
        return ans;
    }

    private int uniquePath(int x, int y, int m, int n) {
        if (m - 1 == x && y == n) return 1;
        if (m == x && y == n - 1) return 1;
        if ( x > m || y > n) return 0;
        String key = getKey(x, y);
        if (memo.containsKey(key)) 
            return memo.get(key);
        
        int ret = uniquePath(x + 1, y, m, n) + uniquePath(x, y + 1, m, n);
        memo.put(key, ret);
        return ret;
    }

    private String getKey(int x, int y) {
        return x + "_" + y;
    }
    private HashMap<String, Integer> memo;
}