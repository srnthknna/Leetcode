// https://leetcode.com/problems/surrounded-regions

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length, col = board[0].length;
        
        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }
        
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'E';
        for (int[] d : dirs) {
            dfs(board, i + d[0], j + d[1]);
        }
    }
}