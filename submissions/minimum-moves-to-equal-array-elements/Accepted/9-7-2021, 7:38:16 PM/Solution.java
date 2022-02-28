// https://leetcode.com/problems/minimum-moves-to-equal-array-elements

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, moves = 0;
        for (int i : nums)
            if (i < min)
                min = i;
        for (int i : nums)
            moves += i - min;
        return moves;
    }
}