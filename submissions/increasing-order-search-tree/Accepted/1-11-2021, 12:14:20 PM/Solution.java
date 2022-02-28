// https://leetcode.com/problems/increasing-order-search-tree

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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        TreeNode ans = new TreeNode(0), cur = ans;
        inorder(root, vals);
        for (int v : vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        
        return ans.right;
    }
    
    private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) return;
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}