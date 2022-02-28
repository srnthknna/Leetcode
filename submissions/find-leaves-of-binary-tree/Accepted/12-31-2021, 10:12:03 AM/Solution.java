// https://leetcode.com/problems/find-leaves-of-binary-tree

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
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        while (root != null) {
            List<Integer> curr = new ArrayList<>();
            root = helper(root, curr);
            result.add(curr);
        }
        return result;
    }
    
    private TreeNode helper(TreeNode root, List<Integer> curr) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                curr.add(root.val);
                return null;
            } else {
                root.left = helper(root.left, curr);
                root.right = helper(root.right, curr);
            }
        }
        return root;
    }
}