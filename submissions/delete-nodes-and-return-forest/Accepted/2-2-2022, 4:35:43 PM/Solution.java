// https://leetcode.com/problems/delete-nodes-and-return-forest

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
    // https://www.youtube.com/watch?v=BmpXMtA0oF8
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        
        for (int to_del : to_delete) {
            set.add(to_del);
        }
        
        List<TreeNode> ans = new ArrayList<>();
        helper(root, set, ans);
        
        if (!set.contains(root.val)) {
            ans.add(root);
        }
        
        return ans;
    }
    
    private TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> ans) {
        if (root == null) return root;
        root.left = helper(root.left, set, ans);
        root.right = helper(root.right, set, ans);
        
        if (set.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            return null;
        }
        
        return root;
    }
}