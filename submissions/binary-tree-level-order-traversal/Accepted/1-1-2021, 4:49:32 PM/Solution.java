// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> curr = new ArrayList<>(), next;
        List<List<Integer>> output = new ArrayList<>();
        
        if (root == null) return output;
        curr.add(root);
        
        while(!curr.isEmpty()) {
            next = new ArrayList<>();
            for (TreeNode n : curr) {
                if (n.left != null)
                   next.add(n.left);
                if (n.right != null)
                   next.add(n.right);
            }
            output.add(curr.stream().map(n -> n.val).collect(Collectors.toList()));
            
            curr = next;
        }
        
        return output;
    }
}