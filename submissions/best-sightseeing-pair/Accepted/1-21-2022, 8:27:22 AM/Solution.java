// https://leetcode.com/problems/best-sightseeing-pair

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE, aplusi = values[0] + 0;
        
        for (int j = 1; j < values.length; j++) {
            ans = Math.max(ans, aplusi + values[j] - j);
            aplusi = Math.max(aplusi, values[j] + j);
        }
        return ans;
    }
}