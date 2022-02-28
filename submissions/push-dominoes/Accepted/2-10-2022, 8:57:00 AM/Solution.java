// https://leetcode.com/problems/push-dominoes

class Solution {
    // Similar to https://leetcode.com/problems/shortest-distance-to-a-character/submissions/
    // Checked https://www.youtube.com/watch?v=Z2x-zalsebs&list=WL&index=2&ab_channel=NickWhite
    public String pushDominoes(String dominoes) {
        char[] domino = dominoes.toCharArray();
        int n = domino.length;
        int[] forces = new int[n];
        
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (domino[i] == 'R') {
                force = n;
            } else if (domino[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }
        
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (domino[i] == 'L') {
                force = n;
            } else if (domino[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int f : forces) {
            if (f > 0) sb.append('R');
            else if (f < 0) sb.append('L');
            else sb.append('.');
        }
        return sb.toString();
    }
}