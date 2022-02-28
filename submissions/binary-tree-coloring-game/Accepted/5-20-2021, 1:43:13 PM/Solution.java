// https://leetcode.com/problems/binary-tree-coloring-game

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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root == null) return false;
        if (root.val == x) {
            int left = count(root.left);
            int right = count(root.right);
            int parent = n - (left + right + 1);
            return parent > (right + left) || left > right + parent || right > left + parent;
        }
        return btreeGameWinningMove(root.left, n , x) || btreeGameWinningMove(root.right, n, x);
    }
    
    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.right) + count(root.left) + 1;
    }
}