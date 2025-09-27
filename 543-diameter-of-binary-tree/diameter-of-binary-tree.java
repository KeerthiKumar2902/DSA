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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return max;
    }

    private void diameterHelper(TreeNode root) {
        if (root == null) return;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        // Update global max diameter
        max = Math.max(max, leftHeight + rightHeight);

        // Continue recursion
        diameterHelper(root.left);
        diameterHelper(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
