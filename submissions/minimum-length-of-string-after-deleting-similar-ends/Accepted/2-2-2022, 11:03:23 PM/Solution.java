// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends

class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char curr = s.charAt(i);
            while (i < s.length() - 1 && s.charAt(i) == curr) i++;
            while (j >= 0 && s.charAt(j) == curr) j--;
        }
        if (i > j) return 0;
        return j - i + 1;
    }
}