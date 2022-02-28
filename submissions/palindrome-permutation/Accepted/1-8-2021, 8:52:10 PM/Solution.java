// https://leetcode.com/problems/palindrome-permutation

class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            } else {
                charMap.put(s.charAt(i), 1);
            }
            
        }
                                  
        int noOfOdd = 0;
        for (int i : charMap.values()) {
            if (i % 2 == 1) noOfOdd++;
        }
        
        return noOfOdd <= 1;
    }
}