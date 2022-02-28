// https://leetcode.com/problems/subrectangle-queries

class SubrectangleQueries {

    int[][] mat;
    public SubrectangleQueries(int[][] rectangle) {
        mat = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++)
            Arrays.fill(mat[i], col1, col2 + 1, newValue);
    }
    
    public int getValue(int row, int col) {
        return mat[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */