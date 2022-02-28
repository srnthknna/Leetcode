// https://leetcode.com/problems/minimum-knight-moves

class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0 , 0});
        
        boolean[][] visited = new boolean[607][607];
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                if (curr[0] == x && curr[1] == y)
                    return steps;
                
                for (int[] offset : offsets) {
                    int[] next = new int[] {curr[0] + offset[0], curr[1] + offset[1]};
                    if (!visited[next[0] + 302][next[1] + 302]) {
                        visited[next[0] + 302][next[1] + 302] = true;
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}