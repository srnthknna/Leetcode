// https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter

class Solution {
    public int countLetters(String S) {
        
        int count = 1;
        int ans = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            ans += count;
        }
        return ans;
    }
}