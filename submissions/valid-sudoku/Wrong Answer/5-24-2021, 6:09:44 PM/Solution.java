// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[i][j] != '.' && !cols.add(board[j][i])) return false;
                int rowInd = 3 * (i / 3);
                int colInd = 3 * (i % 3);
                if (board[rowInd + (j / 3)][colInd + (j % 3)] != '.' && !cube.add(board[rowInd + (j / 3)][colInd + (j % 3)])) return false;
            } 
        }
        return true;
    }
}