// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] mat = new int[n][m];
        for (int[] index : indices) {
            int row = index[0], col = index[1];
            for (int i = 0; i < n; i++) mat[i][col]++;
            for (int j = 0; j < m; j++) mat[row][j]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++)
           for (int j = 0; j < m; j++)
               if (mat[i][j] % 2 == 1) count++;
        return count;
    }
}