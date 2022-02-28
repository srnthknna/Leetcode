// https://leetcode.com/problems/palindrome-permutation

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] charArray = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'a']++;
        }
                                  
        int noOfOdd = 0;
        for (int i : charArray) {
            if (i % 2 == 1) noOfOdd++;
        }
        
        return noOfOdd <= 1;
    }
}