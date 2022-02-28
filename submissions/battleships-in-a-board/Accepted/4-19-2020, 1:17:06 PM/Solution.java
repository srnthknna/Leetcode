// https://leetcode.com/problems/battleships-in-a-board

class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        
        int ships = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                ships++;
            }
        }
        return ships;
    }
}