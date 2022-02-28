// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll(" +", " ");
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        Arrays.sort(words);
        for (String word: words) {
            sb.append(word);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}