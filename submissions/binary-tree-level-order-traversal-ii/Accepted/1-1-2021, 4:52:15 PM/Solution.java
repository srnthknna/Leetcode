// https://leetcode.com/problems/binary-tree-level-order-traversal-ii

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<TreeNode> curr = new ArrayList<>(), next;
        LinkedList<List<Integer>> output = new LinkedList<>();
        List<Integer> row;
        
        if (root == null) return output;
        curr.add(root);
        
        while(!curr.isEmpty()) {
            next = new ArrayList<>();
            row = new ArrayList<>();
            for (TreeNode n : curr) {
                row.add(n.val);
                if (n.left != null)
                   next.add(n.left);
                if (n.right != null)
                   next.add(n.right);
            }
            output.addFirst(row);
            
            curr = next;
        }
        
        return output;
    }
}