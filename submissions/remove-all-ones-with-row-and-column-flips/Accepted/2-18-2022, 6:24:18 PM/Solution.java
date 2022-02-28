// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips

class Solution {
    public boolean removeOnes(int[][] grid) {
        for (int[] row : grid) {
            for (int i = 1; i < row.length; i++) {
                if (Math.abs(row[i] - grid[0][i]) != Math.abs(row[0] - grid[0][0])) return false;
            }
        }
        return true;
    }
}