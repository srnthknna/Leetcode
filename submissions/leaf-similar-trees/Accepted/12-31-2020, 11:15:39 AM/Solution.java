// https://leetcode.com/problems/leaf-similar-trees

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> rl1 = new ArrayList<>(), rl2 = new ArrayList<>();
        dfs(root1, rl1);
        dfs(root2, rl2);
        if (rl1.size() != rl2.size()) return false;
        for (int i = 0; i < rl1.size(); i++) {
            if (rl1.get(i) != rl2.get(i)) return false;
        }
        return true;
    }
    
    private void dfs(TreeNode root, List l) {
        if (root == null) return;
        if (root.left == null && root.right == null) l.add(root.val);
        dfs(root.left, l);
        dfs(root.right, l);
    }
}