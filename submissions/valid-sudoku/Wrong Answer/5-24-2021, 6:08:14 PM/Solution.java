// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[i][j] != '.' && !cols.add(board[i][j])) return false;
                int rowInd = 3 * (i / 3);
                int colInd = 3 * (i % 3);
                if (board[rowInd + (j / 3)][colInd + (j % 3)] != '.' && !cube.add(board[rowInd + (j / 3)][colInd + (j % 3)])) return false;
            } 
        }
        return true;
    }
}