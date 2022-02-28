// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length, maxqlen = 0, prev = 0;;
        int[] dp = new int[col + 1];
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(Math.min(prev, dp[j - 1]), dp[j]);
                    maxqlen = Math.max(maxqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        
        return maxqlen * maxqlen;
    }
}