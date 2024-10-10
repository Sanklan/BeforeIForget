class Solution {
    public int uniquePaths(int m, int n) {
        if (n < 2) return n;
        if (m < 2) return m;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 0;
        for(int i = 0; i < n - 1; i++) dp[m-1][i] = 1;
        for(int i = 0; i < m - 1; i++) dp[i][n - 1] = 1;
        int counter;
        for(int i = m - 2; i >= 0; i--) {
            counter = m - i;
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
}