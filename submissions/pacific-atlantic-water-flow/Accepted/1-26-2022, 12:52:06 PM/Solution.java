// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {
    int dirs[][] = {{1, 0}, {0 , 1}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;
        
        int row = heights.length, col = heights[0].length;
        boolean[][] pacific = new boolean[row][col], atlantic = new boolean[row][col];
        
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);
        }
        
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (atlantic[i][j] && pacific[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    
    private void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return;
        if (matrix[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        for (int[] d : dirs) {
            dfs(matrix, i + d[0], j + d[1], matrix[i][j], ocean);
        }
    }
}