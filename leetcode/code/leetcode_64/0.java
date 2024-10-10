class Solution {
    public int minPathSum(int[][] grid) {
        int[][] sum = grid.clone();

        for(int i = 1; i < grid[0].length; i++) {
            sum[0][i] = sum[0][i - 1] + sum[0][i];
        }

        for(int i = 1; i < grid.length; i++) {
            sum[i][0] = sum[i - 1][0] + sum[i][0];
        }

        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                sum[i][j] = sum[i][j] + Math.min(sum[i][j-1], sum[i-1][j]);
            }
        }

        return sum[grid.length - 1][grid[0].length - 1];
    }
}