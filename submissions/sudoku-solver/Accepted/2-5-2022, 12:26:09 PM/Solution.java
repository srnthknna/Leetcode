// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0 , 0);
    }
    
    private boolean solveSudoku(char[][] board, int i, int j) {
        if (i == board.length || j == board[0].length) return true;
        int ni = 0, nj = 0;
        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        
        if (board[i][j] != '.') {
            if (solveSudoku(board, ni, nj))
                return true;
        } else {
            for (char p = '1'; p <= '9'; p++) {
                if (isValid(board, i, j, p)) {
                    board[i][j] = p;
                    if (solveSudoku(board, ni, nj))
                        return true;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j, char p) {
        //check col
        for (int aj = 0; aj < board[0].length; aj++) {
            if (board[i][aj] == p) return false;
        }
        
        // check row
        for (int ai = 0; ai < board.length; ai++) {
            if (board[ai][j] == p) return false;
        }
        
        // check submatrix
        int smi = i / 3 * 3, smj = j / 3 * 3;
        for (int ai = 0; ai < 3; ai++) {
            for (int aj = 0; aj < 3; aj++) {
                if (board[ai + smi][aj + smj] == p) return false;
            }
        }
        return true;
            
    }
}