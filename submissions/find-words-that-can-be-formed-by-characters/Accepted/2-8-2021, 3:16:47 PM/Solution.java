// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (Character c : chars.toCharArray()) counts[c - 'a']++;
        
        int count = 0;
        for (String word : words) {
            count += validate(word, Arrays.copyOf(counts, counts.length));
        }
        return count;
    }
    
    private int validate(String word, int[] counts) {
        for (Character c : word.toCharArray()) {
            if (counts[c - 'a'] > 0)
            counts[c - 'a']--;
            else return 0;
        }
        return word.length();
    }
}