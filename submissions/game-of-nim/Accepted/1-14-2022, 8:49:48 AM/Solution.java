// https://leetcode.com/problems/game-of-nim

class Solution {
    public boolean nimGame(int[] piles) {
        int xr = 0;
        for (int pile : piles) xr ^= pile;
        return xr != 0;
    }
}