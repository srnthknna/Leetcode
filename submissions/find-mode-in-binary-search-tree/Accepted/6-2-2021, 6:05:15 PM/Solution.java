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
// With map
class Solution1 {
    Map<Integer, Integer> map;
    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        if (root == null) return new int[0];
        
        inorder(root);
        
        List<Integer> keys = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                keys.add(key);
            }
        }
        
        int[] result = new int[keys.size()];

        for (int i = 0; i < keys.size(); i++) {
            result[i] = keys.get(i);
        }
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

// O(1) without map
class Solution {
    Integer prev = null;
    int count = 1;
    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
        
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (prev == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}