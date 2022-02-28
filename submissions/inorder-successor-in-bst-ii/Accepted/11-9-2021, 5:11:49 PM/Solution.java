// https://leetcode.com/problems/inorder-successor-in-bst-ii

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node x) {
        System.out.println(x.val);
        if (x.right != null) {
            x = x.right;
            while (x.left != null) x = x.left;
            return x;
        }
        
        while (x.parent != null && x.parent.right == x) x = x.parent;
        return x.parent;
    }
}