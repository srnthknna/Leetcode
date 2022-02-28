// https://leetcode.com/problems/minimum-moves-to-equal-array-elements

class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE, moves = 0;
        for (int i : nums)
            if (i > max)
                max = i;
        for (int i : nums)
            moves += max - i;
        return moves;
    }
}