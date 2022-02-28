// https://leetcode.com/problems/excel-sheet-column-number

class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (Character c : s.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }
}