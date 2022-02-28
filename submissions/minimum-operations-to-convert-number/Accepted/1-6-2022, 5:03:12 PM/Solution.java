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
                    
                    if (num1 >= 0 && num1 <= 1000 && !visited[num1]) {
                        queue.offer(num1);
                        visited[num1] = true;
                    }
                    
                    if (num2 >= 0 && num2 <= 1000 && !visited[num2]) {
                        queue.offer(num2);
                        visited[num2] = true;
                    }

                    if (num3 >= 0 && num3 <= 1000 && !visited[num3]) {
                        queue.offer(num3);
                        visited[num3] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}