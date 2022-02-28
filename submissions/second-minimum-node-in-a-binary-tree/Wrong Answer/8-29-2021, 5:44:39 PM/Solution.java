// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree

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
    public int findSecondMinimumValue(TreeNode root) {
        int mini = root.val;
        int ans = Integer.MAX_VALUE;
        
        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> next;
        
        current.add(root);
        
        while(!current.isEmpty()) {
            next = new ArrayList<>();
            for (TreeNode node : current) {
                if (mini < node.val && node.val < ans) {
                    ans = node.val;
                } else if (mini > node.val) {
                    ans = mini;
                    mini = node.val;
                }
                
                if (node.left != null)
                    next.add(node.left);
                if (node.right != null)
                    next.add(node.right);
            }
            
            current = next;
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
    
}