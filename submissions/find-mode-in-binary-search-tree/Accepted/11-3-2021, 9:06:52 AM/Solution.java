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
    Integer prev;
    int max = Integer.MIN_VALUE;
    int count = 1;
    
    public int[] findMode(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);
        
        int[] returnArr = new int[answer.size()];
        int ind = 0;
        for (int num : answer) 
            returnArr[ind] = answer.get(ind++);
        return returnArr;
    }
    
    private void inorder(TreeNode root, List<Integer> answer) {
        if (root == null) return;
        
        inorder(root.left, answer);
        
        if (prev != null) {
            if (prev == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        
        if (count > max) {
            max = count;
            answer.clear();
            answer.add(root.val);
        } else if (count == max) {
            answer.add(root.val);
        }
        prev = root.val;
        
        inorder(root.right, answer);
    }
}