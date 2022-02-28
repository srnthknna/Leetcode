// https://leetcode.com/problems/longest-common-subsequence

class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--)
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        return dp[0][0];
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        
        int[] current, previous = new int[text1.length() + 1];
        for (int i = text2.length() - 1; i >= 0; i--) {
            current = new int[text1.length() + 1];
            for (int j = text1.length() - 1; j >= 0; j--) {
                if (text1.charAt(j) == text2.charAt(i)) {
                    current[j] = 1 + previous[j + 1];
                } else {
                    current[j] = Math.max(previous[j + 1], previous[j]);
                }
            }
            previous = current;
        }
        return previous[0];
    }
}