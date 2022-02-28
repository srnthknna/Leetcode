// https://leetcode.com/problems/game-of-life

class Solution {
    int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int activeNeigh = getActiveCount(board, i, j);
                    if (activeNeigh < 2 || activeNeigh > 3) {
                        board[i][j] = -2;
                    }
                } else if (board[i][j] == 0) {
                    int activeNeigh = getActiveCount(board, i, j);
                    if (activeNeigh == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        updateBoard(board);
    }
    
    private int getActiveCount(int[][] board, int i, int j) {
        int activeCount = 0;
        
        for (int[] dir : dirs) {
            int newI = dir[0] + i;
            int newJ = dir[1] + j;

            if (newI >= 0 && newJ >= 0 && newI < board.length && newJ < board[0].length && (board[newI][newJ] == 1 || board[newI][newJ] == -2)) {
                activeCount++;
            }
        }
        
        return activeCount;
    }
    
    private void updateBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -2) board[i][j] = 0;
                if (board[i][j] == -1) board[i][j] = 1;
            }
        }
    }
}