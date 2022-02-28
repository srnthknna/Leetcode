// https://leetcode.com/problems/deepest-leaves-sum

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
    public int deepestLeavesSum(TreeNode root) {
        ArrayDeque<TreeNode> cur = new ArrayDeque<>(), next;

        if (root == null) return 0;
        cur.offer(root);
        
        while (!cur.isEmpty()) {
            next = new ArrayDeque<>();
            for (TreeNode node : cur) {
                if (node.left != null) next.offer(node.left);
                if (node.right != null) next.offer(node.right);
            }
            
            if (next.isEmpty()) {
                int sum = 0;
                for (TreeNode node : cur) {
                    sum += node.val;
                }
                return sum;
            }
            cur = next;
        }
        
        return 0;
    }
}