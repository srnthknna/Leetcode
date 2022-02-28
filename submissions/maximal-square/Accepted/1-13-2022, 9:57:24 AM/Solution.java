// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length, maxqlen = 0;
        int[][] dp = new int[row +  1][col + 1];
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    maxqlen = Math.max(maxqlen, dp[i][j]);
                }
            }
        }
        
        return maxqlen * maxqlen;
    }
}