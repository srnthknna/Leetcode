// https://leetcode.com/problems/reverse-words-in-a-string-iii

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(new StringBuilder(words[i]).reverse().toString());
            sb.append(" ");
        }
        sb.append(new StringBuilder(words[words.length - 1]).reverse().toString());
        return sb.toString();
    }
}