// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rows.add(matrix[i][j])) return false;
                if (!cols.add(matrix[j][i])) return false;
            }
        }
        return true;
    }
}