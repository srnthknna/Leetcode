// https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword

class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        String wordReverse = sb.append(word).reverse().toString();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if (canPlaceHorizontally(board, i, j, word) || 
                           canPlaceVertically(board, i, j, word)) return true;
                } else if (board[i][j] == ' ' || board[i][j] == wordReverse.charAt(0)) {
                    if (canPlaceHorizontally(board, i, j, wordReverse) ||
                           canPlaceVertically(board, i, j, wordReverse)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean canPlaceHorizontally(char[][] board, int i , int j, String word) {
        if (j - 1 >= 0 && board[i][j - 1] != '#') return false;
        else if (j + word.length() < board[0].length && board[i][j + word.length()] != '#') return false;
        
        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= board[0].length) return false;
            
            if (board[i][j + jj] == ' ' || board[i][j + jj] == word.charAt(jj)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean canPlaceVertically(char[][] board, int i , int j, String word) {
        if (i - 1 >= 0 && board[i - 1][j] != '#') return false;
        else if (i + word.length() < board.length && board[i + word.length()][j] != '#') return false;
        
        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= board.length) return false;
            
            if (board[i + ii][j] == ' ' || board[i + ii][j] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}