// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            while (start<end && !isVowel(chars[start])) start++;
            while (start<end && !isVowel(chars[end])) end--;
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c =='A' || c == 'E' || c == 'I'  || c == 'O' || c == 'U';
    }
}