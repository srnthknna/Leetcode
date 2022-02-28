// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] seen = new int[n];
        for (List<Integer> edge : edges)
            seen[edge.get(1)] = 1;
        for (int i = 0; i < n; i++)
            if (seen[i] == 0)
                result.add(i);
        return result;
    }
}