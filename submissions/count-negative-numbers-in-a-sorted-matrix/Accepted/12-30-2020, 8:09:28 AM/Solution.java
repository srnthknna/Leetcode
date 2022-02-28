// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix

class Solution {
    public int countNegatives(int[][] grid) {
        int posCount = 0;
        int total = grid.length * grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][0] < 0) {
                    i = grid.length;
                    break;
                } else if (grid[i][j] < 0) {
                    break;
                } 
                
                posCount++;
            }
        }
        return total - posCount;
    }
}