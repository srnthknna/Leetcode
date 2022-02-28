// https://leetcode.com/problems/average-of-levels-in-binary-tree

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>(), next = new ArrayList<>();;
        curr.add(root);
        while(!curr.isEmpty()) {
            next = new ArrayList();
            double avg = 0;
            int count = 0;
            for (TreeNode n : curr) {
                if (n != null) {
                    avg = avg + n.val;
                    count++;
                    if (n.left != null)
                        next.add(n.left);
                    if (n.right != null)
                        next.add(n.right);
                }
            }
            
            if (count != 0) averages.add(avg / count);   
            curr = next;
        }
        return averages;
    }
}