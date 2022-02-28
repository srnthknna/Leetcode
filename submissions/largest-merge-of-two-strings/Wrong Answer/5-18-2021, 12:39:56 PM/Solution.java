// https://leetcode.com/problems/largest-merge-of-two-strings

class Solution {
    public String largestMerge(String word1, String word2) {
        String ans = "";
        int l1 = 0, l2 = 0;
        while (l1 < word1.length() && l2 < word2.length()) {
            if (word1.compareTo(word2) > 0) {
                ans += word1.charAt(0);
                word1 = word1.substring(1);
                l1++;
            } else {
                ans += word2.charAt(0);
                word2 = word2.substring(1);
                l2++;
            }
        }
        return ans + word1 + word2;
    }
}