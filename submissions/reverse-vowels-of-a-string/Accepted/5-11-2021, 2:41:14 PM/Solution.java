// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        while (start < end) {
            while (start<end && !vowels.contains(chars[start]+"")) start++;
            while (start<end && !vowels.contains(chars[end]+"")) end--;
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}