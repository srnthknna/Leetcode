// https://leetcode.com/problems/number-of-distinct-islands

class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> paths = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    String path = computePath(grid, i, j, m, n, "X");
                    paths.add(path);
                }
            }
        }
        return paths.size();
    }
    
    private String computePath(int[][] grid, int i, int j, int m ,int n, String direction) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return "O";
        }
        grid[i][j] = 0;
        String left = computePath(grid, i - 1, j, m, n, "L");
        String right = computePath(grid, i + 1, j, m, n, "R");
        String up = computePath(grid, i, j - 1, m, n, "U");
        String down = computePath(grid, i, j + 1, m, n, "D") ;
        return direction + left + right + up + down;
            
    }
    
}