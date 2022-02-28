// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (Character c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        
        int ans = 0;
        for (String word: words) {
            ans += isPossible(word, Arrays.copyOf(count, count.length));
        }
        return ans;
    }
    
    private int isPossible(String word, int[] count) {
        for (Character c : word.toCharArray()) {
            if (count[c - 'a'] > 0) count[c - 'a']--;
            else return 0;
        }
        return word.length();
    }
}