// https://leetcode.com/problems/battleships-in-a-board

class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        
        int ships = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    ships++;
                    dfs(board, i, j);
                }
            }
        }
        return ships;
    }
    
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }
}