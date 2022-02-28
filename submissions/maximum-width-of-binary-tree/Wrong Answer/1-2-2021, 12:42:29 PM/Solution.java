// https://leetcode.com/problems/maximum-width-of-binary-tree

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
    // Map<Integer, Integer> positionsMap;
    // int max_width;
    public int widthOfBinaryTree(TreeNode root) {
        // max_width = 0;
        // positionsMap = new HashMap<>();
        // compute(root, 0, 0);
        // return max_width;
        
        
        int max_width = 0;
        List<TreeNode> curr = new ArrayList<>(), next;
        curr.add(root);
        
        while (!curr.isEmpty()) {
            next = new ArrayList<>();
            
            for (TreeNode n: curr) {
                if (n.left !=  null)
                    next.add(n.left);
                if (n.right !=  null)
                    next.add(n.right);
            }
        
            max_width = Math.max(max_width, next.size());
            curr = next;
        }
        
        return max_width + 1;
    }
    
    // private void compute(TreeNode root, int depth, int positions) {
    //     if (root == null) return;
    //     positionsMap.computeIfAbsent(depth, x -> positions);
    //     max_width = Math.max(max_width, positions - positionsMap.get(depth) + 1);
    //     compute(root.left, depth + 1, positions * 2);
    //     compute(root.right, depth + 1, positions * 2 + 1);
    // }
}