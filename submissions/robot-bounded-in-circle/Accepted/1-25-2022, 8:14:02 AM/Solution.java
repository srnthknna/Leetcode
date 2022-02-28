// https://leetcode.com/problems/robot-bounded-in-circle

class Solution {
    public boolean isRobotBounded(String instructions) {
        char dir = 'N';
        int x = 0, y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                if (dir == 'N') y++;
                else if (dir == 'E') x++;
                else if (dir == 'W') x--;
                else y--;
            } else if (c == 'L') {
                if (dir == 'N') dir = 'W';
                else if (dir == 'W') dir = 'S';
                else if (dir == 'S') dir = 'E';
                else dir = 'N';
            } else {
                if (dir == 'N') dir = 'E';
                else if (dir == 'E') dir = 'S';
                else if (dir == 'S') dir = 'W';
                else dir = 'N';
            }
        }
        return (x == 0 && y == 0 || dir != 'N');
    }
}