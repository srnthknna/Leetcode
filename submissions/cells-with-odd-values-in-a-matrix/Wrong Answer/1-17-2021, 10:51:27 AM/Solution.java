// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        int rOdd = 0, cOdd = 0;
        for (int[] ind : indices) {
            row[ind[0]]++;
            row[ind[1]]++;
        }
        for (int r : row) if (r % 2 == 1) rOdd++;
        for (int c : col) if (c % 2 == 1) cOdd++;
        return n * cOdd + m * rOdd - (2 * rOdd * cOdd);
    }
}