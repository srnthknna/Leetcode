// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers

class Solution {
    public boolean checkValid(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (!rows.add(matrix[i][j]) || !cols.add(matrix[i][j])) return false;
            }
        }
        return true;
    }
}