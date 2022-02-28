// https://leetcode.com/problems/binary-tree-postorder-traversal

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        
        helper(root, output);
        
        return output;
    }
    
    private void helper(TreeNode root, List output) {
        if (root == null) return;
        helper(root.left, output);
        helper(root.right, output);
        output.add(root.val);
    }
}