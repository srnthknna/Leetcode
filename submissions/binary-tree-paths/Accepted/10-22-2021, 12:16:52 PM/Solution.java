// https://leetcode.com/problems/binary-tree-paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        pathBuilder(root, paths, "");
        return paths;
    }
    
    private void pathBuilder(TreeNode root, List<String> paths, String path) {
        if (root == null) return;
        path = path + root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        else {
            pathBuilder(root.left, paths, path + "->");
            pathBuilder(root.right, paths, path + "->");
        }
    }
}