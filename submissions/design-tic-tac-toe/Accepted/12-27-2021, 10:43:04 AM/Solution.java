// https://leetcode.com/problems/design-tic-tac-toe

class TicTacToe {
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        
        if (row == col) {
            diag += currentPlayer;
        }
        
        if (col == (cols.length - row - 1)) {
            antiDiag += currentPlayer;
        }
        
        int n = rows.length;
        
        if (Math.abs(rows[row]) == n ||
           Math.abs(cols[col]) == n ||
           Math.abs(diag) == n ||
           Math.abs(antiDiag) == n) 
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */