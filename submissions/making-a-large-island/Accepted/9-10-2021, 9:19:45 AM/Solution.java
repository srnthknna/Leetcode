// https://leetcode.com/problems/making-a-large-island

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] A = new int[n * n + 2];
        int index = 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <  n; j++) {
                if (grid[i][j] == 1) {
                    A[index] = dfs(grid, i, j, index++);
                }
            }
        }
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <  n; j++) {
//                     System.out.print(grid[i][j] + " ");
//             }
//             System.out.print("\n");
//         }
        
//         for (int i = 0; i < A.length; i++)
//             System.out.print(A[i] + " ");
//         System.out.print("\n");
        
        boolean hasZero = false;
        int largest = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    hasZero = true;
                Set<Integer> set = new HashSet<>();
                if (i > 0) set.add(grid[i - 1][j]);
                if (j > 0) set.add(grid[i][j - 1]);
                if (i < n - 1) set.add(grid[i + 1][j]);
                if (j < n - 1) set.add(grid[i][j + 1]);
                
                int area = 1;
                for (int vals : set)
                    area += A[vals];
                largest = Math.max(largest, area);
            }
        }
        
        return hasZero ? largest : n * n;
    }
    
    private int dfs (int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid.length - 1 || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = color;
        return 1 + dfs(grid, i - 1, j, color)
            + dfs(grid, i, j - 1, color)
            + dfs(grid, i + 1, j, color)
            + dfs(grid, i, j + 1, color);    
    }
}