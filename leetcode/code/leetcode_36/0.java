class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> data = new HashSet<String>();
        
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++) 
            {
                char number = board[i][j];
                if (number == '.') 
                    continue;
                String row = number + "_r_" + i;
                String col = number + "_c_" + j;                
                String box = number + "_b_" + i/3 + "_" + j/3;
                
                if (data.contains(row) || data.contains(col) || data.contains(box)) 
                    return false;
                else {
                    data.add(row);
                    data.add(col);
                    data.add(box);
                }
            }
        }
        
        return true;
    }
}