// https://leetcode.com/problems/rings-and-rods

class Solution {
    public int countPoints(String ringsChars) {
        int[][] rods = new int[10][3];
        for (int i = 0; i < ringsChars.length() - 1; i += 2) {
            int rod = ringsChars.charAt(i + 1) - '0';
            if (ringsChars.charAt(i) == 'R') {
                rods[rod][0]++;
            } else if (ringsChars.charAt(i) == 'G') {
                rods[rod][1]++;
            } else if (ringsChars.charAt(i) == 'B') {
                rods[rod][2]++;
            }
        }
        
        int count = 0;
        for (int[] rings : rods) {
            int curr = 0;
            for (int ring : rings)
                if (ring > 0)
                curr++;
            if (curr == 3)
                count++;
        }
        return count;
    }
}