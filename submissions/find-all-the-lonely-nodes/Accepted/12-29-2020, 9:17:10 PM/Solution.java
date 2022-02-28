// https://leetcode.com/problems/find-all-the-lonely-nodes

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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> onlyC = new ArrayList<>();
        dfs(root, onlyC);
        return onlyC;
    }
    
    private void dfs(TreeNode root, List<Integer> onlyC) {
        if (root == null) return;
        if (root.left != null && root.right == null) onlyC.add(root.left.val);
        if (root.left == null && root.right !=  null) onlyC.add(root.right.val);
        dfs(root.left, onlyC);
        dfs(root.right, onlyC);
    }
}