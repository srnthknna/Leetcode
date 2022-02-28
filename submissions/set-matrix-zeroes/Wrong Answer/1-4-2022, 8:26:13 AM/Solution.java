// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int r = matrix.length;
        int c = matrix[0].length;
        
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (matrix[0][0] == 0) {
            for (int i = 1; i < c; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (isCol) {
            for (int i = 1; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}