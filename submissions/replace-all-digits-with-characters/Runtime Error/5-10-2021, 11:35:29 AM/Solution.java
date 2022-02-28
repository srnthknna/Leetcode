// https://leetcode.com/problems/replace-all-digits-with-characters

class Solution {
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            chars[i + 1] = (char) (chars[i + 1] + chars[i] - '0');
        }
        return String.valueOf(chars);
    }
}