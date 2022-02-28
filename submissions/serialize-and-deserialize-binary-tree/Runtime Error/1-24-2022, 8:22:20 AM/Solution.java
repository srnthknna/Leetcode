// https://leetcode.com/problems/serialize-and-deserialize-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("n ");
                continue;
            }
            sb.append(curr.val + " ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] nodes = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        
        queue.offer(root);
        for (int index = 1; index < nodes.length; index++) {
            TreeNode curr = queue.poll();

            if (!nodes[index].equals("n")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[index++]));
                queue.offer(curr.left);
            }
            if (!nodes[index].equals("n")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[index++]));
                queue.offer(curr.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));