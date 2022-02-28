// https://leetcode.com/problems/reverse-prefix-of-word

class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int ind = word.indexOf(ch);
        for (int i = ind; i >= 0; i--)
            sb.append(word.charAt(i));
        for (int i = ind + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}