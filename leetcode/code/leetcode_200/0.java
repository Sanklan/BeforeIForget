class Solution {
    public int numIslands(char[][] grid) {
    //repeat till [n-1,n-1]
        //find a one 
        //increase island count by one
        //update all connected ones to zero'
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    grid = waterTheIsland(grid, i, j);
                    // System.out.println(" ");
                    //print(grid);
                }                
                // print(grid);
            }
        }
        return islands;
    }
    
    private void print(char[][] grid) {
        for (char[] row:grid)
            System.out.println(Arrays.toString(row));
    }
    
    
    private char[][] waterTheIsland(char[][] grid, int i, int j) {
        // System.out.println(i + " , " + j);
        if (i < 0 || j < 0 || i >= grid.length) {
            // System.out.println(1);
            return grid;
        }
        // System.out.println(grid[i].length);
        if (grid[i].length <= j) {
            // System.out.println(2);
            return grid;
        }
        
        if (grid[i][j] == '0') {
            // System.out.println(3);
            return grid;
        }
        // print(grid);
        grid[i][j] = '0';
        // print(grid);
        grid = 
            waterTheIsland(grid, i + 1, j);
        grid = 
            waterTheIsland(grid, i - 1, j);
        grid = 
            waterTheIsland(grid, i, j + 1);
        grid = 
            waterTheIsland(grid, i, j - 1);
        return grid;
    }
}