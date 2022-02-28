// https://leetcode.com/problems/number-of-lines-to-write-string

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int line = 0;
        int lastLine = 0;
        int current = 0;
        for (char c : s.toCharArray()) {
            if (lastLine + widths[c - 'a'] > 100) {
                line++;
                lastLine = widths[c - 'a'];
                continue;
            }
            lastLine += widths[c - 'a'];
        }
        result[0] = ++line;
        result[1] = lastLine;
        return result;
    }
}