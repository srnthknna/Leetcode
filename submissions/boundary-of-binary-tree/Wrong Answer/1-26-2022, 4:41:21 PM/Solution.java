// https://leetcode.com/problems/boundary-of-binary-tree

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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        result.add(root.val);
        TreeNode cacheRoot = root;
        
        // Print Left;
        printLeft(root.left, result);
        
        
        // Print Leaf;
        printLeaf(root, result);
        
        
        // Print Right;
        printRight(root.right, result);
        
        
        return result;
    }
    
    private void printRight(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.right != null) {
            printRight(root.right, result);
            result.add(root.val);
        } else if (root.left != null) {
            printRight(root.left, result);
            result.add(root.val);
        }
    }
    
    private void printLeaf(TreeNode root, List<Integer> result) {
        if (root == null) return;
        printLeaf(root.left, result);
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        printLeaf(root.right, result);
    }
    
    private void printLeft(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left != null) {
            result.add(root.val);
            printLeft(root.left, result);
        } else if (root.right != null) {
            result.add(root.val);
            printLeft(root.right, result);
        }
    }
}