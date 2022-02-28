// https://leetcode.com/problems/best-meeting-point

class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xcord = new ArrayList<>(), ycord = new ArrayList<>();
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1)
                    xcord.add(i);
        for (int i = 0; i < cols; i++) 
            for (int j = 0; j < rows; j++)
                if (grid[j][i] == 1)
                    ycord.add(i);
        int xmid = xcord.get(xcord.size() / 2), ymid = ycord.get(ycord.size() / 2), dist = 0;
        for (int xval : xcord)
            dist += Math.abs(xval - xmid);
        for (int yval : ycord)
            dist += Math.abs(yval - ymid);
        return dist;
    }
}