// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));
        int goalNode = graph.length - 1;
        while (!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            int lastNode = curr.get(curr.size() - 1);
            if (lastNode == goalNode) {
                result.add(curr);
            } else {
                int[] neigh = graph[lastNode];
                for (int n : neigh) {
                    List<Integer> newCurr = new ArrayList<>(curr);
                    newCurr.add(n);
                    queue.add(newCurr);
                }
            }
        }
        return result;
    }
}