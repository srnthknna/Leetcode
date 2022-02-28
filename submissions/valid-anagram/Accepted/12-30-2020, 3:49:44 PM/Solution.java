// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t != null) return false;
        else if (s != null && t == null) return false;
        else if (s.length() != t.length()) return false;
        
        int[] table = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        
        for (int n : table) {
            if (n != 0) return false;
        }
        
        return true;
    }
}