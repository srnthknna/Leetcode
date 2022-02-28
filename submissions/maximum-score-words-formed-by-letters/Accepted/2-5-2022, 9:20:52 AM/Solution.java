// https://leetcode.com/problems/maximum-score-words-formed-by-letters

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] fletters = new int[26];
        for (char c : letters)
            fletters[c - 'a']++;
        return maxScoreWords(words, fletters, score, 0);
    }
    
    public int maxScoreWords(String[] words, int[] letters, int[] score, int index) {
        if (index == words.length) return 0;
        
        int sno = maxScoreWords(words, letters, score, index + 1);
        
        String word = words[index];
        int sword = 0;
        boolean isPossible = true;
        
        for (char ch : word.toCharArray()) {
            if (letters[ch - 'a'] == 0) {
                isPossible = false;
            }
            letters[ch - 'a']--;
            sword += score[ch - 'a'];
        }
        
        int syes = 0;
        if (isPossible) {
            syes = sword + maxScoreWords(words, letters, score, index + 1);
        }
        
        for (char ch : word.toCharArray()) {
            letters[ch - 'a']++;
        }
        
        return Math.max(syes, sno);
    }
    
}