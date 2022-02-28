// https://leetcode.com/problems/binary-search-tree-iterator-ii

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
class BSTIterator {
    
    List<Integer> arr;
    int n;
    int pointer;
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        inorder(root);
        n = arr.size();
        pointer = -1;
    }
    
    public boolean hasNext() {
        return pointer < n - 1;
    }
    
    public int next() {
        pointer++;
        return arr.get(pointer);
    }
    
    public boolean hasPrev() {
        return pointer > 0;
    }
    
    public int prev() {
        pointer--;
        return arr.get(pointer);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */