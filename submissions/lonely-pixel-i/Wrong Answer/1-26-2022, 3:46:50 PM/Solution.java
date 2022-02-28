// https://leetcode.com/problems/lonely-pixel-i

class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0) return 0;
        int row = picture.length, col = picture[0].length, ans = 0;
        int[] rows = new int[row], cols = new int[col];
        
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
        
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[i] == 1)
                    ans++;
        return ans;
    }
}