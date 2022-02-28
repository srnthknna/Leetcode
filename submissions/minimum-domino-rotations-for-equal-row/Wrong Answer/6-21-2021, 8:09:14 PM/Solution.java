// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Set<Integer> first = new HashSet<>();
        first.add(tops[0]);
        first.add(bottoms[0]);
        int ans = 0;
        for (int i = 1; i < tops.length; i++) {
            if (!first.contains(tops[i]) && !first.contains(bottoms[i])) {
                return -1;
            } else if (first.size() == 2) {
                if (first.contains(tops[i]) && !first.contains(bottoms[i])) {
                    first = new HashSet();
                    first.add(tops[i]);
                } else if (!first.contains(tops[i]) && first.contains(bottoms[i])) {
                    first = new HashSet();
                    first.add(bottoms[i]);
                }
            }
            if (bottoms[i] == tops[0] && tops[i] != tops[0])
                ans++;
            else if (bottoms[0] == tops[i] && bottoms[0] != bottoms[i])
                ans++;
        }
        return ans;
    }
}