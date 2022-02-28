// https://leetcode.com/problems/maximum-length-of-pair-chain

class Solution {
    public int findLongestChain(int[][] pairs) {
        int cur = Integer.MIN_VALUE, ans = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        for (int[] pair: pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }
}