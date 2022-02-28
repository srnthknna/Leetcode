// https://leetcode.com/problems/maximum-height-by-stacking-cuboids

class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cube : cuboids)
            Arrays.sort(cube);
        Arrays.sort(cuboids, (c1, c2) -> (c1[0] + c1[1] + c1[2]) - (c2[0] + c2[1] + c2[2]));
        
        int dp[] = new int[cuboids.length], max = 0;
        
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0]
                   && cuboids[j][1] <= cuboids[i][1]
                   && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}