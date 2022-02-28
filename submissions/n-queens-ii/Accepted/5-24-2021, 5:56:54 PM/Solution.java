// https://leetcode.com/problems/n-queens-ii

class Solution {
    int size;
    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
    
    private int backtrack(int row, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag) {
        if (row == size) return 1;
        
        int solutions = 0;
        for (int col = 0; col < size; col++) {
            int currentDiag = row - col;
            int currentAntiDiag = row + col;
            
            if (cols.contains(col) || diag.contains(currentDiag) || antiDiag.contains(currentAntiDiag)) continue;
            
            cols.add(col); diag.add(currentDiag); antiDiag.add(currentAntiDiag);
            solutions += backtrack(row + 1, cols, diag, antiDiag);
            cols.remove(col); diag.remove(currentDiag); antiDiag.remove(currentAntiDiag);
        }
        return solutions;
    }
}