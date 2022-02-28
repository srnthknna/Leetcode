// https://leetcode.com/problems/split-bst

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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) return new TreeNode[]{null, null};
        else if (root.val <= target) {
            TreeNode[] bst = splitBST(root.right, target);
            root.right = bst[0];
            bst[0] = root;
            return bst;
        } else {
            TreeNode[] bst = splitBST(root.left, target);
            root.left = bst[1];
            bst[1] = root;
            return bst;
        }
    }
}