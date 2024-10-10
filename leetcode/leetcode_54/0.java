class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        
        //column
        int left = 0;
        int right = matrix[0].length - 1;
        // row index
        int  up = 0;
        int  down = matrix.length - 1;

        while(true) {
            int j = left;
            while(j <= right) {
                ans.add(matrix[up][j]);
                j++;
            }
            up++;
            j = right;
            int i = up;
            if (up > down ) break;
            
            while(i <= down ) {
                ans.add(matrix[i++][j]);
            }
            
            right--;
            i = down;
            j = right;
            if (left > right) break;
            while( j >= left) ans.add(matrix[i][j--]);
            down--; 
            j = left;
            i = down;
            if (up > down) break;

            while( i >= up) ans.add(matrix[i--][j]);
            left++;i++;
            if (left > right) break;
        }
        
        return ans;
    }

}