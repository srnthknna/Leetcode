// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    int postIndx;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndx = postorder.length - 1;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return buildTreeFromArray(postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTreeFromArray(int[] postorder, int left, int right) {
        if (left > right) return null;
        
        int rootVal = postorder[postIndx--];
        TreeNode root = new TreeNode(rootVal);
        
        root.right = buildTreeFromArray(postorder, inorderMap.get(rootVal) + 1, right);
        root.left = buildTreeFromArray(postorder, left, inorderMap.get(rootVal) - 1);
        return root;
    }
}