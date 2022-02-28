// https://leetcode.com/problems/palindrome-permutation

class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                charMap.remove(s.charAt(i));
            } else {
                charMap.put(s.charAt(i), 1);
            }   
        }
        
        return charMap.size() <= 1;
    }
}