// https://leetcode.com/problems/binary-tree-tilt

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
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        
        //System.out.println("\n\n\n" + root.val);
        if (root.left == null && root.right == null) {
            //root.val = 0;
            return 0;
        }
        
        int left = 0, right = 0;
        if (root.left != null) {
            root.left.val = findTilt(root.left);
            left = root.left.val;
        }
        if (root.right != null) {
            root.right.val = findTilt(root.right);
            right = root.right.val;
        }
        //System.out.println(left + " " + right);
        //System.out.println(root.val);
        return root.val + Math.abs(left + right);
    }
    
}