// https://leetcode.com/problems/path-with-maximum-gold

class Solution {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    travelAndCollectGold(grid, i, j, 0);                
                }
            }
        }
        
        return max;
    }
    
    private void travelAndCollectGold(int[][] grid, int i, int j, int sum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            max = Math.max(max, sum);
            return;
        }

        int gridVal = grid[i][j];
        grid[i][j] = 0;
        travelAndCollectGold(grid, i + 1, j, gridVal + sum);
        travelAndCollectGold(grid, i, j + 1, gridVal + sum);
        travelAndCollectGold(grid, i - 1, j, gridVal + sum);
        travelAndCollectGold(grid, i, j - 1, gridVal + sum);
        grid[i][j] = gridVal;
    }
}