// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length, c= colSum.length;
        int[] rSum = new int[r];
        int[] cSum = new int[c];
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int origR = rowSum[i];
                int origC = colSum[j];
                
                int diffR = origR - rSum[i];
                int diffC = origC - cSum[j];
                
                res[i][j] = Math.min(diffR, diffC);
                rSum[i] += res[i][j];
                cSum[j] += res[i][j];
            }
        }
        return res;
    }
}