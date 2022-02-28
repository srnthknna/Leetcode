// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] relation : prerequisites) {
            int preReqCourse = relation[0];
            int reqCourse = relation[1];
            
            indegree[reqCourse]++;
            List<Integer> adjacencies = adj.getOrDefault(preReqCourse, new ArrayList<>());
            adjacencies.add(reqCourse);
            adj.put(preReqCourse, adjacencies);
        }
        
        int coursesTaken = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int result[] = new int[n], index = n - 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            coursesTaken += size;
            
            for (int i = 0; i < size; i++) {
                int currCourse = queue.poll();
                result[index--] = currCourse;
                List<Integer> adjacencies = adj.getOrDefault(currCourse, new ArrayList<>());
                
                for (int course : adjacencies) {
                    indegree[course]--;
                    
                    if (indegree[course] == 0) {
                        queue.offer(course);
                    }
                }
            }
        }

        if (coursesTaken != n) return new int[0];
        return result;
    }
}