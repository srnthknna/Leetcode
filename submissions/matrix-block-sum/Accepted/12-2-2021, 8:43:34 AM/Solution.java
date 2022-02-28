// https://leetcode.com/problems/matrix-block-sum

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] rangesum = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rangesum[i + 1][j + 1] = rangesum[i + 1][j] + rangesum[i][j + 1] - rangesum[i][j] + mat[i][j];
            }
        }
        
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int r2 = Math.min(m, i + k + 1);
                int c1 = Math.max(j - k, 0);
                int c2 = Math.min(n, j + k + 1);
                ans[i][j] = rangesum[r2][c2] + rangesum[r1][c1] - rangesum[r1][c2] - rangesum[r2][c1];
            }
        }
        return ans;
    }
}