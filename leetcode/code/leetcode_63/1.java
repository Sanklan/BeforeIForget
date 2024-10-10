class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0].length == 0 ) return 0;
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, new HashMap<String, Integer>());
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, HashMap<String, Integer> memo) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) return 0; 
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) return 1;
        if (obstacleGrid[i][j] == 1) return 0;
        if (memo.containsKey(key(i, j))) return memo.get(key(i, j));
        int bottom = uniquePathsWithObstacles(obstacleGrid, i + 1, j, memo);
        int right =  uniquePathsWithObstacles(obstacleGrid, i, j + 1, memo);
        memo.put(key(i, j), bottom + right);
        return bottom + right;
    }


    private String key(int i, int j) {
        return i + "_" + j;
    }
}