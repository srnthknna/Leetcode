// https://leetcode.com/problems/minimum-path-sum

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length, dp[] = new int[col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    dp[j] = grid[i][j];
                else if (i == 0)
                    dp[j] += grid[i][j] + dp[j - 1];
                else if (j == 0)
                    dp[j] += grid[i][j];
                else
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[col - 1];
    }
}