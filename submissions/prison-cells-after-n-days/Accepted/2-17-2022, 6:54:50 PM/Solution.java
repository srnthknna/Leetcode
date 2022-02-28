// https://leetcode.com/problems/prison-cells-after-n-days

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = n % 14 == 0 ? 14 : n % 14;
        for (int i = 0; i < n; i++) {
            int[] cells2 = new int[8];
            for (int j = 1; j < 7; j++) {
                cells2[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }
            cells = cells2;
        }
        return cells;
    }
}