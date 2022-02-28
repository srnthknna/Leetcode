// https://leetcode.com/problems/where-will-the-ball-fall

class Solution {
    //https://leetcode.com/problems/where-will-the-ball-fall/discuss/988576/JavaC++Python-Solution-with-Explanation/905305
    public int[] findBall(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] result = new int[cols];
        
        for (int i = 0; i < cols; i++) {
            int curRow = 0, curCol = i;
            while (curRow < rows) {
                if (grid[curRow][curCol] == 1 && curCol + 1 < cols && grid[curRow][curCol + 1] == 1) {
                    curRow++; curCol++;
                } else if (grid[curRow][curCol] == -1 && curCol - 1 >= 0 && grid[curRow][curCol - 1] == -1) {
                    curRow++; curCol--;
                } else {
                    break;
                }
            }
            result[i] = curRow == rows ? curCol : -1;
        }
        return result;
    }
}