// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal

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
    int preIndx = 0, postIndx = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndx++]);
        if (root.val != postorder[postIndx]) {
            root.left = constructFromPrePost(preorder, postorder);
        }
        if (root.val != postorder[postIndx]) {
            root.right = constructFromPrePost(preorder, postorder);
        }
        postIndx++;
        return root;
    }
}