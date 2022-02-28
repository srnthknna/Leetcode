// https://leetcode.com/problems/parallel-courses

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] relation : relations) {
            int preReqCourse = relation[0];
            int reqCourse = relation[1];
            preReqCourse--;
            reqCourse--;
            
            indegree[reqCourse]++;
            List<Integer> adjacencies = adj.getOrDefault(preReqCourse, new ArrayList<>());
            adjacencies.add(reqCourse);
            adj.put(preReqCourse, adjacencies);
        }
        
        int numberOfSem = 0, coursesTaken = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int course : indegree) {
            if (course == 0) {
                queue.offer(course);
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            coursesTaken += size;
            
            for (int i = 0; i < size; i++) {
                int currCourse = queue.poll();
                List<Integer> adjacencies = adj.getOrDefault(currCourse, new ArrayList<>());
                
                for (int course : adjacencies) {
                    indegree[course]--;
                    
                    if (indegree[course] == 0) {
                        queue.offer(course);
                    }
                }
            }
            numberOfSem++;
        }
        return coursesTaken == n ? numberOfSem : -1;
    }
}