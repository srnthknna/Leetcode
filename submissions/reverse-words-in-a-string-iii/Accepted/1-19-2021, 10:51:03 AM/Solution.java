// https://leetcode.com/problems/reverse-words-in-a-string-iii

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(reverse(words[i]));
            sb.append(" ");
        }
        sb.append(reverse(words[words.length - 1]));
        return sb.toString();
    }
    
    private String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}