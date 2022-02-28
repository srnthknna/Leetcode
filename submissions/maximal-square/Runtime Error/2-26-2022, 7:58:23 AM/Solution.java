// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, answer = 0;
        int[][] maxOnes = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    maxOnes[i][j] = Math.min(maxOnes[i - 1][j], Math.min(maxOnes[j - 1][i], maxOnes[i - 1][j - 1])) + 1;
                    answer = Math.max(maxOnes[i][j], answer);
                }
            }
        }
        return answer * answer;
    }
}