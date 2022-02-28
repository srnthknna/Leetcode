// https://leetcode.com/problems/robot-return-to-origin

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        
        for (char m : moves.toCharArray()) {
            if (m == 'U') x -= 1;
            else if (m == 'D') x += 1;
            else if (m == 'L') y -= 1;
            else y += 1;
        }
        
        return x == 0 && y == 0;
    }
}