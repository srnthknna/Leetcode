// https://leetcode.com/problems/excel-sheet-column-title

class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + n % 26);
    }
}