class Solution {
    public void rotate(int[][] matrix) {
        boolean debug = false;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        if (debug)
        { for(int[] row:matrix) {
            Arrays.stream(row).forEach(x -> System.out.print( x + ","));
            System.out.println("\n");
        }}
        
        
        for(int j = 0; j <= matrix.length/2; j++) {
            int last = matrix.length - 1 - j;
            if (last <= j) continue;
            for(int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }

        if(debug)
        {System.out.println("\n");
        for(int[] row:matrix) {
            Arrays.stream(row).forEach(x -> System.out.print( x + ","));
            System.out.println("\n");
        }}
        
    }
}