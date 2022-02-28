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
                    int num1 = curr + val;
                    int num2 = curr - val;
                    int num3 = curr ^ val;

                    helper(queue, num1, visited);
                    helper(queue, num2, visited);
                    helper(queue, num3, visited);
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
}