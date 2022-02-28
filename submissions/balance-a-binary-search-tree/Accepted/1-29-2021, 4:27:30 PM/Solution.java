// https://leetcode.com/problems/balance-a-binary-search-tree

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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return build(0, nodes.size() - 1, nodes);
    }
    
    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) 
            return;
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }
    
    private TreeNode build(int start, int end, List<Integer> nodes) {
        if (start > end) 
            return null;
        int mid = (start + end) / 2;
        
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = build(start, mid - 1, nodes);
        root.right = build(mid + 1, end, nodes);
        return root;
    }
    
}