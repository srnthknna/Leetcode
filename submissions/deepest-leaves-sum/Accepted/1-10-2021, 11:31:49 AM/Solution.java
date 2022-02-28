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
        List<TreeNode> cur = new ArrayList<>(), next;

        if (root == null) return 0;
        cur.add(root);
        
        while (!cur.isEmpty()) {
            int sum = 0;
            next = new ArrayList<>();
            for (TreeNode node : cur) {
                sum += node.val;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            
            if (next.isEmpty()) {
                return sum;
            }
            cur = next;
        }
        
        return 0;
    }
}