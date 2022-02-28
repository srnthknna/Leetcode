// https://leetcode.com/problems/implement-strstr

class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        
        for (int i = 0; i + len2 - 1 < len1; i++) {
            if (haystack.charAt(i) == needle.charAt(0))
                if (haystack.substring(i, i + len2).equals(needle)) return i;
        }
        return -1;
    }
}