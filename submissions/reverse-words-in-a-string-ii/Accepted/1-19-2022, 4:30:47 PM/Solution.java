// https://leetcode.com/problems/reverse-words-in-a-string-ii

class Solution {
    
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
    
    private void reverseEachWord(char[] s) {
        int n = s.length;
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && s[end] != ' ') end++;
            
            reverse(s, start, end - 1);
            start = end + 1;
            end++;
        }
    }
    
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseEachWord(s);
    }
}