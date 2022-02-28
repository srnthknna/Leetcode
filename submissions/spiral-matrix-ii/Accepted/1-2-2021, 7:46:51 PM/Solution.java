// https://leetcode.com/problems/spiral-matrix-ii

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int rowBegin = 0, colBegin = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1; 
        
        int count = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd ) {
            for (int i = colBegin; i <= colEnd; i++, count++) {
                matrix[rowBegin][i] = count;
            }
            rowBegin++;
            
            for (int i = rowBegin; i <= rowEnd; i++, count++) {
                matrix[i][colEnd] = count;
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--, count++) {
                    matrix[rowEnd][i] = count;
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--, count++) {
                    matrix[i][colBegin] = count;
                }
            }
            colBegin++;
        }
        return matrix;
    }
}