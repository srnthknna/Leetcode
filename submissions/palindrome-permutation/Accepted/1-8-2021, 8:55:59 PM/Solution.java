// https://leetcode.com/problems/palindrome-permutation

class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> charSet = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(i));
            } else {
                charSet.add(s.charAt(i));
            }   
        }
        
        return charSet.size() <= 1;
    }
}