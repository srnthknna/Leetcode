// https://leetcode.com/problems/expressive-words

class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (check(s, word)) res++;
        }
        return res;
    }
    
    private boolean check(String s, String word) {
        int i = 0, j = 0, n = s.length(), m = word.length();
        for (;i < n; i++) {
            if (j < m && s.charAt(i) == word.charAt(j)) j++;
            else if (i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2));
            else if (0 < i && i < n - 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1));
            else return false;
        }
        return j == m;
    }
}