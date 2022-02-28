// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int column = 0, minCol = 0, maxCol = 0;
        Map<Integer, List<Integer>> indexToNodes = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<TreeNode, Integer>(root, 0));
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode currRoot = curr.getKey();
            Integer currCol = curr.getValue();
            
            if (currRoot != null) {
                if (!indexToNodes.containsKey(currCol)) {
                    indexToNodes.put(currCol, new ArrayList<>());
                }
                if (currRoot != null) {
                    indexToNodes.get(currCol).add(currRoot.val);
                }
                minCol = Math.min(minCol, currCol);
                maxCol = Math.max(maxCol, currCol);
                queue.offer(new Pair<>(currRoot.left, currCol - 1));
                queue.offer(new Pair<>(currRoot.right, currCol + 1));
            }
        }
        
        for (int i = minCol; i <= maxCol; i++) {
            result.add(indexToNodes.get(i));
        }
        
        return result;
    }
}