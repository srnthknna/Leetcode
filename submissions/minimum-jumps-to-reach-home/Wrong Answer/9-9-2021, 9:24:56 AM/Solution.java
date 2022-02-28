// https://leetcode.com/problems/minimum-jumps-to-reach-home

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int val : forbidden)
            set.add(val);
        
        int[] visited = new int[2 * 2000];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int at = cur[0], jump = cur[1], isback = cur[2];
            
            if (at == x) return jump;
            
            if (at + a < 2 * 2000 && !set.contains(at + a) && visited[at + a] < 4) {
                q.add(new int[]{at + a, jump + 1, 0});
                visited[at + a]++;
            }
            if (at - b >= 0 && isback == 0 && !set.contains(at - b) && visited[at - b] < 4) {
                q.add(new int[]{at - b, jump + 1, 1});
                visited[at - b]++;
            }
        }
        return -1;
    }
}