class Solution {
    public boolean exist(char[][] board, String word) {
        // boolean[][] used = generateVisitedGraph(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
            boolean[][] used = generateVisitedGraph(board);
            if(exist(board, word, i, j, used)) {
                   return true;
               }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, int i, int j, boolean[][] used) {
        if(word.length() == 0 || word == null || word.isEmpty()) return true;    
        if(word.charAt(0) != board[i][j] || used[i][j]) {
                return false;
            }
        // System.out.println(word + " " + i + " , " + j);
        used[i][j] = true;
        
        boolean result = false;
        if (word.length() == 1) return true;
        
        if ( 0 <= (i - 1) && (i - 1) < board.length) {
            if(!used[i-1][j]) {
                if(exist(board, word.substring(1), i - 1, j, used)) {
                   result = true;
                    return result;
               }
            used[i-1][j] = false;}
        }
        if ( 0 <=  (i + 1) && (i + 1) < board.length) {
            if(!used[i+1][j]) {
                if(exist(board, word.substring(1), i + 1, j, used)) {
                   result = true;
                    return result;
               }
            used[i+1][j] = false;}
        }
        if ( 0 <= (j - 1) && (j - 1) < board[i].length) {
            if(!used[i][j-1]) {
                if(exist(board, word.substring(1), i, j - 1, used)) {
                   result = true;
                    return result;
               }
            used[i][j-1] = false;}
        }
        if ( 0 <= (j + 1) && (j + 1) < board[i].length) {
            if (!used[i][j+1]){
                if(exist(board, word.substring(1), i, j + 1, used)) {
                   result = true;
                    return result;
               }
            used[i][j+1] = false;}
        }
        return result;
    }
    
    private boolean[][] generateVisitedGraph(char[][] board) {
        boolean[][] used = new boolean[board.length][];
        for(int i = 0; i < board.length; i++) {
            used[i] = new boolean[board[i].length];
            for(int j = 0; j < board[i].length; j++) {
                used[i][j] = false;
            }
        }
        
        return used;
    }
}