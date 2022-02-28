// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game

class Solution {
    public String tictactoe(int[][] moves) {
        int player = 1, n = 3, rows[] = new int[3], cols[] = new int[3], diag = 0, anti = 0;
        
        for (int[] move : moves) {
            int row = move[0], col = move[1];
            
            rows[row] += player;
            cols[col] += player;
            
            if (row == col) diag += player;
            if (row + col == n - 1) anti += player;
            
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n||
               Math.abs(diag) == 3 || Math.abs(anti) == 3)
                return player == 1 ? "A" : "B";
            
            player *= -1;
        }
        
        return moves.length == n * n ? "Draw" : "Pending";
    }
}