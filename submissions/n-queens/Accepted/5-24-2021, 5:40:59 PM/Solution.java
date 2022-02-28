// https://leetcode.com/problems/n-queens

class Solution {
    int size;
    List<List<String>> solutions = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        size = n;
        
        // create empty board
        char[][] emptyBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }
    
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        
        return board;
    }
    
    private void backtrack(int row, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag, char[][] state) {
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }
        
        for (int col = 0; col < size; col++) {
            int currentDiag = row - col;
            int currentAntiDiag = row + col;
            
            if (cols.contains(col) || diag.contains(currentDiag) || antiDiag.contains(currentAntiDiag)) continue;
            cols.add(col);
            diag.add(currentDiag);
            antiDiag.add(currentAntiDiag);
            
            state[row][col] = 'Q';
            
            backtrack(row + 1, cols, diag, antiDiag, state);
            
            cols.remove(col);
            diag.remove(currentDiag);
            antiDiag.remove(currentAntiDiag);
            
            state[row][col] = '.';
        }
    }
}