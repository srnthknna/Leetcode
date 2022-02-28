// https://leetcode.com/problems/number-of-lines-to-write-string

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 0, lastLine = 0;
        for (char c : s.toCharArray()) {
            if (lastLine + widths[c - 'a'] > 100) {
                line++;
                lastLine = widths[c - 'a'];
                continue;
            }
            lastLine += widths[c - 'a'];
        }
        return new int[] {++line, lastLine};
    }
}