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
                } else if (tops[i] == bottoms[i] && first.contains(tops[i])) {
                    first = new HashSet();
                    first.add(bottoms[i]);
                }
            }
        }
        int i = 1;
        while (i < tops.length) {
            if (bottoms[i] == tops[0] && tops[i] != tops[0]) {
                ans++;
            }
            i++;
        }
        
        i = 1; 
        int newans = 0;
        while (i < tops.length) {
            if (tops[i] == bottoms[0] && bottoms[i] != bottoms[0]) {
                newans++; 
            }
            i++;
        }
        if (ans == 0) return newans;
        if (newans == 0) return ans;
        return Math.min(ans, newans);
    }
}