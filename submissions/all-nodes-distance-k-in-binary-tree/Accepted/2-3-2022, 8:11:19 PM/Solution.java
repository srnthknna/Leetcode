// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        // We build the parent links
        buildParent(root, nodeToParent);
        // Create the output list
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr);
                if (curr != null) {
                    if (k == 0) {
                        answer.add(curr.val);
                    }
                    if (nodeToParent.containsKey(curr) && !visited.contains(nodeToParent.get(curr))) {
                        queue.offer(nodeToParent.get(curr));
                    }
                    if (curr.left != null && !visited.contains(curr.left)) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null && !visited.contains(curr.right)) {
                        queue.offer(curr.right);
                    }
                }
            }
            k--;
        }
        return answer;
        
    }
    
    private void buildParent(TreeNode root, Map<TreeNode, TreeNode> nodeToParent) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                nodeToParent.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                nodeToParent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
}