// https://leetcode.com/problems/sum-root-to-leaf-numbers

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
    int rootToLeaf = 0;
    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return rootToLeaf;
    }
    
    private void preOrder(TreeNode root, int currNumber) {
        if (root != null) {
            currNumber = currNumber * 10 + root.val;
        
            if (root.left == null && root.right == null) {
                rootToLeaf += currNumber;
            }
            preOrder(root.left, currNumber);
            preOrder(root.right, currNumber);
        }
    }
}