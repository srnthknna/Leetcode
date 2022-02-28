// https://leetcode.com/problems/capitalize-the-title

class Solution {
    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();
        for (int i = 0, j = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                if (i - j > 2) {
                    chars[j] = Character.toUpperCase(chars[j]);
                }
                j = i + 1;
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }
}