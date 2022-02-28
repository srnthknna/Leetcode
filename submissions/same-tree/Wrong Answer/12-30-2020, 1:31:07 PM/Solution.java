// https://leetcode.com/problems/same-tree

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        else if (p != null && q == null || p == null && q != null) return false;
        else if (p.val == q.val) {
            return isSameTree(p.right, q.left) && isSameTree(p.left, q.right);
        }
        return false;
    }
}