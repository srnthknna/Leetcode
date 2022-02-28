// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] mat = new int[n][m];
        int count = 0;
        for (int[] index : indices) {
            int row = index[0], col = index[1];
            for (int i = 0; i < n; i++) {
                if (++mat[i][col] % 2 == 1) count++;
                else count--;
            }
            for (int j = 0; j < m; j++) {
                if (++mat[row][j] % 2 == 1) count++;
                else count--;
            }
        }
        return count;
    }
}