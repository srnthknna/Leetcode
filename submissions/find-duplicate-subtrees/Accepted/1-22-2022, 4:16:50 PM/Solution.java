// https://leetcode.com/problems/find-duplicate-subtrees

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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        Map<String, Integer> serial = new HashMap<>();
        serialize(root, nodes, serial);
        return nodes;
    }
    
    private String serialize(TreeNode root, List<TreeNode> nodes, Map<String, Integer> serial) {
        if (root == null) return "";
        
        String curr = root.val + "," + serialize(root.left, nodes, serial) + "," + serialize(root.right, nodes, serial);
        
        serial.put(curr, serial.getOrDefault(curr, 0) + 1);
        if (serial.get(curr) == 2) {
            nodes.add(root);
        }
        return curr;
    }
}