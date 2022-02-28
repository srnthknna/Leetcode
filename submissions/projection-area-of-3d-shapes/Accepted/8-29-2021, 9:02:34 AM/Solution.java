// https://leetcode.com/problems/projection-area-of-3d-shapes

class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int brow = 0;
            int bcol = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) ans++;
                brow = Math.max(brow, grid[i][j]);
                bcol = Math.max(bcol, grid[j][i]);
            }
            ans += brow + bcol;
        }
        return ans;
    }
}