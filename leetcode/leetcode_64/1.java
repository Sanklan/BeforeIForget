class Solution {
    HashMap<String, Integer> Memory = new HashMap<String, Integer>();
    public int minPathSum(int[][] grid) {
        return findMinPath(grid, 0, 0);
    }
    
    int findMinPath(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        int depth = grid[row][col];
        int rowTree = -1;
        int colTree = -1;
        if(Memory.containsKey(row +"-"+ col)) {
            return Memory.get(row +"-"+ col);
        }
        
        if(row + 1 < m) {
            rowTree = findMinPath(grid, row + 1, col);
        }
        if(col + 1 < n) {
            colTree = findMinPath(grid, row, col + 1);
        }
            
        depth = (rowTree != -1) ? 
                        (colTree != -1) ? 
                                 (colTree < rowTree) ? depth + colTree : depth + rowTree
                                        : depth + rowTree
                                             : (colTree != -1) ? depth + colTree : depth;
        
        
        Memory.put(row +"-"+ col, depth);
        return depth;
        
    }
}