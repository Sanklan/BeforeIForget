class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        int[] temp = new int[n];
        //Arrays.fill(dp, grid[0][0]);
        for(int i = 0; i < n; i++) dp[i] = grid[0][i];
        
        for(int i = 1; i < m; i++) {
            System.out.println(Arrays.toString(dp));
            for(int j = 0; j < n; j++) {
                temp[j] = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++) {
                        temp[j] = Math.min(temp[j], dp[k] + moveCost[grid[i - 1][k]][j]);
                    }
                    temp[j] = temp[j] + grid[i][j];
                }
            
            for(int k = 0; k < n; k++) dp[k] = temp[k];
            }
        //System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).min().getAsInt();
   }
}