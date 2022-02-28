// https://leetcode.com/problems/two-sum-bsts

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
    private void inHashSet(TreeNode root, Set<Integer> set, int target) {
        if (root == null) return;
        inHashSet(root.left, set, target);
        set.add(target - root.val);
        inHashSet(root.right, set, target);
    }
    private boolean inCheck(TreeNode root, Set<Integer> set) {
        if (root == null) return false;
        return inCheck(root.left, set) || set.contains(root.val) || inCheck(root.right, set);
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        inHashSet(root1, set, target);
        return inCheck(root2, set);
    }
}