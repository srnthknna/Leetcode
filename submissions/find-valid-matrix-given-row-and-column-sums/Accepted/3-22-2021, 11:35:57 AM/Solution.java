// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        int i = 0, j = 0;
        while(i < rowSum.length && j < colSum.length) {
            res[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] = rowSum[i] - res[i][j];
            colSum[j] = colSum[j] - res[i][j];

            if (rowSum[i] == 0) i++;
            if (colSum[j] == 0) j++;
        }
        return res;
    }
}