// https://leetcode.com/problems/matrix-block-sum

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        
        int[][] a = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = -k; x <= k; x++) {
                    if (i + x >= 0 && i + x < m) {
                        int l = Math.max(j - k, 0);
                        int r = j + k + 1;
                        a[i + x][l] += mat[i][j];
                        if (r < n) a[i + x][r] -= mat[i][j];
                    }
                }
            }
        }
        
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += a[i][j];
                a[i][j] = sum;
            }
        }
        return a;
    }
}