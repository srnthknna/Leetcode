// https://leetcode.com/problems/lucky-numbers-in-a-matrix

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int[] minRow = new int[row];
        int[] maxCol = new int[col];
        for (int i = 0; i < col; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < row; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            maxCol[i] = max;
        }
        
        for (int i = 0; i < row; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < col; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minRow[i] = min;
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == maxCol[j] && matrix[i][j] == minRow[i])
                    result.add(matrix[i][j]);
            }
        }
        return result;
    }
}