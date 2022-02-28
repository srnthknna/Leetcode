// https://leetcode.com/problems/minimum-falling-path-sum

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = matrix[i - 1][j];
                if (j != 0) {
                    curr = Math.min(curr, matrix[i - 1][j - 1]);
                }
                if (j != n - 1) {
                    curr = Math.min(curr, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += curr;
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int num : matrix[n - 1]) {
            result = Math.min(result, num);
        }
        
        return result;
    }
}