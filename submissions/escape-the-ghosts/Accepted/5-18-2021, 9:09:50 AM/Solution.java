// https://leetcode.com/problems/escape-the-ghosts

class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int ghostDist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (ghostDist <= myDist) return false;
        }
        return true;
    }
}