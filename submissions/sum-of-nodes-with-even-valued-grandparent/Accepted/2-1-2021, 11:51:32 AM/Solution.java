// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent

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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false, false);
        return sum;
    }
    
    private void dfs(TreeNode root, boolean isGrandEven, boolean isParentEven) {
        if (isGrandEven) sum += root.val;
        if (root.left != null)
            dfs(root.left, isParentEven, root.val % 2 == 0);
        if (root.right != null)
            dfs(root.right, isParentEven, root.val % 2 == 0);
    }
}