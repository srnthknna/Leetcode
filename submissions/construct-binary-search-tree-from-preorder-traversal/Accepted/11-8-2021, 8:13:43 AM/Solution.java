// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal

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
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int lower, int upper) {
        if (index > preorder.length - 1) return null;
        
        int val = preorder[index];
        
        if (val < lower || val > upper) return null;
        
        index++;
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, lower, val);
        root.right = helper(preorder, val, upper);
        return root;
    }
}