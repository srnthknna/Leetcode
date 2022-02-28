// https://leetcode.com/problems/largest-merge-of-two-strings

class Solution {
    public String largestMerge(String word1, String word2) {
        int l1 = 0, l2 = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 < word1.length() && l2 < word2.length()) {
            if (word1.substring(l1).compareTo(word2.substring(l2)) > 0) {
                sb.append(word1.charAt(l1++));
            } else {
                sb.append(word2.charAt(l2++));
            }
        }
        sb.append(word1.substring(l1));
        sb.append(word2.substring(l2));
        return sb.toString();
    }
}