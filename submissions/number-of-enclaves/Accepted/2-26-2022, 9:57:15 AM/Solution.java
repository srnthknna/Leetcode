// https://leetcode.com/problems/number-of-enclaves

class Solution {
    private static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // first row
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid, visited);
            }
        }
        
        // last row
        for (int j = 0; j < cols; j++) {
            if (grid[rows - 1][j] == 1) {
                dfs(rows - 1, j, grid, visited);
            }
        }
        
        // first col
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, visited);
            }
        }
        
        // last col
        for (int i = 0; i < rows; i++) {
            if (grid[i][cols - 1] == 1) {
                dfs(i, cols - 1, grid, visited);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || visited[row][col] || grid[row][col] == 0) return;
        
        visited[row][col] = true;
        
        for (int[] dir : dirs) {
            int nextRow = dir[0] + row;
            int nextCol = dir[1] + col;
            dfs(nextRow, nextCol, grid, visited);
        }
    }
}