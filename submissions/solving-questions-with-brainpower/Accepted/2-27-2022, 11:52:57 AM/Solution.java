// https://leetcode.com/problems/solving-questions-with-brainpower

// https://leetcode.com/problems/solving-questions-with-brainpower/
// Solution is dp based
// we start from right to left
// we calculate if the future index
// if the future index is within the array length then we update the points with current question points and future question points calculated in dp
// if its more than the array length then we just consider current question points
// lastly we need to find if the curren index has a next question 
// in which case we find the max between this index and the next index
// this last line actually means if we want to skip ith question or not
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int fIndex = i + questions[i][1] + 1;
            if (fIndex < n) {
                dp[i] = dp[fIndex] + questions[i][0];
            } else {
                dp[i] = questions[i][0];
            }
            
            if (i < n - 1) {
                // either choose this question and skip this question
                // if we skip then we choose the previous next question in future pointss whichever is maximum
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
}