// https://leetcode.com/problems/binary-tree-inorder-traversal

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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();

        TreeNode current = root;
        
        while(current !=  null || !stack.isEmpty()) {
            while (current !=  null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            output.add(current.val);
            current = current.right;
        }
        
        return output;
    }
    
    // private void helper(TreeNode root, List output) {
    //     if (root == null) return;
    //     helper(root.left, output);
    //     output.add(root.val);
    //     helper(root.right, output);
    // }
}