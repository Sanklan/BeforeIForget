class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        memo = new HashMap<String, Integer>();
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, explore(i, j, matrix));
            }
        }
        
       /* memo.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });*/
        
        return max;
    }
    private HashMap<String, Integer> memo;
    private int explore(int i, int j, int[][] matrix) {
        if (i < 0 || j < 0 || 
            matrix.length == i || matrix[0].length == j) 
                return 0;
        
        if (memo.containsKey(k(i,j))) 
            return memo.get(k(i,j));
        
        int max = 0;
        int n = matrix[i][j];
        
        if (i > 0 && n < matrix[i - 1][j]) {
           max = Math.max(max, explore(i - 1, j, matrix));
        }
        if (i <= matrix.length - 2 && n < matrix[i + 1][j]) {
           max = Math.max(max, explore(i + 1, j, matrix));
        }
        if (j > 0 && n < matrix[i][j - 1]) {
           max = Math.max(max, explore(i, j - 1, matrix));
        }
        if (j <= matrix[0].length - 2 && n < matrix[i][j + 1]) {
           max = Math.max(max, explore(i, j + 1, matrix));
        }
        //System.out.println(k(i,j) + " : " + (1 + max));
        memo.put(k(i,j), 1 + max);
        return 1 + max;
    }
    
    private String k(int i, int j) {
        return i +"__" + j;
    }
}