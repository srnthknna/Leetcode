// https://leetcode.com/problems/minimum-depth-of-binary-tree

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
    public int minDepth(TreeNode root) {
        List<TreeNode> curr = new ArrayList<>(), next;
        int depth = 0;
        if (root == null) return depth;
        curr.add(root);
        while (!curr.isEmpty()) {
            next = new ArrayList<>();
            for (TreeNode n : curr) {
                if (n != null) {
                    if (n.left == null && n.right == null) return ++depth;
                    else next.add(n.left); next.add(n.right);
                }
            }
            depth++;
            curr = next;
        }
        return depth;
    }
}