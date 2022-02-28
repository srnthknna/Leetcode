// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}