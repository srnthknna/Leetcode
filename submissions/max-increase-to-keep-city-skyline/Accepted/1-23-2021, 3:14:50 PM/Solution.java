// https://leetcode.com/problems/max-increase-to-keep-city-skyline

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMax = new int[N];
        int[] colMax = new int[N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return ans;
    }
}