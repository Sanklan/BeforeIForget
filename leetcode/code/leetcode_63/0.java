class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        
        if (m == 0) return 0;
        if (n == 0 ) return 0;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        
        
        if (m == 1 && n == 1) return 1;

        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int i = 0; i < res.length; i++) 
            res[i] = new int[obstacleGrid[0].length];
        
        for(int i = m -2; i >= 0; i--) {
            if (obstacleGrid[i][n -1] == 1) break; 
            res[i][n - 1] = 1;
        }
        for(int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m -1][i] == 1) break;
            res[m -1][i] = 1;
        }
        
        //System.out.println(Arrays.deepToString(res));
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0)
                    res[i][j] = res[i + 1][j] + res[i][j + 1];
            }
        }
        //System.out.println(Arrays.deepToString(res));
        return res[0][0];

    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
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