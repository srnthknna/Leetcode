// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, answer = 0;
        int[][] maxOnes = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') {
                        answer = Math.max(answer, 1);
                    }
                } else {
                    if (matrix[i - 1][j] != '0' && matrix[j - 1][i] != '0' && matrix[i - 1][j - 1] != '0') {
                        maxOnes[i][j] = Math.max(matrix[i - 1][j] - '0', Math.max(matrix[j - 1][i] - '0', matrix[i - 1][j - 1] - '0')) + 1;
                        answer = Math.max(maxOnes[i][j], answer);
                    }
                }
            }
        }
        return answer * answer;
    }
}