// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

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
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, k);
    }
    
    private boolean inorder(TreeNode root, int k) {
        if (root == null) return false;
        if (root != null) {
            if (set.contains(k - root.val)) {
                return true;
            } else
                set.add(root.val);
        }
        return inorder(root.left, k) || inorder(root.right, k);
    }
}