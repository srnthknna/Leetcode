// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (p1, p2) -> (p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]));
        
        int maxDef = Integer.MIN_VALUE, ans = 0;
        for (int[] prop : properties) {
            if (prop[1] < maxDef) ans++;
            maxDef = Math.max(maxDef, prop[1]);
        }
        return ans;
    }
}