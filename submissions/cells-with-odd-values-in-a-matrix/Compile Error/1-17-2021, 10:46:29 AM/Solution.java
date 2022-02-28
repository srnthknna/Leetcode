// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n], cols = new int[m];
        for(int[] c : ind){
            rows[c[0]]++;
            cols[c[1]]++;
        }
        int r_odd = 0, c_odd = 0;
        for(int r : rows)
            if(r%2 != 0)
                ++r_odd;
        for(int c : cols)
            if(c%2 != 0)
                ++c_odd;
        return r_odd*m+c_odd*n-2*r_odd*c_odd;
    }
}