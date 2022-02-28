// https://leetcode.com/problems/matrix-diagonal-sum

class Solution {
    public int diagonalSum(int[][] mat) {
        int l = mat.length;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if (i != (l - i - 1)) {
                sum += mat[i][i] + mat[i][l - i - 1];
            } else {
                sum += mat[i][i];
            }
        }
        return sum;
    }
}