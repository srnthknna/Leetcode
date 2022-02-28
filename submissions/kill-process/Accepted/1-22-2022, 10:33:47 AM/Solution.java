// https://leetcode.com/problems/kill-process

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < ppid.size(); i++) {
            if (!graph.containsKey(ppid.get(i))) {
                graph.put(ppid.get(i), new ArrayList<>());
            }
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            
            if (graph.containsKey(curr))
            for (int child : graph.get(curr)) {
                queue.offer(child);
            }
        }
        return result;
    }
}