// https://leetcode.com/problems/find-mode-in-binary-search-tree

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
    Map<Integer, Integer> map;
    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        if (root == null) return new int[0];
        
        inorder(root);
        
        List<Integer> keys = map.keySet().stream().filter(k -> max == map.get(k)).collect(Collectors.toList());
        System.out.println(keys);
        int[] result = new int[keys.size()];

        for (int i = 0; i < keys.size(); i++)
            result[i] = keys.get(i);
        return result;
        
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        inorder(root.right);
    }
}