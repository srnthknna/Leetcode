// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        s = s.replaceAll("-", "");
        StringBuilder sb = new StringBuilder(s);

        for (int i = s.length() - k; i > 0; i = i - k) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }
}