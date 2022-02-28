// https://leetcode.com/problems/clone-binary-tree-with-random-pointer

/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;
        
        Map<Node, NodeCopy> copy = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            NodeCopy currCopy = new NodeCopy(curr.val);
            copy.put(curr, currCopy);
            
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if (curr.left != null) {
                copy.get(curr).left = copy.get(curr.left);
                queue.offer(curr.left);
            }
            
            if (curr.right != null) {
                copy.get(curr).right = copy.get(curr.right);
                queue.offer(curr.right);
            }
            
            if (curr.random != null) {
                copy.get(curr).random = copy.get(curr.random);
            }
        }
        
        return copy.get(root);
    }
}