// https://leetcode.com/problems/path-sum

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        Stack<TreeNode> node_stack = new Stack();
        Stack<Integer> sum_stack = new Stack();
        
        node_stack.add(root);
        sum_stack.add(sum - root.val);
        
        while (!node_stack.isEmpty()) {
            TreeNode node = node_stack.pop();
            int curr_sum = sum_stack.pop();

            if (node.left == null && node.right == null && curr_sum == 0) return true;
            
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
            
            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
        }
        return false;
    }
}