// https://leetcode.com/problems/matrix-diagonal-sum

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            if (i != (mat.length - i - 1)) {
                sum += mat[i][i] + mat[i][mat.length - i - 1];
            } else {
                sum += mat[i][i];
            }
        }
        return sum;
    }
}