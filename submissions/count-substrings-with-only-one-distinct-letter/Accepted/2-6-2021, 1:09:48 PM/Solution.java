// https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter

class Solution {
    public int countLetters(String S) {
        // Non Dp with arith progression
        // int count = 0;
        // for (int left = 0, right = 0; right <= S.length(); right++) {
        //     if (right == S.length() || S.charAt(left) != S.charAt(right)) {
        //         int len = right - left;
        //         count += (len + 1) * len / 2;
        //         left = right;
        //     }
        // }
        // return count;
        
        // DP
        int total  = 1, count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                count = 1;
            } else {
                count++;
            }
            total += count;
        }
        return total;
    }
}