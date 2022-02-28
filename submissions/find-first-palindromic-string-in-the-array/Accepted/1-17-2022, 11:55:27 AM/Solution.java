// https://leetcode.com/problems/find-first-palindromic-string-in-the-array

class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word))
                return word;
        }
        return "";
    }
    
    private boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j))
                return false;
        }
        return true;
    }
}