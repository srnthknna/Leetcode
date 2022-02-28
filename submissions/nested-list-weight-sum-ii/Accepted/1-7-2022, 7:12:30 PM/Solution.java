// https://leetcode.com/problems/nested-list-weight-sum-ii

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        int depth = 1, maxDepth = 1, sum = 0, product = 0;
        queue.addAll(nestedList);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth = Math.max(maxDepth, depth);
            for (int i = 0; i < size; i++) {
                NestedInteger curr = queue.poll();
                if (curr.isInteger()) {
                    sum += curr.getInteger();
                    product += depth * curr.getInteger();
                } else {
                    queue.addAll(curr.getList());
                }
            }
            depth++;
        }
        return (maxDepth + 1) * sum - product;
    }
}