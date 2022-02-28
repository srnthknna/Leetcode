// https://leetcode.com/problems/reverse-prefix-of-word

class Solution {
    public String reversePrefix(String word, char ch) {
    final int i = word.indexOf(ch);
    if (i == -1) return word;
    return new StringBuilder(word.substring(0, i + 1))
        .reverse()
        .append(word.substring(i + 1))
        .toString();
    }
}