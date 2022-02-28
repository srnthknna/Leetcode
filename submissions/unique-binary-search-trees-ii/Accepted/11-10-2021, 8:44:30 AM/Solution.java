// https://leetcode.com/problems/unique-binary-search-trees-ii

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
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    allTrees.add(current);
                }
            }
        }
        return allTrees;
    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        return generateTrees(1, n);
    }
}