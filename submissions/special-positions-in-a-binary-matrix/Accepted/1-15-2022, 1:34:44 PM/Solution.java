// https://leetcode.com/problems/special-positions-in-a-binary-matrix

class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] rows = new int[row], cols = new int[col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    cols[j]++;
                    rows[i]++;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}