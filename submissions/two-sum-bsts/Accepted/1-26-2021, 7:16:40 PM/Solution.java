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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = inHashSet(root1, target, new HashSet());
        return inCheck(root2, set);
    }
    
    private boolean inCheck(TreeNode root2, Set<Integer> set) {
        if (root2 == null) return false;
        return inCheck(root2.left, set) || set.contains(root2.val) || inCheck(root2.right, set);
    }
    
    private Set<Integer> inHashSet(TreeNode root1, int target, Set<Integer> set) {
        if (root1 == null) return set;
        inHashSet(root1.left, target, set);
        set.add(target - root1.val);
        inHashSet(root1.right, target, set);
        return set;
    }
}