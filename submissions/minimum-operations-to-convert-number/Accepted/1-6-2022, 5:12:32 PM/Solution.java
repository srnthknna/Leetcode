// https://leetcode.com/problems/minimum-operations-to-convert-number

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] visited = new boolean[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(goal);
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                if (curr == start) {
                    return step;
                }
                
                for (int val : nums) {
                    for (int next : generateNext(curr, val)) {
                        helper(queue, next, visited);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    private void helper(Queue<Integer> queue, int num, boolean[] visited) {
        if (num >= 0 && num <= 1000 && !visited[num]) {
            queue.offer(num);
            visited[num] = true;
        }
    }
    
    private List<Integer> generateNext(int num, int val) {
        return Arrays.asList(num + val, num - val, num ^ val);
    }
}