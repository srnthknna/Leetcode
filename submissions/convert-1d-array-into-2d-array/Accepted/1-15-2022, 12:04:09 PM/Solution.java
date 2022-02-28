// https://leetcode.com/problems/convert-1d-array-into-2d-array

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if ( m * n != original.length) return new int[0][0];
        
        int[][] result = new int[m][n];
        // for (int i = 0; i < original.length; i++) {
        //     result[i / n][i % n] = original[i];
        // }
        
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index++];
            }
        }
        
        return result;
    }
}