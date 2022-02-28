// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row

class Solution {
    private int check(int x, int[] A, int[] B) {
        int rotA = 0, rotB = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) rotA++;
            else if (B[i] != x) rotB++;
        }
        return Math.min(rotA, rotB);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rots = check(tops[0], tops, bottoms);
        if (rots != -1 || tops[0] == bottoms[0]) return rots;
        else return check(bottoms[0], bottoms, tops);
    }
}