// https://leetcode.com/problems/walls-and-gates

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0 ,0};

        if (rooms == null || rooms.length == 0) return;
        int row = rooms.length, col = rooms[0].length;
        
        int EMPTY = Integer.MAX_VALUE, GATE = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int curr_row = curr[0];
                int curr_col = curr[1];
                
                int next_row = curr_row + dx[i];
                int next_col = curr_col + dy[i];
                
                if (next_row < 0 || next_row >= row || next_col < 0 || next_col >= col || rooms[next_row][next_col] != EMPTY) {
                    continue;
                }
                
                rooms[next_row][next_col] = rooms[curr_row][curr_col] + 1;
                queue.offer(new int[] {next_row, next_col});
            }
        }
    }
}