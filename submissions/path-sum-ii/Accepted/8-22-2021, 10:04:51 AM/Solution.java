// https://leetcode.com/problems/path-sum-ii

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
    
    private void preorder(List<List<Integer>> paths, List<Integer> path, TreeNode root, int sum) {
        
        if (root == null) return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && sum - root.val == 0) {
            paths.add(new ArrayList<>(path));
        } else {
            preorder(paths, path, root.left, sum - root.val);
            preorder(paths, path, root.right, sum - root.val);
        }
        path.remove(path.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        if (root == null) return paths;
        
        preorder(paths, path, root, targetSum);
        return paths;
    }
}