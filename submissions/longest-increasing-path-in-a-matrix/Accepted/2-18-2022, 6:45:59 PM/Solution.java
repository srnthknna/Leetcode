// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    Integer[][] memo;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        memo = new Integer[row][col];
        
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, solve(i, j, matrix));
            }
        }
        return ans;
    }
    
    private int solve(int row, int col, int[][] matrix) {
        if (memo[row][col] != null) return memo[row][col];
        
        int ans = 0;
        
        for (int[] d : dirs) {
            int newRow = row + d[0], newCol = col + d[1];
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length || matrix[newRow][newCol] <= matrix[row][col]) continue;
            ans = Math.max(ans, solve(newRow, newCol, matrix));
        }
        
        ans++;
        memo[row][col] = ans;
        return ans;
    }
}