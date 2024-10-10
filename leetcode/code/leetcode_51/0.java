class Solution {
    public List<List<String>> solveNQueens(int n) {
        //boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        List<List<String>> ret = new ArrayList<List<String>>();
        
       // patterns = new HashSet<String>();
        
        //Arrays.fill(row, false);
        Arrays.fill(col, false);        
        int[][] board = new int[n][n];
        for(int r = 0; r < n; r++ ) Arrays.fill(board[r], 0);
        placeQueen(0, col, board, ret);
       
        return ret;
    }
    
    private void placeQueen(int row, boolean[] col, int[][] board, List<List<String>> ret) {
        if (row == board.length) {
            ret.add(generateList(board));
        }
        
        for(int c = 0; c < board.length; c++) {
            if (!col[c] && IsDiagEmpty(board, row, c)) {
                col[c] = true;
                board[row][c] = 1;
                placeQueen(row + 1, col, board, ret);
                board[row][c] = 0;
                col[c] = false;
            }
        }
        
    }
    
    
    private List<String> generateList(int[][] board) {
        List<String> ret = new ArrayList<String>();
        int n = board.length;
        for(int r = 0; r < n; r++ ) {
            StringBuilder currentRow = new StringBuilder();
            for(int c = 0; c < n; c++) {
                if (board[r][c] == 1) currentRow.append("Q");
                else currentRow.append(".");
            }
            ret.add(currentRow.toString());
        }
        return ret;
    }
    
    
    
    /*
    private String listToString(List<String> data) {
        return String.join("$$", data);
    }*/
    
    private boolean IsDiagEmpty(int[][] board, int row, int col) {
        // row-- & col--
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        // row++ & col++
        for(int i = row, j = col; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 1) return false;
        }
        // row++ & col--
        for(int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        // row-- & col++
        for(int i = row, j = col; j < board.length && i >= 0; j++, i--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }
    
    /*
    private void check(boolean[] row, boolean[] col, int n, 
                          int[][] board, List<List<String>> ret) {
        if (n == 0) {
            List<String> ans = generateList(row, col, board);
           /* if (!patterns.contains(listToString(ans))) {
                patterns.add(listToString(ans));*/
        //        ret.add(ans);   
          //  }
         /*   return;
        }
        for(int r = 1; r < row.length; r++ ) {
            for(int c = 0; c < col.length; c++) {
                if (!row[r] && !col[c] && IsDiagEmpty(board, r, c)) {
                    row[r] = true;
                    col[c] = true;
                    board[r][c] = 1;
                    
                    check(row, col, n - 1, board, ret); 
                    
                    board[r][c] = 0;
                    row[r] = false;
                    col[c] = false;
                }
            }
        }
    }*/
    
    
}