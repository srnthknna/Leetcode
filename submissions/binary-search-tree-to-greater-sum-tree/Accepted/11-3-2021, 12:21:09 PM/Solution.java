// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

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
    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root, 0);
        return root;
    }
    
    private void bstToGst(TreeNode root, int parentSum) {
        if (root == null) return;
        
        root.val = root.val + parentSum + childSum(root.right);
        bstToGst(root.left, root.val);
        bstToGst(root.right, parentSum);
    }
    
    private int childSum(TreeNode root) {
        if (root == null) return 0;
        
        return root.val + childSum(root.left) + childSum(root.right);
    }
}