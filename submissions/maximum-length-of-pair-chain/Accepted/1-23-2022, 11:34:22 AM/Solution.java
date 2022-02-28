// https://leetcode.com/problems/maximum-length-of-pair-chain

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        int ans = 0, curr = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                ans++;
            }
        }
        return ans;
    }
}