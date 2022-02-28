// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (Character c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        
        int ans = 0;
        for (String word: words) {
            ans += isPossible(word, count);
        }
        return ans;
    }
    
    private int isPossible(String word, int[] count) {
        boolean flag = true;
        for (Character c : word.toCharArray()) {
            if (count[c - 'a'] > 0) count[c - 'a']--;
            else {
                flag = false;
            }
        }
        for (Character c : word.toCharArray()) {
            count[c - 'a']++;
        }
        
        return flag ? word.length() : 0;
    }
}