// https://leetcode.com/problems/convert-bst-to-greater-tree

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
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }
    
    private void convertBST(TreeNode root, int parentSum) {
        if (root == null) return;
        
        root.val = root.val + parentSum + childSum(root.right);
        convertBST(root.left, root.val);
        convertBST(root.right, parentSum);
    }
    
    private int childSum(TreeNode root) {
        if (root == null) return 0;
        
        return root.val + childSum(root.left) + childSum(root.right);
    }
}