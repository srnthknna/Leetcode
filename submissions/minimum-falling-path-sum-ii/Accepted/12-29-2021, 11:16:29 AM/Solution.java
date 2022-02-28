// https://leetcode.com/problems/minimum-falling-path-sum-ii

class Solution {
    public int minFallingPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int n = grid.length;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
            for (int num : grid[i - 1]) {
                if (num < min) {
                    second = min;
                    min = num;
                } else if (num < second) {
                    second = num;
                }
            }
            
            for (int j = 0; j < n; j++) {
                if (grid[i - 1][j] == min) {
                    grid[i][j] += second;
                } else {
                    grid[i][j] += min;
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int val : grid[n - 1]) {
            result = Math.min(val, result);
        }
        return result;
    }
}